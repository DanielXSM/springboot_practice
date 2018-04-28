package com.gupao.springbootjsp.jpa;

import com.gupao.springbootjsp.model.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface LoggerJPA extends JpaRepository<LoggerEntity,Long> ,JpaSpecificationExecutor<LoggerJPA>,Serializable{


}
