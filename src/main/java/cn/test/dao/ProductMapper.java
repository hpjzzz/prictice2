package cn.test.dao;

import cn.test.pojo.Product;
import cn.test.query.ProductQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    List<Product> getAllProduct();
    void addOne(Product product);
    List<Product> search(@Param("productNum") Long productNum, @Param("productName") String productName, @Param("productQuery") ProductQuery productQuery);
    List<Product> loadByQuery(ProductQuery productQuery);
    void addAll(List<Product> list);
}
