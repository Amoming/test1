package com.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {

    public Date convert(String s) {
        //s就是要进行转化的字符串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //返回转换成的Date
        try {
            //将字符串转化为时间
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("转换失败");
        }
    }
}
