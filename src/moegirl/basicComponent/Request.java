package moegirl.basicComponent;

public class Request {

	/*
	 * Request���Ŀ���Ǽ�¼������Ϣ
	 * ���Դ����Լ��������
	 */
	
	public String URL = null;
	public int retryTimes = 0;
	
	public Request(String URL) {
		super();
		this.URL = URL;
	}
	
//	private int maxRetryTimes = 3;
}
