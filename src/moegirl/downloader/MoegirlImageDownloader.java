package moegirl.downloader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class MoegirlImageDownloader {

	private static final int TIMEOUT_SECONDS = 10;
	private static final String USER_AGENT = "Mozilla/5.0 Firefox/45.0";
	private static final String FILE_PATH = "F:\\HttpClientDownload";

	private CloseableHttpClient httpClient;

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MoegirlImageDownloader downloader = new MoegirlImageDownloader();
		downloader.initApacheHttpClient();

		// String imageUrl =
		String imageURL = "https://img.mengniang.org/common/e/e7/Mutsu.png";

		downloader.fetchContent(imageURL);
		downloader.destoryApacheHttpClient();
	}

	private void initApacheHttpClient() {
		// TODO �Զ����ɵķ������
		RequestConfig config = RequestConfig.custom()
				// .setProxy(new HttpHost(InetAddress.getLocalHost(), 10010))
				.setSocketTimeout(TIMEOUT_SECONDS * 1000)
				.setConnectTimeout(TIMEOUT_SECONDS * 1000).build();

		/**
		 * HttpClients��Factory methods for CloseableHttpClient instances.
		 * HttpClientBuilder��Builder for CloseableHttpClient instances.
		 */
		httpClient = HttpClients.custom().setUserAgent(USER_AGENT)
				.setDefaultRequestConfig(config).build();

	}

	// ���뱣֤�쳣������response��stream����ȷ�رգ�
	private void fetchContent(String imageURL) {
		// TODO �Զ����ɵķ������
		HttpGet httpGet = new HttpGet(imageURL);
		System.out.println("ͼƬ����: " + httpGet.getURI());

		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);

			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println("statusCode: " + statusCode);
			
			if (statusCode == 200) {

				HttpEntity entity = response.getEntity();

				if (entity != null) {

					InputStream inputStream = null;
					OutputStream outputStream = null;
					try {
						inputStream = entity.getContent();
						outputStream = new FileOutputStream(new File(FILE_PATH
								+ "\\2.jpg"));

						IOUtils.copy(inputStream, outputStream);

						outputStream.flush();
					} finally {
						outputStream.close();
						// IOUtils.closeQuietly(outputStream);
					}
				}
			} else {
				System.out.println("Bad StatusCode");
			}
		} catch (IOException e) {

			// errorʱ����3�δ�ʵ��
			System.out.println("download error, URL:" + imageURL);
			System.out.println(e.toString());
			// e.printStackTrace();
		} finally {
			try {
				if (response != null) {

					// consume��close����
					// EntityUtils.consume()�������ĵ�entity��ͬʱ�رյײ����
					// ��finally�л�Ҫ�ر�response
					response.close();
				}
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				System.out.println("close response fail");
				System.out.println(e.toString());
				// e.printStackTrace();
			}
		}

	}

	private void destoryApacheHttpClient() {
		// TODO �Զ����ɵķ������
		try {
			httpClient.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
