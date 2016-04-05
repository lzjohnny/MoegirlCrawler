package moegirl.main;

import moegirl.URLmanager.URLmanager;
import moegirl.basicComponent.Request;
import moegirl.downloader.MoegirlImageDownloader;

public class Spider {

	public static void main(String[] args) {
//		String imageURL = "https://img.mengniang.org/common/e/e7/Mutsu.png";
		
		MoegirlImageDownloader downloader = new MoegirlImageDownloader();
		URLmanager manager = new URLmanager();
		manager.addURL("https://img.mengniang.org/common/8/8a/%E5%9B%BE%E9%89%B4_%E9%95%BF%E9%97%A8.jpg");
		manager.addURL("https://img.mengniang.org/common/5/5f/%E9%95%BF%E9%97%A8%E5%A4%A7%E7%A0%B4.jpg");
		manager.addURL("https://img.mengniang.org/common/6/6b/%E5%9B%BE%E9%89%B4_%E9%95%BF%E9%97%A8%E6%94%B9.jpg");
		manager.addURL("https://img.mengniang.org/common/8/8d/%E9%95%BF%E9%97%A8%E6%94%B9_%E5%A4%A7%E7%A0%B4.jpg");
		
		//测试重复的URL会自动去除
		manager.addURL("https://img.mengniang.org/common/8/8a/%E5%9B%BE%E9%89%B4_%E9%95%BF%E9%97%A8.jpg");
		manager.addURL("https://img.mengniang.org/common/5/5f/%E9%95%BF%E9%97%A8%E5%A4%A7%E7%A0%B4.jpg");
		manager.addURL("https://img.mengniang.org/common/6/6b/%E5%9B%BE%E9%89%B4_%E9%95%BF%E9%97%A8%E6%94%B9.jpg");
		manager.addURL("https://img.mengniang.org/common/8/8d/%E9%95%BF%E9%97%A8%E6%94%B9_%E5%A4%A7%E7%A0%B4.jpg");
		
		downloader.initApacheHttpClient();
		
		Request imageRequest = null;
		while((imageRequest = manager.getRequest()) != null) {
			downloader.fetchContent(imageRequest.URL);
		}
		
		downloader.destoryApacheHttpClient();
	}
}