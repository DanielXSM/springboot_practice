package com.gupao.springbootjsp.base;

import java.io.Serializable;

/**
 * @program: spring-boot-jsp
 * @description:基础实体类
 * @author:Daniel.zhao
 * @create:2018-05-14 18:59
 **/
public class BaseEntity implements Serializable {
    protected int page=1;
    protected  int size =20;
    protected String sidx="id";

    protected String sort="desc";

    public String getSort() {

        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }
}
