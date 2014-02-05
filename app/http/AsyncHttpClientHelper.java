package http;

import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.AsyncHttpClientConfig.Builder;
import com.ning.http.client.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncHttpClientHelper {
	private static final Logger log = LoggerFactory.getLogger(AsyncHttpClientHelper.class);
	static Builder BUILDER = new AsyncHttpClientConfig.Builder();
	static AsyncHttpClient ASYNCHTTPCLIENT;
	static ExecutorService CACHEDTHREADPOOL;
	
	static {
        CACHEDTHREADPOOL = Executors.newCachedThreadPool();
        BUILDER.setCompressionEnabled(true).setAllowPoolingConnection(true).build();
        ASYNCHTTPCLIENT = new AsyncHttpClient(BUILDER.build());
	}
	
	public static void post(String url, Map<String, String> params, AsyncCompletionHandler<Response> handler) {
        try {
        	BoundRequestBuilder request = ASYNCHTTPCLIENT.preparePost(url);
			for(String key : params.keySet()) {
				request.addParameter(key, params.get(key));
			}
			request.execute(handler);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	public static void postBytes(String url, Map<String, String> params, byte[] content, AsyncCompletionHandler<Response> handler) {
        try {
        	BoundRequestBuilder request = ASYNCHTTPCLIENT.preparePost(url);
			for(String key : params.keySet()) {
				request.addQueryParameter(key, params.get(key));
			}
			
			request.setBody(content);
			request.execute(handler);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	public static void get(String url, AsyncCompletionHandler<Response> handler) {
        try {
        	BoundRequestBuilder request = ASYNCHTTPCLIENT.prepareGet(url);
			request.execute(handler);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
}
