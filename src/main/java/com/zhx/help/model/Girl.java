package com.zhx.help.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by 11 on 2017/3/17.
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String CupSize;
    private Integer age;
    public Girl(){
    }
    public Integer getId() {
        return id;
    }
    public Girl setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getCupSize() {
        return CupSize;
    }
    public Girl setCupSize(String cupSize) {
        CupSize = cupSize;
        return this;
    }
    public Integer getAge() {
        return age;
    }
    public Girl setAge(Integer age) {
        this.age = age;
        return this;
    }
}
