package com.boredream.headerfirst.observer;

import java.util.Observable;
import java.util.Observer;

// ģ��ҳ��,push����ģʽ,ֱ�����͹�����Ϣ����
public class PushChatActivity implements Observer {

	private Observable observable;

	public PushChatActivity(Observable observable) {
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
			if(arg1 != null) {
				Message msg = (Message) arg1;
				System.out.println("push " + msg);
			}
		}
	}
}
