package cn.test.controller;

import cn.test.pojo.Order;
import cn.test.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Order> getAll(){
        return orderService.getAllOrder();
    }

    @RequestMapping("/combobox")
    public String textCombobox(){
        return "combobox";
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<Order> search(Long orderNum, String consignorNum, String providerNum, Date gmtCreat, Date deliveryDate){
        return orderService.search(orderNum,consignorNum,providerNum,gmtCreat,deliveryDate);
    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
}
