package org.sqli.authentification.entitie;


import javax.persistence.*;

@Entity
public class User extends  BaseClass{

    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ENABLED")
    private boolean enabled;
    @Column(name = "LOGINATTEMPTS")
    private int loginAttempts;

    @ManyToOne
    private Group group;

    public User(){}
    public User(String login, String password,Group group) {
        this.login = login;
        this.password = password;
        this.group=group;
        this.enabled=true;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
