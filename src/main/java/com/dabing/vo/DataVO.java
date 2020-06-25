package com.dabing.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: 大冰
 * @Date: 2020/6/15 21:09
 */
@Data
public class DataVO<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;
}

