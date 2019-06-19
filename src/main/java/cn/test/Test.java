package cn.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.zzz("222","ddd");
    }
    public void zzz(String product_num,String product_name){
        String sql = "select * from t_product where 1=1";
        if(product_num!="")
        {
            sql+=" and product_num like '%'"+product_num+"'%'";
        }
        if (product_name!=""){
            sql+=" and product_name like '%'"+product_name+"'%'";
        }
        System.out.println(sql);
    }
}
