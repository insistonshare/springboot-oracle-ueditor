package com.zhx.help.dao;

import com.zhx.help.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 11 on 2017/3/17.
 */
@Repository
@Transactional
public interface GirlRepository extends JpaRepository<Girl,Integer> {
     List<Girl> findByAge(Integer age);
}
