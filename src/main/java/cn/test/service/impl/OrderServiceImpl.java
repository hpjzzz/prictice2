package cn.test.service.impl;

import cn.test.dao.OrderMapper;
import cn.test.pojo.Order;
import cn.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> getAllOrder() {
        return orderMapper.getAllOrder();
    }

    @Override
    public List<Order> search(Long orderNum, String consignorNum, String providerNum, Date gmtCreat, Date deliveryDate) {
        return orderMapper.search(orderNum,consignorNum,providerNum,gmtCreat,deliveryDate);
    }
}
