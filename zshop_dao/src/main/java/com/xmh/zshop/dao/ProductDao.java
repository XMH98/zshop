package com.xmh.zshop.dao;

import com.xmh.zshop.pojo.Product;

import java.util.List;

/**
 * Author: 徐明皓
 * Date: 2021-08-05 18:01
 * Description: <描述>
 */
public interface ProductDao {

    /**
     * 查询所有商品信息
     */
    public List<Product> selectAll();

    /**
     * 根据id查询商品信息
     */
    public Product selectById(int id);

    /**
     * 添加商品信息
     */
    public void insert(Product product);

    /**
     * 修改商品信息
     */
    public void update(Product product);

    /**
     * 根据id删除商品信息
     */
    public void deleteById(int id);

}
