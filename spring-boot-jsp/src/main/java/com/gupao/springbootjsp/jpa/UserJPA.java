package com.gupao.springbootjsp.jpa;

import com.gupao.springbootjsp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public interface UserJPA extends JpaRepository<UserModel,Long> ,JpaSpecificationExecutor<UserModel>,Serializable{
@Query(value = "select * from  t_user where t_name=?1",nativeQuery = true)
List<UserModel> queryListByCondition(String name);


@Transactional
@Modifying
@Query(value = "DELETE FROM t_user WHERE t_name=?1 AND t_pwd=?2",nativeQuery = true)
void deleteByName(String name,String pwd);
}
