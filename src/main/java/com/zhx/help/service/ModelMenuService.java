package com.zhx.help.service;

import com.zhx.help.model.ModelMenu;

import java.util.List;

/**
 * Created on 2017/3/19 0019.
 *
 * @author zlf
 * @since 1.0
 */
public interface ModelMenuService {
    List<ModelMenu> findAll();

    List<ModelMenu> findAllByOrderById();
}
