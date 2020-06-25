package com.dabing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dabing.entity.Product;
import com.dabing.vo.ProductBarVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: 大冰
 * @Date: 2020/6/15 17:40
 */
public interface ProductMapper extends BaseMapper<Product> {
    @Select("SELECT p.name,SUM(quantity) COUNT FROM order_detail od, product p WHERE od.product_id = p.id GROUP BY product_id")
    public List<ProductBarVO> findAllProductBarVO();

}
