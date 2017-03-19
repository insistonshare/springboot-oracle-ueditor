package com.zhx.help.controller;

import com.zhx.help.model.ModelMenu;
import com.zhx.help.service.ModelMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created on 2017/3/19 0019.
 *
 * @author zlf
 * @since 1.0
 */
@RequestMapping("menu")
@Controller
public class ModelMenuController {

    @Autowired
    ModelMenuService modelMenuService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ModelMenu>> queryModelMenuList() {
        try {
            List<ModelMenu> list = modelMenuService.findAllByOrderById();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
