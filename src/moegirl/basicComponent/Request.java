package moegirl.basicComponent;

public class Request {

	/*
	 * Request类的目的是记录额外信息
	 * 重试次数以及更多参数
	 */
	
	public String URL = null;
	public int retryTimes = 0;
	
	public Request(String URL) {
		super();
		this.URL = URL;
	}
	
//	private int maxRetryTimes = 3;
}
