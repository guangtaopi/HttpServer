package models.com.silu.service;

import models.com.silu.bean.User;
import models.com.silu.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: piguangtao
 * Date: 14-2-1
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;

    @Override
    public void save(User user) {
        System.out.print("save user." + user);
    }

    @Override
    public User get(Long userId) {
        User user = userDao.getUser(userId);
        if(null == user){
            user = new User();
            user.setId(userId);
            user.setName("test");
        }
        return user;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
