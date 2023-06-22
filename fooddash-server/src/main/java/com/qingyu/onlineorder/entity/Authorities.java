package com.qingyu.onlineorder.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {
    // 版本号在做删改之后，改动一下
    private static final long serialVersionUID = 8734140534986494039L;

    @Id
    private String email;

    private String authorities;

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
