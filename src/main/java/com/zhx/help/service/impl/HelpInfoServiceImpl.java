package com.zhx.help.service.impl;

import com.zhx.help.dao.HelpInfoRepository;
import com.zhx.help.model.HelpInfo;
import com.zhx.help.service.HelpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created on 2017/3/19 0019.
 *
 * @author zlf
 * @since 1.0
 */
@Service
public class HelpInfoServiceImpl implements HelpInfoService {

    @Autowired
    HelpInfoRepository helpInfoRepository;


    @Override
    public void saveHelpInfo(HelpInfo helpInfo) {
        helpInfo.setCreateTime(new Date());
        helpInfo.setUpdateTime(helpInfo.getCreateTime());
        helpInfoRepository.save(helpInfo);
    }

    @Override
    public void updateHelpInfo(String content, String menuId) {
        HelpInfo helpInfo = helpInfoRepository.findByMenuId(menuId);
        helpInfo.setContent(content);
        helpInfo.setUpdateTime(new Date());
        helpInfoRepository.save(helpInfo);
    }
}
