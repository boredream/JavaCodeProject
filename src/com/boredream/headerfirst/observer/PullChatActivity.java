package com.boredream.headerfirst.observer;

import java.util.Observable;
import java.util.Observer;

// ģ��ҳ��,pull��ȡģʽ,���յ����º�,������ȥ��ȡ����
public class PullChatActivity implements Observer {

	private Observable observable;

	public PullChatActivity(Observable observable) {
		this.observable = observable;
		onStart();
	}

	// ģ��ҳ����������
	protected void onStart() {
		// ע��۲���
		observable.addObserver(this);
	}

	// ģ��ҳ����������
	protected void onStop() {
		// ע���۲���
		observable.deleteObserver(this);
	}

	// ���յ����۲����и���
	@Override
	public void update(Observable arg0, Object arg1) {
		// ����ע�����۲���,�����ж�һ��
		if(arg0 instanceof MessageReceiver) {
			MessageReceiver msgMessageReceiver = (MessageReceiver) arg0;
			System.out.println("pull " + msgMessageReceiver.getMsg());
		}
	}
}
