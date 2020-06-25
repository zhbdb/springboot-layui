package com.dabing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dabing.entity.Product;
import com.dabing.entity.ProductCategory;
import com.dabing.mapper.ProductCategoryMapper;
import com.dabing.mapper.ProductMapper;
import com.dabing.service.ProductService;
import com.dabing.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public DataVO<ProductVO> findData(Integer page,Integer limit) {
        DataVO dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("");

        //分页.--配置拦截器
        IPage<Product> productIPage = new Page<>(page,limit);
        IPage<Product> result = productMapper.selectPage(productIPage,null);
        dataVO.setCount(result.getTotal());



        //z这里就可以用result了 ，因为这里已经封装了数据
        List<Product> products = result.getRecords();
        List<ProductVO> productVOList = new ArrayList<>();

        for (Product product : products) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product,productVO);
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveloneId());
            ProductCategory productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory!=null){
                productVO.setCategorylevelone(productCategory.getName());
            }

            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveltwoId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory!=null){
                productVO.setCategoryleveltwo(productCategory.getName());
            }

            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategorylevelthreeId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory!=null){
                productVO.setCategorylevelthree(productCategory.getName());
            }

            productVOList.add(productVO);

        }
        dataVO.setData(productVOList);
        return dataVO;

    }

    @Override
    public BarVO getBarVO() {
        List<ProductBarVO> ProductBarVOList = productMapper.findAllProductBarVO();

        List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        for (ProductBarVO productBarVO : ProductBarVOList) {
            names.add(productBarVO.getName());
            values.add(productBarVO.getCount());
        }
        BarVO barVO = new BarVO();
        barVO.setNames(names);
        barVO.setValues(values);
        return barVO;
    }

    @Override
    public List<PieVO> getPieVO() {
        List<ProductBarVO> list = productMapper.findAllProductBarVO();
        List<PieVO> pieVOList = list.stream()
                .map(e -> new PieVO(
                        e.getCount(),
                        e.getName()
                )).collect(Collectors.toList());
        return pieVOList;
    }
}
