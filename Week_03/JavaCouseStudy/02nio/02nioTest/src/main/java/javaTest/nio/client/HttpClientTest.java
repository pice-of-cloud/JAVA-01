package javaTest.nio.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 *
 */
public class HttpClientTest{
	
    public static void main( String[] args ) throws ClientProtocolException, IOException   {
    	HttpClientTest clientTest = new HttpClientTest();
    	//String url ="https://www.baidu.com";
    	//String url ="http://localhost:8804/test";
    	//clientTest.doGetTestOne(url);
    	//clientTest.doPostTestOne(url);
		System.out.println(clientTest.doGetTestDefault());
    }

	public String doGetTestDefault() {
		String url = "https://www.baidu.com";
		StringBuffer msg = new StringBuffer();
		// 获得Http客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建Get请求
		HttpGet httpGet = new HttpGet(url);

		// 响应模型
		CloseableHttpResponse response = null;
		try {

			// 配置信息
			RequestConfig requestConfig = RequestConfig.custom()
					// 设置连接超时时间(单位毫秒)
					.setConnectTimeout(50000)
					// 设置请求超时时间(单位毫秒)
					.setConnectionRequestTimeout(5000)
					// socket读写超时时间(单位毫秒)
					.setSocketTimeout(5000)
					// 设置是否允许重定向(默认为true)
					.setRedirectsEnabled(true).build();

			// 将上面的配置信息 运用到这个Get请求里
			httpGet.setConfig(requestConfig);
			// 由客户端执行(发送)Get请求
			response = httpClient.execute(httpGet);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();

			//System.out.println("get-响应状态为:" + response.getStatusLine());
			//msg.append("get-响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				String string = EntityUtils.toString(responseEntity, "utf-8");
				//System.out.println("get-响应内容长度为:" + responseEntity.getContentLength());
				//System.out.println("get-响应内容为:" + string);
				//msg.append("get-响应内容长度为:" + responseEntity.getContentLength());
				msg.append("get-响应内容为:" + string);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return msg.toString();
	}
	public void doGetTestOne(String url) {
		// 获得Http客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建Get请求
		HttpGet httpGet = new HttpGet(url);
 
		// 响应模型
		CloseableHttpResponse response = null;
		try {
			
			// 配置信息
			RequestConfig requestConfig = RequestConfig.custom()
					// 设置连接超时时间(单位毫秒)
					.setConnectTimeout(50000)
					// 设置请求超时时间(单位毫秒)
					.setConnectionRequestTimeout(5000)
					// socket读写超时时间(单位毫秒)
					.setSocketTimeout(5000)
					// 设置是否允许重定向(默认为true)
					.setRedirectsEnabled(true).build();
					
			// 将上面的配置信息 运用到这个Get请求里
			httpGet.setConfig(requestConfig);	
			// 由客户端执行(发送)Get请求
			response = httpClient.execute(httpGet);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();
			System.out.println("get-响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				String string = EntityUtils.toString(responseEntity, "utf-8");
				System.out.println("get-响应内容长度为:" + responseEntity.getContentLength());
				System.out.println("get-响应内容为:" + string);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    
    public void doPostTestOneDefault(String url) {
    	
        CloseableHttpClient httpClient = HttpClients.createDefault();
       
        HttpPost httpPost = new HttpPost(url);
     // 响应模型
     		CloseableHttpResponse response = null;
     		try {
     			
     			// 配置信息
     			RequestConfig requestConfig = RequestConfig.custom()
     					// 设置连接超时时间(单位毫秒)
     					.setConnectTimeout(5000)
     					// 设置请求超时时间(单位毫秒)
     					.setConnectionRequestTimeout(5000)
     					// socket读写超时时间(单位毫秒)
     					.setSocketTimeout(5000)
     					// 设置是否允许重定向(默认为true)
     					.setRedirectsEnabled(true).build();
     			// 将上面的配置信息 运用到这个Get请求里
     			httpPost.setConfig(requestConfig);	
     			// 由客户端执行(发送)Get请求
     			response = httpClient.execute(httpPost);
     			// 从响应模型中获取响应实体
     			HttpEntity responseEntity = response.getEntity();
     			System.out.println("post-响应状态为:" + response.getStatusLine());
     			if (responseEntity != null) {
     				String string = EntityUtils.toString(responseEntity, "utf-8");
     				System.out.println("post-响应内容长度为:" + responseEntity.getContentLength());
     				System.out.println("post 响应内容为:" + string);
     			}
     		} catch (ClientProtocolException e) {
     			e.printStackTrace();
     		} catch (ParseException e) {
     			e.printStackTrace();
     		} catch (IOException e) {
     			e.printStackTrace();
     		} finally {
     			try {
     				// 释放资源
     				if (httpClient != null) {
     					httpClient.close();
     				}
     				if (response != null) {
     					response.close();
     				}
     			} catch (IOException e) {
     				e.printStackTrace();
     			}
     		}
     	}
}
