package com.zhx.help.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2017/3/18 0018.
 *
 * @author zlf
 * @since 1.0
 */
@Controller
public class IndexController {

    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "info")
    public String info() {
        return "info";
    }

    @RequestMapping(value = "test")
    public String test() {
        return "info";
    }

    @RequestMapping("{menuId}")
    public String ueidtorInfo(@PathVariable("menuId")String menuId) {
        Map map =new HashMap();
        map.put("menuId",menuId);
        return "ueditor";
    }
}
