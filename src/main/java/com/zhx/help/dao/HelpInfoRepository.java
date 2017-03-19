package com.zhx.help.dao;

import com.zhx.help.model.HelpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by 11 on 2017/3/17.
 */
@Repository
@Transactional
public interface HelpInfoRepository extends JpaRepository<HelpInfo, Integer> {
    HelpInfo findByMenuId(String menuid);

    @Modifying
    @Query("update HelpInfo h set h.content = :content, h.updateTime = :updateTime where h.menuId = :muenuId")
    void setHelpInfoByMenuId(@Param("content") String content, @Param("updateTime") Date updateTime, @Param("muenuId") String muenuId);
}
