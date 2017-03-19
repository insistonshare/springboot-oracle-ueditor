package com.zhx.help.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created on 2017/3/19 0019.
 *
 * @author zlf
 * @since 1.0
 */
@RequestMapping("page")
@Controller
public class PageController {
    /**
     * 通用的跳转方法
     * @param pageName
     * @return
     */
    @RequestMapping(value ="{pageName}",method= RequestMethod.GET)
    public String toPage(@PathVariable("pageName")String pageName){
        return pageName;
    }
}
