package com.zhx.help.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 2017/3/18 0018.
 *
 * @author zlf
 * @since 1.0
 */
@Entity
@Table(name = "help_info")
public class HelpInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String menuId;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name="CONTENT",columnDefinition="CLOB", nullable=true)
    private String content;
    @Temporal(TemporalType.TIME)
    private Date createTime;
    @Temporal(TemporalType.TIME)
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    @Lob
    @Column(name="CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
