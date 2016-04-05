package moegirl.URLmanager;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import moegirl.basicComponent.Request;

public class URLmanager {

	/*
	 * �������� ������-������
	 * �»�õ�URL����HashMapȥ�غ󣬴�ץȡURL�����ڶ�����
	 * δ�ɹ�URLֱ����Ӷ���
	 */
	
	BlockingQueue<Request> blockingQueue = new LinkedBlockingQueue<Request>();
	DuplicationCheck duplicationCheck = new DuplicationCheck();
	
	/*
	 * �ظ�����Ӷ���ʧ�ܾ�����false
	 */
	public boolean addURL(String URL) {
		if (!(duplicationCheck.isDuplicated(URL))) {
			
			return blockingQueue.add(new Request(URL));
		} else {
			return false;
		}
	}
	
	public boolean retryAddURL(String URL) {
		return blockingQueue.add(new Request(URL));
	}
	
	public Request getRequest() {
		return blockingQueue.poll();
	}
	
}
