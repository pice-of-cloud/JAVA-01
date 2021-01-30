package io.lvxy.gateway.v2.client;

import org.apache.http.Header;
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

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class HttpClientTest {
	
    public static void main( String[] args ) throws ClientProtocolException, IOException   {
    	HttpClientTest clientTest = new HttpClientTest();
    	//String url ="https://www.baidu.com";
    	//String url ="http://localhost:8804/test";
    	//clientTest.doGetTestOne(url);
    	//clientTest.doPostTestOne(url);
		//System.out.println(clientTest.doGetTestDefault());
		HttpGet httpGet = new HttpGet("https://www.baidu.com");
		System.out.println(clientTest.doGet(httpGet));

    }

	public String doGet(HttpGet httpGet) {

		StringBuffer msg = new StringBuffer();
		// 获得Http客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建Get请求
		if(httpGet == null){
			httpGet = new HttpGet("https://www.baidu.com");
		}
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
				msg.append("get-响应内容为: "+string);
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

		httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		httpGet.setHeader("Accept-Encoding", "gzip, deflate");
		httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36");

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
     		try{
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
