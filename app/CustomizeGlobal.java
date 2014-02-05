import models.com.silu.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.Application;
import play.Configuration;
import play.GlobalSettings;
import play.Play;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: piguangtao
 * Date: 14-2-2
 * Time: 下午10:23
 * To change this template use File | Settings | File Templates.
 */
public class CustomizeGlobal extends GlobalSettings {

    private static Logger LOGGER = LoggerFactory.getLogger(CustomizeGlobal.class);

    private ApplicationContext context;

    @Override
    public void onStart(Application app){
       LOGGER.info("begin to start spring.");
       String contextFile =  Play.application().configuration().getString("spring.context.file");
       System.out.println("contextFile:"+contextFile);
       context = new FileSystemXmlApplicationContext(contextFile);
       IUserService userService = (IUserService) context.getBean("userService");
        LOGGER.info("end to start spring");
    }

    @Override
    public <A> A getControllerInstance(Class<A> clazz) {
        System.out.println("getControllerInstance, clazz"+clazz);
        return context.getBean(clazz);
    }


    @Override
    public void beforeStart(Application app){
        LOGGER.info("enter beforeStart.app:"+app);
        System.out.println("enter beforeStart.app:"+app);
    }

    @Override
    public void onStop(Application app) {
        LOGGER.info("enter onStop.app:"+app);
        System.out.println("enter onStop.app:"+app);
    }

    @Override
    public F.Promise<SimpleResult> onError(Http.RequestHeader request, Throwable t) {
        LOGGER.info("enter onError.request:{},throwable:{}", request,t);
        System.out.println("enter onError.");
        return null;
    }

    @Override
    public Action onRequest(Http.Request request, Method actionMethod) {
        LOGGER.info("enter onRequest.request:{},actionMethod:{}", request,actionMethod);
        System.out.println("enter onRequest.request:"+request+" ,actionMethod:"+actionMethod);
        return new Action.Simple() {
            public F.Promise<SimpleResult> call(Http.Context ctx) throws Throwable {
                return delegate.call(ctx);
            }
        };
    }

    @Override
    public play.api.mvc.Handler onRouteRequest(Http.RequestHeader request) {
        LOGGER.info("enter onRouteRequest.request:{}", request);
        System.out.println("enter onRouteRequest.request:" + request);
        return null;
    }

    @Override
    public F.Promise<SimpleResult> onHandlerNotFound(Http.RequestHeader request) {
        LOGGER.info("enter onHandlerNotFound.request:{}", request);
        System.out.println("enter onHandlerNotFound.request:" + request);
        return null;
    }

    @Override
    public F.Promise<SimpleResult> onBadRequest(Http.RequestHeader request, String error) {
        LOGGER.info("enter onBadRequest.request:{},error:{}", request,error);
        System.out.println("enter onBadRequest.request:" + request+" ,error:"+error);
        return null;
    }

    @Override
    public Configuration onLoadConfig(Configuration config, File path, ClassLoader classloader) {
        LOGGER.info("enter onBadRequest.config:{},file:{},classloader:{}", config,path,classloader);
        System.out.println("enter onBadRequest.config:" + config+" ,file:"+path);
        return null;
    }

    @Override
    public <T extends play.api.mvc.EssentialFilter> Class<T>[] filters() {
        LOGGER.info("enter filters");
        System.out.println("enter filters");
        return new Class[0];
    }

}
