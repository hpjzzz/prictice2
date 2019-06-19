package cn.test.service.impl;

import cn.test.dao.ProductMapper;
import cn.test.pojo.Product;
import cn.test.query.ProductQuery;
import cn.test.service.ProductService;
import cn.test.util.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
//@Transactional(propagation=Propagation.SUPPORTS,readOnly = true)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> getAllProduct() {
        return productMapper.getAllProduct();
    }

    @Override
    public void addOne(Product product) {
        productMapper.addOne(product);
    }

    @Override
    public PageResult<Product> search(Long productNum, String productName,ProductQuery productQuery) {
        PageResult<Product> pageResult = new PageResult<>();
        Page<Product> page = PageHelper.startPage(productQuery.getPage(), productQuery.getRows());
        productMapper.search(productNum,productName,productQuery);
        List<Product> result = page.getResult();
        //分页数据
        pageResult.setRows(result);
        //总条数
        pageResult.setTotal(page.getTotal());
        return pageResult;
    }
//    @Transactional
    @Override
    public PageResult<Product> loadByQuery(ProductQuery productQuery) {
        PageResult<Product> pageResult = new PageResult<>();
        Page<Product> page = PageHelper.startPage(productQuery.getPage(), productQuery.getRows());
        productMapper.loadByQuery(productQuery);
        List<Product> result = page.getResult();
        //分页数据
        pageResult.setRows(result);
        //总条数
        pageResult.setTotal(page.getTotal());
        return pageResult;
    }
}
