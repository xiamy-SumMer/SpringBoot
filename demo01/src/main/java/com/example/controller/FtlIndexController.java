package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author SumMer
 * @version V1.0
 * @Title: FtlIndexController
 * @Package com.example.controller
 * @Description:
 * @date 2018-08-07 21:07
 */
@Controller
public class FtlIndexController {

    @RequestMapping("/ftlindex")
    public String ftlindex(Map<String, Object> map) {

        map.put("name", "springboot");
        List<String> list = new ArrayList<>();
        list.add("springboot");
        list.add("springmvc");
        list.add("springcloud");
        map.put("list", list);
        return "ftlindex";
    }
}
