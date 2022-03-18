package org.sqli.authentification.entitie;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class User extends  BaseClass{
    private String login;
    private String password;
    private boolean enabled;
    private int loginAttempts;
    @ManyToOne
    private Group group;


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
}
