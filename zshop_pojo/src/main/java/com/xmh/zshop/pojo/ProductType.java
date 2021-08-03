package com.xmh.zshop.pojo;

import java.io.Serializable;

/**
 * Author: 徐明皓
 * Date: 2021-08-03 15:54
 * Description: <描述>
 */
public class ProductType implements Serializable {
    private Integer id;
    private String name;
    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
