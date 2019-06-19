package cn.test.controller;

import cn.test.pojo.Product;
import cn.test.query.ProductQuery;
import cn.test.service.impl.ProductServiceImpl;
import cn.test.util.PageResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping(value = "/addOne",method = RequestMethod.POST)
    public void addOne(Product product){
        productService.addOne(product);
    }

    @RequestMapping("/test")
    public void test(String json){
        System.out.println(json);
    }
    @RequestMapping("/getAll")
    @ResponseBody
    public List<Product> getAll(){
        return productService.getAllProduct();
    }

    @RequestMapping("/search")
    @ResponseBody
    public PageResult<Product> search(Long productNum, String productName, ProductQuery productQuery){
        System.out.println(productNum+productName);
        return productService.search(productNum,productName,productQuery);
    }

    @RequestMapping("/page")
    @ResponseBody
    public PageResult<Product> queryProduct(ProductQuery productQuery){
        return productService.loadByQuery(productQuery);
    }

}
