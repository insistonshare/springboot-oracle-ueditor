package com.zhx.help.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 2017/3/19 0019.
 *
 * @author zlf
 * @since 1.0
 */
@Entity
public class ModelMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Integer id;
    @Column(name = "uplevel")
    private Integer parentId;
    @Column(name = "menu_name")
    private String text;
//    @Column(name = "level")
//    private Integer level;
//    @Column(name = "url")
//    private String url;
//    @Column(name = "sort")
//    private Integer sort;
//    @Column(name = "state")
//    private String state;
//    @Column(name = "create_id")
//    private String createId;
//    @Column(name = "create_time")
//    @Temporal(TemporalType.DATE)
//    private Date createTime;
//    @Column(name = "memo")
//    private String memo;
//    @Column(name = "other_power_url")
//    private String otherPowerUrl;
//    @Column(name = "param_key")
//    private String paramKey;
//    @Column(name = "param_val")
//    private String paramVal;
//    @Column(name = "mark")
//    private String mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**

     insert into model_menu (ID, NAME, PARENT_ID)
     values (2, '系统开发', 0);

     insert into model_menu (ID, NAME, PARENT_ID)
     values (3, '系统维护', 0);

     insert into model_menu (ID, NAME, PARENT_ID)
     values (4, '接口管理', 0);

     insert into model_menu (ID, NAME, PARENT_ID)
     values (5, '权限管理', 1);

     insert into model_menu (ID, NAME, PARENT_ID)
     values (6, '角色管理', 1);

     insert into model_menu (ID, NAME, PARENT_ID)
     values (7, '用户管理', 1);

     insert into model_menu (ID, NAME, PARENT_ID)
     values (8, '表单管理', 2);

     insert into model_menu (ID, NAME, PARENT_ID)
     values (9, '模块管理', 2);

     insert into model_menu (ID, NAME, PARENT_ID)
     values (10, '系统监控', 3);

     insert into model_menu (ID, NAME, PARENT_ID)
     values (11, '客户端管理', 4);

     insert into model_menu (ID, NAME, PARENT_ID)
     values (1, '系统设置', 0);



     */
}
