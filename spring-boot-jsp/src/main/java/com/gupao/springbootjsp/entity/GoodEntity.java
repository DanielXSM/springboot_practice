package com.gupao.springbootjsp.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: spring-boot-jsp
 * @description:商品信息
 * @author:Daniel.zhao
 * @create:2018-05-15 10:25
 **/
@Entity
@Table(name="good_infos")
public class GoodEntity implements Serializable
{
    private static final long serialVersionUID = 7879365433802952596L;
    @Id
    @GeneratedValue
    @Column(name = "tg_id")
    private Long id;
    @Column(name = "tg_title")
    private String title;

    @Column(name = "tg_price")
    private double price;

    @Column(name = "tg_unit")
    private String unit;

    @Column(name = "tg_order")
    private int order;

    @OneToOne
    @JoinColumn(name = "tg_type_id")
    private GoodTypeEntity type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public GoodTypeEntity getType() {
        return type;
    }

    public void setType(GoodTypeEntity type) {
        this.type = type;
    }
}
