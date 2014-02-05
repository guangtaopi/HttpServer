package controllers;

import models.com.silu.bean.User;
import models.com.silu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import play.mvc.*;

import static play.libs.Json.toJson;
import static play.mvc.Controller.request;
import static play.mvc.Results.ok;

public class SampleApplication{

    @Autowired
    IUserService userService;

    public Result index(){
        return ok("Got request " + request() + "!");
    }

    public Result get(Long userId){
        User user = userService.get(userId);
        if(null != user){
            return ok(toJson(user));
        }
        else{
            return ok("no user");
        }

    }

}
