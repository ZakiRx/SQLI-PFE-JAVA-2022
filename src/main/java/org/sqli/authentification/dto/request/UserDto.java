package org.sqli.authentification.dto.request;

public class UserDto {

    private String login;
    private String password;
    private String group;
    public UserDto(String login, String password,String group) {
        this.login = login;
        this.password = password;
        this.group=group;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
