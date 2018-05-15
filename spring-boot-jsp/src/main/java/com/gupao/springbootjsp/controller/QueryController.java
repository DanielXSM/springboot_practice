package com.gupao.springbootjsp.controller;

import com.gupao.springbootjsp.entity.GoodEntity;
import com.gupao.springbootjsp.entity.QGoodEntity;
import com.gupao.springbootjsp.jpa.GoodJPA;
import com.gupao.springbootjsp.jpa.Inquirer;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

/**
 * @program: spring-boot-jsp
 * @description:QueryDSL
 * @author:Daniel.zhao
 * @create:2018-05-15 11:26
 **/
@RestController
@RequestMapping("/dsl")
public class QueryController {
    @Autowired
    private GoodJPA goodJPA;
    //注入entityManager
    @PersistenceContext
    private EntityManager entityManager;






    @RequestMapping(value = "/query")
    public List<GoodEntity> list(){
        //queryDsl 查询实体
        QGoodEntity _good=QGoodEntity.goodEntity;
        //构建JPA查询对象
        JPAQuery<GoodEntity> jpaQuery=new JPAQuery<>(entityManager);
        //返回查询接口
        return jpaQuery.select(_good).from(_good).where(_good.type.id.eq(Long.valueOf("1"))).fetch();
    }


    /**
     * 接下来我们使用SpringDataJPA整合QueryDSL完成相同的查询效果。
     */


    @RequestMapping(value = "/join")
    public List<GoodEntity> join(){
        //queryDsl 查询实体
        QGoodEntity _good=QGoodEntity.goodEntity;
        //查询条件
        BooleanExpression expression=_good.type.id.eq(Long.valueOf("1"));
        //执行查询
        Iterator<GoodEntity>iterator=goodJPA.findAll(expression).iterator();
        List<GoodEntity> goods=new ArrayList<>();
        //转化成list
        while (iterator.hasNext()){
            goods.add(iterator.next());
        }

        return goods;
    }

    /**
     * @Description: desc 用查询的进行封装
     * @param
     * @return java.util.List<com.gupao.springbootjsp.entity.GoodEntity>
     * @author：
     * @throws
     * @since：daniel.zhao 2018-05-15 15:49:18
     */
    @RequestMapping(value = "/joinss")
    public List<GoodEntity> joins(){

        //queryDsl 查询实体
        QGoodEntity _good=QGoodEntity.goodEntity;
        //自定义查询对象
        Inquirer inquirer=new Inquirer();
        //添加查询条件
        inquirer.putExpression(_good.type.id.eq(Long.valueOf("1")));
        //返回查询结果
        return inquirer.iteratorToList(goodJPA.findAll(inquirer.buildQuery()));

    }


}
