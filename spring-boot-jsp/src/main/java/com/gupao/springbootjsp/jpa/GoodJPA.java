package com.gupao.springbootjsp.jpa;

import com.gupao.springbootjsp.entity.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
/**
 * @Description: desc 这样GoodJPA就拥有了SpringDataJPA整合QueryDSL的方法实现
 * @param，
 * @return
 * @author：<a href="daniel.zhao@tianyitechs.com">daniel.zhao</a>
 * @throws
 * @since：daniel.zhao 2018-05-15 11:36:12
 */
public interface GoodJPA extends JpaRepository<GoodEntity,Long>,QueryDslPredicateExecutor<GoodEntity> {

}
