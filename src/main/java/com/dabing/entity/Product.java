package com.dabing.entity;

import lombok.Data;

/**
 * @Author: 大冰
 * @Date: 2020/6/15 17:37
 */
@Data
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Float price;
    private Integer stock;
    private Integer categoryleveloneId;
    private Integer categoryleveltwoId;
    private Integer categorylevelthreeId;
    private String fileName;
}
