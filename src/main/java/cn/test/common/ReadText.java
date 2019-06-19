package cn.test.common;

import cn.test.pojo.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadText {
    public static Map read() throws IOException {
        String url = null;
        int totalRows = 0;//总行
        int validRows = 0;//有效行
        int rightData = 0;//有效数据
        int wrongData = 0;//错误数据
        List rightList= new ArrayList();
        List wrongList= new ArrayList();

        File file = new File("D:\\sku.txt");

        FileInputStream fis = null;

        fis = new FileInputStream(file);

        InputStreamReader input = new InputStreamReader(fis);

        BufferedReader br = new BufferedReader(input);

        String line = null;

        String info[] = null;


        Product product = new Product();

        while((line = br.readLine())!= null){
            totalRows++;
            if(line.length()>0){//判断有效行
                validRows++;
                if(!line.contains(",")){
                    wrongData++;
                    System.out.println("格式错误");
                    Map<String,String> wrong = new HashMap<String,String>();
                    wrong.put("lineNum",String.valueOf(totalRows));
                    wrong.put("data",line);
                    wrong.put("reason","格式错误");
                    wrongList.add(wrong);
                }else if(line.split(",").length < 3){
                    wrongData++;
                    System.out.println("缺少字段");
                    Map<String,String> wrong = new HashMap<String,String>();
                    wrong.put("lineNum",String.valueOf(totalRows));
                    wrong.put("data",line);
                    wrong.put("reason","缺少字段");
                    wrongList.add(wrong);
                }else if(!isNumber.isNum(line.split(",")[2])){
                    wrongData++;
                    System.out.println("金额错误");
                    Map<String,String> wrong = new HashMap<String,String>();
                    wrong.put("lineNum",String.valueOf(totalRows));
                    wrong.put("data",line);
                    wrong.put("reason","金额错误");
                    wrongList.add(wrong);
                }else {
                    rightData++;
                    info = line.split(",");
                    Map<String,String> pro = new HashMap<String,String>();
                    pro.put("lineNum",String.valueOf(totalRows));
                    pro.put("productNum",info[0]);
                    pro.put("productName",info[1]);
                    pro.put("productPrice",info[2]);

                    rightList.add(pro);
                }
            }
        }
        Map<String,Object> bag = new HashMap<String,Object>();
        bag.put("totalRows",totalRows);
        bag.put("validRows",validRows);
        bag.put("rightData",rightData);
        bag.put("wrongData",wrongData);
        bag.put("rightList",rightList);
        bag.put("wrongList",wrongList);

//        while((line = br.readLine())!= null){//从文件中读入到内存中
//
//            info =line.split(",");
//
//            product.setProductNum(Long.parseLong(info[0]));
//            product.setProductName(info[1]);
//            product.setProductPrice(new BigDecimal(info[2]));
//            sourceList.add(product);
//        }
        input.close();
        br.close();
        System.out.println(bag);
        return bag;
    }

    public static void main(String[] args) throws IOException {
        ReadText.read();
    }
}
