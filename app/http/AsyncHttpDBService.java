package http;

import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.Response;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import sun.java2d.SurfaceDataProxy;
import sun.text.resources.CollationData_uk;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class AsyncHttpDBService {
    private static final Logger log = LoggerFactory.getLogger(AsyncHttpDBService.class);
    public static final int SUCCESS = 0;
    private String serviceUrl = "http://www.baidu.com";

    public void setServiceUrl(String serviceUrl) {
        Assert.notNull(serviceUrl);
        if (serviceUrl.endsWith("/")) {
            this.serviceUrl = serviceUrl;
        } else {
            this.serviceUrl = serviceUrl + "/";
        }
    }

    public void testBaidu(AsyncCompletionHandler handler) {
        AsyncHttpClientHelper.get(serviceUrl, handler);
    }

    public static void main(String[] args){
        final CountDownLatch latch = new CountDownLatch(1);
        AsyncHttpDBService service = new AsyncHttpDBService();


       AsyncCompletionHandler handler = new AsyncCompletionHandler<Response>() {
            @Override
            public Response onCompleted(Response response) throws Exception {
                System.out.println("response:"+response);
                if (response.getStatusCode() != HttpStatus.SC_OK) {
                    System.out.println("请求失败");
                } else {
                    System.out.println(response.getResponseBody("utf-8"));
                }
                latch.countDown();
                return null;
            }
        };
        service.testBaidu(handler);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
