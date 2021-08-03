package com.xmh.zshop.dao;

import com.xmh.zshop.pojo.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: 徐明皓
 * Date: 2021-08-03 16:15
 * Description: <描述>
 */
public interface ProductTypeDao {
    /**
     * 查询所有商品类型信息
     */
    public List<ProductType> selectAll();

    /**
     * 根据id查询商品类型信息
     */
    public ProductType selectById(int id);

    /**
     * 根据名字查询商品类型信息
     */
    public ProductType selectByName(String name);

    /**
     * 添加商品类型信息
     */
    public void insert(@Param("name") String name,@Param("status") int status);

    /**
     * 根据id修改商品名称
     */
    public void updateName(@Param("id") int id,@Param("name") String name);

    /**
     * 根据id修改商品状态
     */
    public void updateStatus(@Param("id") int id,@Param("status") int status);

    /**
     * 根据id删除商品类型
     */
    public void deleteById(int id);
}
