package moegirl.URLmanager;

import java.util.HashSet;

public class DuplicationCheck {

	/*
	 * 泛型选择String而不是Request
	 * 未重复的String类URL才会被封装成Request
	 */
	
	private HashSet<String> hashSet = new HashSet<String>();
	
	//或许设置为静态方法会更合适？
	public boolean isDuplicated(String URL) {
		return !(hashSet.add(URL));		
	}
	
	/*
	 * 爬取的链接总数
	 */
	public int getURLAmount() {
		return hashSet.size();
	}
}
