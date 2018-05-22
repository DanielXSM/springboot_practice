package com.gupao.springbootjsp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @program: spring-boot-jsp
 * @description:
 * @author:Daniel.zhao
 * @create:2018-05-22 18:12
 **/
public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Object>{
    //临时变量保存flag值列表
    private String values;



    //初始化values的值
    @Override
    public void initialize(FlagValidator flagValidator) {
        //将注解内赋值的值赋值给临时变量
        values=flagValidator.values();
    }

    /**
     * 进行验证
     * @param o
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        //分割定义有效值
        String[]value_array=values.split(",");
        boolean isFlag=false;
        //遍历比对有效值
        for(int i=0;i<value_array.length;i++){
            //存在一致跳出循环
            if(value_array[i].equals(o)){
                isFlag=true;
                break;
            }
        }

        return isFlag;
    }
}
