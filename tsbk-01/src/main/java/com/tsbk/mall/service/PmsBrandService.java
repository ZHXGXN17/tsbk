package com.tsbk.mall.service;

import com.tsbk.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * PmsBrandService
 * Created by yufei.wang on 2020-03-05.
 */
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
