package com.zhx.help.service;

import com.zhx.help.model.HelpInfo;

/**
 * Created on 2017/3/18 0018.
 *
 * @author zlf
 * @since 1.0
 */
public interface HelpInfoService {

    void saveHelpInfo(HelpInfo helpInfo);

    void updateHelpInfo(String content, String menuId);

    HelpInfo findByMenuId(String menuId);

    HelpInfo saveOrUpdateHelpInfo(HelpInfo helpInfo);
}
