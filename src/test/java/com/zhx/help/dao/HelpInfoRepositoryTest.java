package com.zhx.help.dao;

import com.zhx.help.model.HelpInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

/**
 * Created on 2017/3/18 0018.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelpInfoRepositoryTest {

    @Autowired
    private HelpInfoRepository helpInfoRepository;


    @Test
    public void addHelpInfo() throws Exception {
        HelpInfo helpInfo = new HelpInfo();
        helpInfo.setMenuId("002");
        helpInfo.setCreateTime(new Date());
        helpInfo.setUpdateTime(helpInfo.getCreateTime());
        String s = readFileAsString("C:\\Users\\Administrator\\Desktop\\33.sql");
        helpInfo.setContent(s);
        helpInfo = helpInfoRepository.save(helpInfo);
        Assert.assertNotNull(helpInfo.getId());
    }

    @Test
    public void getHelpInfo() throws Exception{
        HelpInfo helpInfo = helpInfoRepository.findOne(3);
        Assert.assertEquals("001",helpInfo.getMenuId());
    }

    @Test
    public void getHelpInfoByMenuId() throws Exception{
        HelpInfo helpInfo = helpInfoRepository.findByMenuId("001");
        Assert.assertEquals("001",helpInfo.getMenuId());
    }

    @Test
    public void updateHelpInfo() throws Exception{
        HelpInfo helpInfo = helpInfoRepository.findByMenuId("001");
        Assert.assertEquals("001",helpInfo.getMenuId());
        helpInfo.setContent("test111111");
        helpInfo.setUpdateTime(new Date());
        helpInfoRepository.save(helpInfo);
//        helpInfoRepository.setHelpInfoByMenuId("test",new Date(),"001");

    }



    private String readFileAsString(String filePath) throws java.io.IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return fileData.toString();
    }
}
