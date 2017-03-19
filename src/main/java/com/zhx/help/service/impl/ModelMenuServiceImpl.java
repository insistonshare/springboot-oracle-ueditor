package com.zhx.help.service.impl;

import com.zhx.help.dao.ModelMenuRepository;
import com.zhx.help.model.ModelMenu;
import com.zhx.help.service.ModelMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2017/3/19 0019.
 *
 * @author zlf
 * @since 1.0
 */
@Service
public class ModelMenuServiceImpl implements ModelMenuService {

    @Autowired
    ModelMenuRepository modelMenuRepository;

    @Override
    public List<ModelMenu> findAll() {
        return modelMenuRepository.findAll();
    }

    @Override
    public List<ModelMenu> findAllByOrderById() {
        return modelMenuRepository.findAllByOrderById();
    }
}
