package models.com.silu.service;

import models.com.silu.bean.User;

/**
 * Created with IntelliJ IDEA.
 * User: piguangtao
 * Date: 14-2-1
 * Time: 上午11:01
 * To change this template use File | Settings | File Templates.
 */
public interface IUserService {
    void save(User user);

    User get(Long userId);
}
