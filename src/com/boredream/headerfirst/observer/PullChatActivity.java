package com.boredream.headerfirst.observer;

import java.util.Observable;
import java.util.Observer;

// 模拟页面,pull拉取模式,接收到更新后,再主动去获取数据
public class PullChatActivity implements Observer {

	private Observable observable;

	public PullChatActivity(Observable observable) {
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
			MessageReceiver msgMessageReceiver = (MessageReceiver) arg0;
			System.out.println("pull " + msgMessageReceiver.getMsg());
		}
	}
}
