package com.xmh.zshop.service;

import com.xmh.zshop.exception.ProductTypeException;
import com.xmh.zshop.pojo.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: 徐明皓
 * Date: 2021-08-03 17:10
 * Description: <描述>
 */
public interface ProductTypeService {
    /**
     * 查询所有商品类型信息
     */
    public List<ProductType> findAll();

    /**
     * 根据id查询商品类型信息
     */
    public ProductType findById(int id);

    /**
     * 添加商品类型信息
     * 判断商品类型是否已存在
     *  如果存在，抛出异常
     *  如果不存在，则进行添加操作
     */
    public void add(String name) throws ProductTypeException;

    /**
     * 根据id修改商品名称
     */
    public void modifyName(int id,String name);

    /**
     * 根据id修改商品状态
     */
    public void modifyStatus(int id);

    /**
     * 根据id删除商品类型
     */
    public void removeById(int id);
}
