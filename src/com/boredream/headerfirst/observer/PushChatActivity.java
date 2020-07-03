package com.boredream.headerfirst.observer;

import java.util.Observable;
import java.util.Observer;

// 模拟页面,push推送模式,直接推送过来消息内容
public class PushChatActivity implements Observer {

	private Observable observable;

	public PushChatActivity(Observable observable) {
		this.observable = observable;
		onStart();
	}

	// 模拟页面生命周期
	protected void onStart() {
		// 注册观察者
		observable.addObserver(this);
	}

	// 模拟页面生命周期
	protected void onStop() {
		// 注销观察者
		observable.deleteObserver(this);
	}

	// 接收到被观察者有更新
	@Override
	public void update(Observable arg0, Object arg1) {
		// 可能注册多个观察者,这里判断一下
		if(arg0 instanceof MessageReceiver) {
			if(arg1 != null) {
				Message msg = (Message) arg1;
				System.out.println("push " + msg);
			}
		}
	}
}
