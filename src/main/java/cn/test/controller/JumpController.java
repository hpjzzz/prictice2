package cn.test.controller;

import cn.test.pojo.Employee;
import cn.test.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/jump")
public class JumpController {

//    @Autowired
//    private ProductServiceImpl productService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping("/order")
    public String testOrder() {
        return "order";
    }

    @RequestMapping("/product")
    public String testProduct() {
        return "product";
    }

    @RequestMapping("/orderItem")
    public String testOrderItem(){
        return "orderitem";
    }

    @RequestMapping("/getFile")
    public String file(){
        return "fileupload";
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public Employee findOne(Long id) {
        return employeeService.selectByPrimaryKey(id);
    }


}
