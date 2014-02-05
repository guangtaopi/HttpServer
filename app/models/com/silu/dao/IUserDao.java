package models.com.silu.dao;

import models.com.silu.bean.User;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created with IntelliJ IDEA.
 * User: piguangtao
 * Date: 14-2-4
 * Time: 下午11:48
 * To change this template use File | Settings | File Templates.
 */
public interface IUserDao {
    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long id);
    public User getUser(Long id);
}
