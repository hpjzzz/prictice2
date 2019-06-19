package cn.test.controller;

import cn.test.common.ReadText;
import cn.test.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping("/getFile")
    @ResponseBody
    public Map getAll() throws IOException {
        return ReadText.read();
    }


}
