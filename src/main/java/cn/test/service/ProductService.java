package cn.test.service;

import cn.test.pojo.Product;
import cn.test.query.ProductQuery;
import cn.test.util.PageResult;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    void addOne(Product product);
    PageResult<Product> search(Long productNum,String productName, ProductQuery productQuery);
    PageResult<Product> loadByQuery(ProductQuery productQuery);//分页
}
