package com.gupao.springbootjsp.entity;

import com.gupao.springbootjsp.validator.FlagValidator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 *
 * @program: spring-boot-jsp
 * @description:DemoEntity
 * @author:Daniel.zhao
 * @create:2018-05-22 15:10
 **/
public class DemoEntity implements Serializable {
    private static final long serialVersionUID = 1774252038501773919L;
    /**
     * 字段name：非空校验、长度必须在2~10位之间。
       字段age：最小是1岁。
       字段mail：非空校验、邮箱格式。
     */
    @NotBlank
    @Length(min = 2,max=10)
    private String name;



    @Min(value = 1)
    private int age;


    @NotBlank
    @Email
    private String mail;

    @FlagValidator(values = "1,2,3")
    private String flag;




    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
