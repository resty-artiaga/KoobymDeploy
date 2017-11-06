package com.koobym.pusher;

import org.springframework.stereotype.Component;

import com.koobym.model.UserNotification;
import com.pusher.rest.Pusher;

@Component
public class PusherServer {

	private Pusher pusher;

	public PusherServer() {
		pusher = new Pusher("426875", "0aa2ef5ad16d9caba80a", "1dee74d0541f9fb0ca16");
		pusher.setCluster("ap1");
	}

	public void sendNotification(UserNotification userNotification) {
		pusher.trigger(Long.toString(userNotification.getUser().getUserId()), "notification-event", userNotification);
	}
}
