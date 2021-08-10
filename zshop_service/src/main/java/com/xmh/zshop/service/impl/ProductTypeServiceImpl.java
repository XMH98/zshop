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
 * Description: <实现类>
 */
@Service
/**
 * 事务管理
 *      propagation：事务传播类型
 *      REQUIRED：支持当前事务，如果不存在则创建一个新事务
 */
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    //支持当前事务，如果不存在则以非事务方式执行
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
        ProductType productType = findById(id);
        int status = productType.getStatus();
        if(status==ProductTypeConstant.PRODUCT_TYPE_ENABLE){
            status=ProductTypeConstant.PRODUCT_TYPE_DISABLE;
        }else {
            status=ProductTypeConstant.PRODUCT_TYPE_ENABLE;
        }
        productTypeDao.updateStatus(id,status);
    }

    @Override
    public void removeById(int id) {
        productTypeDao.deleteById(id);
    }
}
