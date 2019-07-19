package com.zakl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;
import java.util.Map;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-07-09 14:30
 **/
public class DataClean  {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader("C:\\Users\\HP\\Desktop\\业主数据.xls");
        List<Map<String,Object>> readAll = reader.readAll();
        readAll.forEach(i->{System.out.println(i.get("业主姓名"));});

    }
}
