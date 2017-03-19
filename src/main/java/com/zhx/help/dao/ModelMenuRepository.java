package com.zhx.help.dao;

import com.zhx.help.model.ModelMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2017/3/19 0019.
 *
 * @author zlf
 * @since 1.0
 */
public interface ModelMenuRepository extends JpaRepository<ModelMenu, Integer> {
    /**
     * 通过父ID获得全部子菜单
     * @param parentId
     * @return
     */
    List<ModelMenu> findByParentId(Integer parentId);

    /**
     * 获得全部菜单
     * @return
     */
    List<ModelMenu> findAll();

    /**
     * 获得全部菜单通过ID排序
     * @return
     */
    List<ModelMenu> findAllByOrderById();

}
