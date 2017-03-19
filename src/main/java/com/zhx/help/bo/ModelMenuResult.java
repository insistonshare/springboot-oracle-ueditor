package com.zhx.help.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ModelMenuResult {

    @JsonProperty("data")
    private List<ModelMenuData> modelMenuDatas = new ArrayList<ModelMenuData>();

    public List<ModelMenuData> getModelMenuDatas() {
        return modelMenuDatas;
    }

    public void setModelMenuDatas(List<ModelMenuData> modelMenuDatas) {
        this.modelMenuDatas = modelMenuDatas;
    }
}
