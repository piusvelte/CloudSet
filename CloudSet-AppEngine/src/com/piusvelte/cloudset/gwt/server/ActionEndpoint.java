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

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.users.User;

@Api(name = "actionendpoint",
namespace = @ApiNamespace(ownerDomain = "piusvelte.com", ownerName = "piusvelte.com", packagePath = "cloudset.gwt.server"),
clientIds = {Ids.WEB_CLIENT_ID, Ids.ANDROID_CLIENT_ID},
audiences = {Ids.ANDROID_AUDIENCE})
public class ActionEndpoint {

	private static final DeviceEndpoint endpoint = new DeviceEndpoint();

	public void add(User user, Action action)
			throws IOException {
		Sender sender = new Sender(Ids.API_KEY);

		EntityManager mgr = getEntityManager();

		List<Device> devices;
		try {
			devices = endpoint.list(user, action.getName(), null);
			if ((devices != null) && (devices.size() > 0)) {
				
				action.setTimestamp(System.currentTimeMillis());
				mgr.persist(action);
				
				for (Device device : devices) {
					if (!device.getDeviceRegistrationID().equals(action.getDevice())) {
						doSendViaGcm(user, action.getName(), action.getValue(), sender, device);
					}
				}
			}
		} catch (OAuthRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mgr.close();
		}
	}

	private static Result doSendViaGcm(User user, String name, String value, Sender sender, Device device) throws IOException {
		Message msg = new Message.Builder().addData("name", name).addData("value", value).build();
		Result result = sender.send(msg, device.getDeviceRegistrationID(), 5);
		if (result.getMessageId() != null) {
			String canonicalRegId = result.getCanonicalRegistrationId();
			if (canonicalRegId != null) {
				try {
					endpoint.remove(user, device.getDeviceRegistrationID());
					device.setDeviceRegistrationID(canonicalRegId);
					endpoint.add(user, device);
				} catch (OAuthRequestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			String error = result.getErrorCodeName();
			if (error.equals(Constants.ERROR_NOT_REGISTERED)) {
				try {
					endpoint.remove(user, device.getDeviceRegistrationID());
				} catch (OAuthRequestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}
}
