package hg.wzz.main.entity;

/**
 * 用户类
 */
public class user {
    // id
    private int id;
    // 账号
    private String account;
    //名字
    private String name;
    /** 密码 */
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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



}
