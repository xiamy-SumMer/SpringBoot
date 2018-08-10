package com.example.controller;

import com.example.dto.IndexDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author SumMer
 * @version V1.0
 * @Title: IndexController
 * @Package com.example.controller
 * @Description:控制器
 * @date 2018-08-08 09:32
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Map<String, Object> map) {

        IndexDTO indexDTO = new IndexDTO("Spring Boot");
        indexDTO.setName("Spring Boot");
        map.put("name", indexDTO.getName());
        return "index";
    }
}
