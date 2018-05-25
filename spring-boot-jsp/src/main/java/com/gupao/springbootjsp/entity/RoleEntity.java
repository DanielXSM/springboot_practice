package com.gupao.springbootjsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: spring-boot-jsp
 * @description:权限的角色
 * @author:Daniel.zhao
 * @create:2018-05-25 11:07
 **/
@Entity
@Table(name = "roles")
public class RoleEntity implements Serializable {
    private static final long serialVersionUID = 5848291004459614426L;
@Id
@Column(name = "r_id")
private Long id;

@Column(name = "r_name")
private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
