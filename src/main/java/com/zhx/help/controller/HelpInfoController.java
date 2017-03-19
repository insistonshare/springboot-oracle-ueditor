package com.zhx.help.controller;

import com.zhx.help.dao.HelpInfoRepository;
import com.zhx.help.model.HelpInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017/3/18 0018.
 *
 * @author zlf
 * @since 1.0
 */
@RestController
public class HelpInfoController {

    @Autowired
    HelpInfoRepository helpInfoRepository;

    //查询一个女生
    @GetMapping(value = "/helpInfo/{menuId}")
    public HelpInfo getHelpInfo(@PathVariable("menuId")String menuId){
        return helpInfoRepository.findByMenuId(menuId);
    }

}
