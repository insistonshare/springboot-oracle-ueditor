package com.zhx.help.dao;

import com.zhx.help.model.ModelMenu;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created on 2017/3/19 0019.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelMenuRepositoryTest {

    @Autowired
    ModelMenuRepository modelMenuRepository;

    @Test
    public void findModelMenuByParentId() throws Exception{
        List<ModelMenu> modelMenuList = modelMenuRepository.findByParentId(1);
        Assert.assertTrue(modelMenuList.size()==3);
    }

    @Test
    public void findAll() throws Exception{
        List<ModelMenu> modelMenus = modelMenuRepository.findAll();
        Assert.assertTrue(modelMenus.size()==449);
    }

    @Test
    public void findAllByOrderById() throws Exception{
        List<ModelMenu> modelMenus = modelMenuRepository.findAllByOrderById();
        Assert.assertTrue(modelMenus.get(0).getId()==0);
    }

    @Test
    public void menuInfoList() throws Exception{
    }
}
