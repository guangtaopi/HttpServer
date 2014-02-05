package models.com.silu.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: piguangtao
 * Date: 14-2-1
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable{
    private Long id;

    private String name;

    private String password;

    private String passwordkey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordkey() {
        return passwordkey;
    }

    public void setPasswordkey(String passwordkey) {
        this.passwordkey = passwordkey;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", passwordkey='" + passwordkey + '\'' +
                '}';
    }
}
