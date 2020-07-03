package com.boredream.headerfirst.observer;

import java.util.Observable;

public class MessageReceiver extends Observable {

	private Message msg;

	public Message getMsg() {
		return msg;
	}

	// ���յ���Ϣ,ʵ�����Ӧ���Ƿ��������ʹ���,����ģ����������
	public void onReceiverPush(Message msg) {
		// �в�������,ֱ�����͸��۲��߸�������
		this.msg = msg;
		// �����и��±��
		setChanged();
		// ���ѹ۲���
		notifyObservers(msg);
	}
	
	// ���յ���Ϣ,ʵ�����Ӧ���Ƿ��������ʹ���,����ģ����������
	public void onReceiverPull(Message msg) {
		// �޲�������,ֻ�Ǹ�֪�۲����и���
		this.msg = msg;
		setChanged();
		// ���ѹ۲���
		notifyObservers();
	}

}
