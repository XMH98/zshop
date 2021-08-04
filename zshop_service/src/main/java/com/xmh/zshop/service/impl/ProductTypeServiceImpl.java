package com.xmh.zshop.service.impl;

import com.xmh.zshop.constant.ProductTypeConstant;
import com.xmh.zshop.dao.ProductTypeDao;
import com.xmh.zshop.exception.ProductTypeException;
import com.xmh.zshop.pojo.ProductType;
import com.xmh.zshop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: 徐明皓
 * Date: 2021-08-03 17:15
 * Description: <描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<ProductType> findAll() {
        return productTypeDao.selectAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public ProductType findById(int id) {
        return productTypeDao.selectById(id);
    }

    @Override
    public void add(String name) throws ProductTypeException {
        ProductType productType = productTypeDao.selectByName(name);
        if(productType!=null){
            throw new ProductTypeException("商品类型已存在");
        }
        productTypeDao.insert(name, ProductTypeConstant.PRODUCT_TYPE_ENABLE);
    }

    @Override
    public void modifyName(int id, String name) throws ProductTypeException {
        ProductType productType = productTypeDao.selectByName(name);
        if(productType!=null){
            throw new ProductTypeException("商品类型已存在");
        }
        productTypeDao.updateName(id,name);
    }

    @Override
    public void modifyStatus(int id) {

    }

    @Override
    public void removeById(int id) {

    }
}
