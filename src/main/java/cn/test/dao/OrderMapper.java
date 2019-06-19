package cn.test.dao;

import cn.test.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    List<Order> getAllOrder();
    List<Order> search(@Param("orderNum") Long orderNum, @Param("consignorNum") String consignorNum, @Param("providerNum") String providerNum, @Param("gmtCreat") Date gmtCreat, @Param("deliveryDate") Date deliveryDate);
}
