package com.czj.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class DateClass {
    @ExcelProperty("标题")
    private String string;

    @ExcelProperty("日期")
    private Date date;

    @ExcelProperty("数字标题")
    private Double doubleData;

}
