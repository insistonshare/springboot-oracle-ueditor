package com.zhx.help.controller;

import com.zhx.help.model.HelpInfo;
import com.zhx.help.service.HelpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2017/3/18 0018.
 *
 * @author zlf
 * @since 1.0
 */
@RestController
public class HelpInfoController {

    @Autowired
    HelpInfoService helpInfoService;

    /**
     * 根据menuId 查询
     *
     * @param menuId
     * @return
     */
    @GetMapping(value = "/helpInfo/{menuId}")
    public HelpInfo getHelpInfo(@PathVariable("menuId") String menuId) {
        return helpInfoService.findByMenuId(menuId);
    }

    /**
     * 新增或更新
     *
     * @param helpInfo
     */
    @PostMapping(value = "/helpInfo")
    public HelpInfo saveHelpInfo(@RequestBody HelpInfo helpInfo) {
        return helpInfoService.saveOrUpdateHelpInfo(helpInfo);
    }

}
