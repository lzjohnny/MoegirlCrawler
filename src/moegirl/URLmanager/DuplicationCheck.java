package moegirl.URLmanager;

import java.util.HashSet;

public class DuplicationCheck {

	/*
	 * ����ѡ��String������Request
	 * δ�ظ���String��URL�Żᱻ��װ��Request
	 */
	
	private HashSet<String> hashSet = new HashSet<String>();
	
	//��������Ϊ��̬����������ʣ�
	public boolean isDuplicated(String URL) {
		return !(hashSet.add(URL));		
	}
	
	/*
	 * ��ȡ����������
	 */
	public int getURLAmount() {
		return hashSet.size();
	}
}
