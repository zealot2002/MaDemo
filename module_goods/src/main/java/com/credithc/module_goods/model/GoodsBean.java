package com.credithc.module_goods.model;

import java.io.Serializable;

/**
 * Created by dell-7020 on 2017/11/14.
 */

public class GoodsBean implements Serializable {
    private static final long serialVersionUID = -1678754010780229655L;

    private String id;
    private String name;// 名称
    private String efficiency;// 功效
    private Integer duration;// 时长：单位：分钟
    private Integer price;// 现价
    private String imageUrl;

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

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
