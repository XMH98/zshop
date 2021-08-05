package com.xmh.zshop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmh.zshop.constant.PaginationConstant;
import com.xmh.zshop.constant.ResponseStatusConstant;
import com.xmh.zshop.exception.ProductTypeException;
import com.xmh.zshop.pojo.ProductType;
import com.xmh.zshop.service.ProductTypeService;
import com.xmh.zshop.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Author: 徐明皓
 * Date: 2021-08-03 21:59
 * Description: <描述>
 */
@Controller
@RequestMapping("/backend/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping("/findAll")
    public String findAll(Integer pageNum,Map map){
        //处理业务

        //设置起始页
        if(ObjectUtils.isEmpty(pageNum)){
            pageNum= PaginationConstant.PAGE_NUM;
        }

        //设置分页
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        List<ProductType> productTypes = productTypeService.findAll();

        //将查询出的所有数据进行分页设置，封装PageInfo对象
        PageInfo<ProductType> pageInfo=new PageInfo<>(productTypes);
        map.put("pageInfo",pageInfo);

        return "productTypeManager";
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult add(String name){
        ResponseResult result = new ResponseResult();
        try {
            productTypeService.add(name);
            result.setStatus(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS);
            result.setMessage("添加成功");
        } catch (ProductTypeException e) {
            //e.printStackTrace();
            result.setStatus(ResponseStatusConstant.RESPONSE_STATUS_FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public ResponseResult findById(int id){
        ProductType productType = productTypeService.findById(id);
        return ResponseResult.success(productType);
    }

    @RequestMapping("/modifyName")
    @ResponseBody
    public ResponseResult modifyName(int id,String name){
        ResponseResult result = new ResponseResult();
        try {
            productTypeService.modifyName(id,name);
            result.setStatus(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS);
            result.setMessage("修改成功");
        } catch (ProductTypeException e) {
            result.setStatus(ResponseStatusConstant.RESPONSE_STATUS_FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/removeById")
    @ResponseBody
    public ResponseResult removeById(int id){
        productTypeService.removeById(id);
        return ResponseResult.success();
    }

    @RequestMapping("/modifyStatus")
    @ResponseBody
    public ResponseResult modifyStatus(int id){
        productTypeService.modifyStatus(id);
        return ResponseResult.success();
    }


}
