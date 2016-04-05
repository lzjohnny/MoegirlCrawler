package moegirl.URLmanager;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import moegirl.basicComponent.Request;

public class URLmanager {

	/*
	 * 阻塞队列 生产者-消费者
	 * 新获得的URL利用HashMap去重后，待抓取URL放置于队列中
	 * 未成功URL直接添加队列
	 */
	
	BlockingQueue<Request> blockingQueue = new LinkedBlockingQueue<Request>();
	DuplicationCheck duplicationCheck = new DuplicationCheck();
	
	/*
	 * 重复、添加队列失败均返回false
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
