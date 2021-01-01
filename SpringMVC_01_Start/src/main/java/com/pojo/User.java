package com.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 1. 局部类型转换 @DateTimeFormat
 * 2. 自定义全局的类型转换器
 *    1.
 */

@Data
public class User {
    private Integer age;
    private String name;
    private String address;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private List<String> hobby;

    public User(){
    	
    }

    public void method(){
    	
    }
}
