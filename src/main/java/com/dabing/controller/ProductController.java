package com.dabing.controller;

import com.dabing.service.ProductService;
import com.dabing.vo.BarVO;
import com.dabing.vo.DataVO;
import com.dabing.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 大冰
 * @Date: 2020/6/16 9:19
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    @ResponseBody
    public DataVO list(Integer page,Integer limit){
        return productService.findData(page,limit);
    }

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    @RequestMapping("/barVo")
    @ResponseBody
    public BarVO BarVo(){
        return productService.getBarVO();
    }

    @RequestMapping("/pieVO")
    @ResponseBody
    public List<PieVO> getPieVO(){
        return productService.getPieVO();
    }
}
