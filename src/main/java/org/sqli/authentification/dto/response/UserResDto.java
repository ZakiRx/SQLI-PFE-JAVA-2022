package org.sqli.authentification.dto.response;


import org.sqli.authentification.entitie.User;

public class UserResDto {
    private int id;
    private String login;
    private String group;

    public UserResDto(User user) {
        this.id=user.getId();
        this.login = user.getLogin();
        this.group = user.getGroup().getName();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
