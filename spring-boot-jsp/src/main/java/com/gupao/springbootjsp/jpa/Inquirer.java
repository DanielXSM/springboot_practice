package com.gupao.springbootjsp.jpa;


import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: spring-boot-jsp
 * @description:自定义查询实体类，该类可以完成查询添加封装，查询结果处理操作，
 * @author:Daniel.zhao
 * @create:2018-05-15 15:09
 **/
public class Inquirer {
    //查询条件集合
    private List<BooleanExpression>expressions;
    public Inquirer(){
        this.expressions=new ArrayList<>();
    }

    /**
     * 添加查询条件到QUery内的查询集合内
     * @param expression
     * @return
     */
    public Inquirer putExpression(BooleanExpression expression){
        expressions.add(expression);
        return this;
    }

    /**
     * 构建出查询findall函数使用的predicate接口查询对象
     * 调用buildQuery()可以直接作为findAll参数查询条件使用
     * @return
     */
    public Predicate buildQuery(){
        //第一个查询条件对象
        com.querydsl.core.types.dsl.BooleanExpression  be=null;
        //遍历所有的查询条件
        for(int i=0;i<expressions.size();i++){
            if(i==0){
                be=expressions.get(i);
            }else{
                be=be.and(expressions.get(i));
            }
        }
        return be;
    }

    /**
     * 将Iterable集合转换成ArrayList集合
     * @param iterable
     * @param <T>
     * @return
     */
    public <T>List<T> iteratorToList(Iterable<T> iterable){
        List<T> returnList=new ArrayList<T>();
        Iterator<T> iterator= iterable.iterator();
        while(iterator.hasNext()){
            returnList.add(iterator.next());
        }
        return returnList;
}


}
