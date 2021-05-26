package com.nateshao.layui.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductBarVO {
    private String name;
    @JsonProperty("value")
    private Integer count;
}
