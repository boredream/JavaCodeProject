package com.boredream.headerfirst.observer;

import java.util.Observable;

public class MessageReceiver extends Observable {

	private Message msg;

	public Message getMsg() {
		return msg;
	}

	// 接收到消息,实际情况应该是服务器推送触发,这里模拟主动调用
	public void onReceiverPush(Message msg) {
		// 有参数类型,直接推送给观察者更新数据
		this.msg = msg;
		// 设置有更新标记
		setChanged();
		// 提醒观察者
		notifyObservers(msg);
	}
	
	// 接收到消息,实际情况应该是服务器推送触发,这里模拟主动调用
	public void onReceiverPull(Message msg) {
		// 无参数类型,只是告知观察者有更新
		this.msg = msg;
		setChanged();
		// 提醒观察者
		notifyObservers();
	}

}
