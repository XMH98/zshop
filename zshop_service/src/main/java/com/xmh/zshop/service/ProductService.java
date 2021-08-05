package com.xmh.zshop.service;

import com.xmh.zshop.dto.ProductDto;
import com.xmh.zshop.exception.FileUploadException;
import com.xmh.zshop.pojo.Product;

import java.util.List;

/**
 * Author: 徐明皓
 * Date: 2021-08-05 18:41
 * Description: <描述>
 */
public interface ProductService {
    /**
     * 查询所有商品信息
     */
    public List<Product> findAll();

    /**
     * 根据id查询商品信息
     */
    public Product findById(int id);

    /**
     * 添加商品信息
     */
    public void add(ProductDto productDto) throws FileUploadException;

    /**
     * 修改商品信息
     */
    public void modify(ProductDto productDto);

    /**
     * 根据id删除商品信息
     */
    public void removeById(int id);
}
