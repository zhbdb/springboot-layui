package com.dabing.service;



import com.dabing.vo.BarVO;
import com.dabing.vo.DataVO;
import com.dabing.vo.PieVO;
import com.dabing.vo.ProductVO;

import java.util.List;

public interface ProductService {
    public DataVO<ProductVO> findData(Integer page,Integer limit);
    public BarVO getBarVO();
    public List<PieVO> getPieVO();
}
