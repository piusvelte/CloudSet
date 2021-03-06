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
import com.piusvelte.cloudset.gwt.shared.Action;
import com.piusvelte.cloudset.gwt.shared.Device;
import com.piusvelte.cloudset.gwt.shared.SimpleAction;
import com.piusvelte.cloudset.gwt.shared.SimpleDevice;
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
clientIds = {Ids.ANDROID_CLIENT_ID},
audiences = {Ids.ANDROID_AUDIENCE})
public class DeviceEndpoint {

	public static final Long INVALID_DEVICE_ID = Long.valueOf(-1L);

	@SuppressWarnings({ "unchecked" })
	public List<SimpleDevice> list(
			User user) throws OAuthRequestException {
		if (user != null) {
			List<SimpleDevice> simpleDevices = new ArrayList<SimpleDevice>();
			List<Device> devices;
			EntityManager mgr = getEntityManager();

			try {
				Query query = mgr.createQuery("select from Device as Device where account = :account")
						.setParameter("account", user.getNickname());
				devices = query.getResultList();

				for (Device device : devices) {
					SimpleDevice simpleDevice = new SimpleDevice();
					simpleDevice.setId(device.getId());
					simpleDevice.setModel(device.getModel());
					simpleDevices.add(simpleDevice);
				}
			} finally {
				mgr.close();
			}

			return simpleDevices;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<SimpleDevice> subscribers(
			User user,
			@Named("publisher") Long publisher) throws OAuthRequestException {
		if (user != null) {
			List<SimpleDevice> simpleDevices = new ArrayList<SimpleDevice>();
			List<Device> devices;
			EntityManager mgr = getEntityManager();

			try {
				Query query = mgr.createQuery("select from Device as Device where account = :account and id <> :id")
						.setParameter("account", user.getNickname())
						.setParameter("id", publisher);
				devices = query.getResultList();

				for (Device device : devices) {
					SimpleDevice simpleDevice = new SimpleDevice();
					simpleDevice.setId(device.getId());
					simpleDevice.setModel(device.getModel());
					simpleDevices.add(simpleDevice);
				}
			} finally {
				mgr.close();
			}

			return simpleDevices;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	public Device get(User user, @Named("id") Long id) throws OAuthRequestException {
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

	public List<SimpleAction> subscriptions(User user, @Named("subscriber") Long subscriberId, @Named("publisher") Long publisherId) throws OAuthRequestException {
		if (user != null) {
			EntityManager mgr = getEntityManager();
			List<SimpleAction> simpleActions = new ArrayList<SimpleAction>();
			Device subscriber;

			try {
				subscriber = mgr.find(Device.class, subscriberId);
				List<Long> subscriptions = subscriber.getSubscriptions();

				// filter on the publisher
				for (Long subscription : subscriptions) {
					Action action = mgr.find(Action.class, subscription);
					if (action != null && action.getPublisher().equals(publisherId)) {
						SimpleAction simpleAction = new SimpleAction();
						simpleAction.setId(action.getId());
						simpleAction.setName(action.getName());
						simpleActions.add(simpleAction);
					}
				}
			} finally {
				mgr.close();
			}

			return simpleActions;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	public SimpleAction subscribe(User user, @Named("subscriber") Long subscriberId, @Named("publisher") Long publisherId, @Named("action") String actionName) throws Exception {
		if (user != null) {
			Action action;
			SimpleAction simpleAction = new SimpleAction();
			Long publicationId = getPublicationId(publisherId, actionName);
			if (!publicationId.equals(INVALID_DEVICE_ID)) {
				addPublicationToSubscriptions(subscriberId, publicationId);
				action = addSubscriberToPublication(publicationId, subscriberId);
				simpleAction.setId(action.getId());
				simpleAction.setName(action.getName());
			} else {
				throw new Exception("error creating publication");
			}

			return simpleAction;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	private Action addSubscriberToPublication(Long publicationId, Long subscriberId) {
		EntityManager mgr = getEntityManager();
		Action publication = null;

		try {
			publication = mgr.find(Action.class, publicationId);
			publication.subscribe(subscriberId);
		} finally {
			mgr.close();
		}

		return publication;
	}

	private void addPublicationToSubscriptions(Long subscriberId, Long publicationId) {
		EntityManager mgr = getEntityManager();
		Device subscriber = null;

		try {
			subscriber = mgr.find(Device.class, subscriberId);
			subscriber.subscribe(publicationId);
		} finally {
			mgr.close();
		}
	}

	public void unsubscribe(User user, @Named("subscriber") Long subscriberId, @Named("publication") Long publicationId) throws OAuthRequestException {
		if (user != null) {
			removeSubscriberFromPublication(publicationId, subscriberId);
			removePublicationFromSubscriptions(subscriberId, publicationId);
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	private void removeSubscriberFromPublication(Long publicationId, Long subscriberId) {
		EntityManager mgr = getEntityManager();
		Action publication = null;

		try {
			publication = mgr.find(Action.class, publicationId);
			publication.unsubscribe(subscriberId);
		} finally {
			mgr.close();
		}
	}

	private void removePublicationFromSubscriptions(Long subscriberId, Long publicationId) {
		EntityManager mgr = getEntityManager();
		Device subscriber = null;

		try {
			subscriber = mgr.find(Device.class, subscriberId);
			subscriber.unsubscribe(publicationId);
		} finally {
			mgr.close();
		}
	}

	public Device update(User user, Device device) throws OAuthRequestException {
		if (user != null) {
			EntityManager mgr = getEntityManager();

			try {
				if (!containsSubscriber(device)) {
					throw new EntityNotFoundException("Object does not exist");
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

	public Device remove(User user, @Named("id") Long id) throws OAuthRequestException {
		if (user != null) {
			EntityManager mgr = getEntityManager();
			Device device = null;

			try {
				device = mgr.find(Device.class, id);
				if (device != null) {
					// remove subscriptions, and subscribers
					List<Long> publicationIds = device.getPublications();

					for (Long publicationId : publicationIds){
						unpublish(publicationId);
					}

					List<Long> subscriptionIds = device.getSubscriptions();

					for (Long subscriptionId : subscriptionIds) {
						removeSubscriberFromPublication(subscriptionId, id);
					}

					mgr.remove(device);
				}
			} finally {
				mgr.close();
			}

			return device;
		} else {
			throw new OAuthRequestException("Invalid user.");
		}
	}

	private void unpublish(Long publicationId) {
		EntityManager mgr = getEntityManager();
		Action publication = null;

		try {
			publication = mgr.find(Action.class, publicationId);
			List<Long> subscriberIds = publication.getSubscribers();

			for (Long subscriberId : subscriberIds) {
				removePublicationFromSubscriptions(subscriberId, publicationId);
			}

			mgr.remove(publication);
		} finally {
			mgr.close();
		}
	}

	private Long getPublicationId(Long publisherId, String actionName) {
		EntityManager mgr = getEntityManager();
		Device publisher = null;
		Action action = null;

		try {
			publisher = mgr.find(Device.class, publisherId);
			List<Long> actionIds = publisher.getPublications();

			for (Long actionId : actionIds) {
				Action a = mgr.find(Action.class, actionId);

				if (a != null && a.getName().equals(actionName)) {
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

		return action.getId();
	}

	private Action createAction(Long publisherId, String actionName) {
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
		if (device == null || device.getId() == null) return false;
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
