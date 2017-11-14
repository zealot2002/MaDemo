package com.credithc.module_goods.model;

import java.io.Serializable;

/**
 * Created by dell-7020 on 2017/11/14.
 */

public class GoodsBean implements Serializable {
    private static final long serialVersionUID = -1678754010780229655L;

    private String id;
    private String name;// 名称
    private Integer price;// 现价

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
