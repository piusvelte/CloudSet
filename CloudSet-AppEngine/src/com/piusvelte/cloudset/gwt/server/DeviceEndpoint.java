/*
 * CloudSet - Android devices settings synchronization
 * Copyright (C) 2013 Bryan Emmanuel
 * 
 * This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  
 *  Bryan Emmanuel piusvelte@gmail.com
 */
package com.piusvelte.cloudset.gwt.server;

import com.piusvelte.cloudset.gwt.server.EMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.users.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "deviceendpoint",
namespace = @ApiNamespace(ownerDomain = "piusvelte.com", ownerName = "piusvelte.com", packagePath = "cloudset.gwt.server"),
clientIds = {Ids.WEB_CLIENT_ID, Ids.ANDROID_CLIENT_ID},
audiences = {Ids.ANDROID_AUDIENCE})
public class DeviceEndpoint {

	@SuppressWarnings({ "unchecked" })
	public List<Device> subscribers(
			User user,
			@Named("publisher") String publisher) throws OAuthRequestException {
		if (user != null) {
			List<Device> subscribers;
			EntityManager mgr = getEntityManager();
			try {
				Query query = mgr.createQuery("select from Device as Device where account = :account and id <> :id")
							.setParameter("account", user.getNickname())
							.setParameter("id", publisher);
				subscribers = query.getResultList();
			} finally {
				mgr.close();
			}
			return subscribers;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	public Device get(User user, @Named("id") String id) throws OAuthRequestException {
		if (user != null) {
			EntityManager mgr = getEntityManager();
			Device device = null;
			try {
				device = mgr.find(Device.class, id);
			} finally {
				mgr.close();
			}
			return device;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	public Device add(User user, Device device) throws OAuthRequestException {
		if (user != null) {
			device.setAccount(user.getNickname());
			EntityManager mgr = getEntityManager();
			try {
				if (containsSubscriber(device)) {
					throw new EntityExistsException("Object already exists");
				}
				mgr.persist(device);
			} finally {
				mgr.close();
			}
			return device;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	public List<Action> subscriptions(User user, @Named("subscriber") String subscriberId, @Named("publisher") String publisherId) throws OAuthRequestException {
		if (user != null) {
			EntityManager mgr = getEntityManager();
			List<Action> publications = new ArrayList<Action>();
			Device subscriber;
			try {
				subscriber = mgr.find(Device.class, subscriberId);
				List<Long> subscriptions = subscriber.getSubscriptions();
				// filter on the publisher
				for (Long subscription : subscriptions) {
					Action publication = mgr.find(Action.class, subscription);
					if (publication.getPublisher().equals(publisherId)) {
						publications.add(publication);
					}
				}
			} finally {
				mgr.close();
			}
			return publications;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	public Action subscribe(User user, @Named("subscriber") String subscriberId, @Named("publisher") String publisherId, @Named("action") String action) throws Exception {
		if (user != null) {
			EntityManager mgr = getEntityManager();
			Device subscriber = null;
			Action publication = getPublication(publisherId, action);
			if (publication != null) {
				try {
					subscriber = mgr.find(Device.class, subscriberId);
					if (subscriber.subscribe(publication.getId())) {
						mgr.persist(subscriber);
					}
				} finally {
					mgr.close();
				}
			} else {
				throw new Exception("error creating publication");
			}
			return publication;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	public void unsubscribe(User user, @Named("subscriber") String subscriberId, @Named("publication") Long publication) throws OAuthRequestException {
		if (user != null) {
			EntityManager mgr = getEntityManager();
			Device subscriber = null;
			try {
				subscriber = mgr.find(Device.class, subscriberId);
				if (subscriber.unsubscribe(publication)) {
					mgr.persist(subscriber);
				}
			} finally {
				mgr.close();
			}
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	public Device update(User user, Device subscriber) throws OAuthRequestException {
		if (user != null) {
			EntityManager mgr = getEntityManager();
			try {
				if (!containsSubscriber(subscriber)) {
					throw new EntityNotFoundException("Object does not exist");
				}
				mgr.persist(subscriber);
			} finally {
				mgr.close();
			}
			return subscriber;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	public Device remove(User user, @Named("id") String id) throws OAuthRequestException {
		if (user != null) {
			EntityManager mgr = getEntityManager();
			Device device = null;
			try {
				device = mgr.find(Device.class, id);
				// remove subscriptions, and subscribers
				List<Long> publicationIds = device.getPublications();
				for (Long publicationId : publicationIds){
					Action publication = mgr.find(Action.class, publicationId);
					List<String> subscriberIds = publication.getSubscribers();
					for (String subscriberId : subscriberIds) {
						Device subscriber = mgr.find(Device.class, subscriberId);
						if (subscriber.unsubscribe(publicationId)) {
							mgr.persist(subscriber);
						}
					}
					mgr.remove(publication);
				}
				List<Long> subscriptionIds = device.getSubscriptions();
				for (Long subscriptionId : subscriptionIds) {
					Action subscription = mgr.find(Action.class, subscriptionId);
					if (subscription.removeSubscriber(id)) {
						mgr.persist(subscription);
					}
				}
				mgr.remove(device);
			} finally {
				mgr.close();
			}
			return device;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	private Action getPublication(String publisherId, String actionName) {
		EntityManager mgr = getEntityManager();
		Device publisher = null;
		Action action = null;
		try {
			publisher = mgr.find(Device.class, publisherId);
			List<Long> actionIds = publisher.getPublications();
			for (Long actionId : actionIds) {
				Action a = mgr.find(Action.class, actionId);
				if (a.getName().equals(actionName)) {
					action = a;
					break;
				}
			}
			if (action == null) {
				action = createAction(publisherId, actionName);
				publisher.addPublication(action.getId());
				mgr.persist(publisher);
			}
		} finally {
			mgr.close();
		}
		return action;
	}

	private Action createAction(String publisherId, String actionName) {
		EntityManager mgr = getEntityManager();
		Action action = null;
		try {
			action = new Action();
			action.setPublisher(publisherId);
			action.setName(actionName);
			action.setTimestamp(System.currentTimeMillis());
			mgr.persist(action);
		} finally {
			mgr.close();
		}
		return action;
	}

	private boolean containsSubscriber(Device device) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Device item = mgr.find(Device.class, device.getId());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}