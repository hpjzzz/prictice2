package cn.test.service;

import cn.test.pojo.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrder();
    List<Order> search(Long orderNum, String consignorNum, String providerNum, Date gmtCreat, Date deliveryDate);
}
