package com.boredream.headerfirst.observer;

public class Main {
	public static void main(String[] args) {
		MessageReceiver messageReceiver = new MessageReceiver();
		
		PushChatActivity pushChatActivity = new PushChatActivity(messageReceiver);
		PullChatActivity pullChatActivity = new PullChatActivity(messageReceiver);
		
		Message msg = new Message();
		msg.setTitle("title");
		msg.setContent("content");
//		messageReceiver.onReceiverPull(msg);
		messageReceiver.onReceiverPush(msg);
	}
}
