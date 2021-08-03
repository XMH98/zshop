package com.xmh.zshop.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: 徐明皓
 * Date: 2021-08-03 15:50
 * Description: <描述>
 */
public class Sysuser implements Serializable {
    private Integer id;
    private String name;
    private String loginNmae;
    private String password;
    private String phone;
    private String email;
    private Integer isValid;
    private Date createDate;
    private Integer role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginNmae() {
        return loginNmae;
    }

    public void setLoginNmae(String loginNmae) {
        this.loginNmae = loginNmae;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
