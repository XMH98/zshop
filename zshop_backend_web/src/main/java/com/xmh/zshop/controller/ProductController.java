package com.xmh.zshop.controller;

import com.xmh.zshop.dto.ProductDto;
import com.xmh.zshop.pojo.Product;
import com.xmh.zshop.pojo.ProductType;
import com.xmh.zshop.service.ProductService;
import com.xmh.zshop.service.ProductTypeService;
import com.xmh.zshop.vo.ProductVo;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Author: 徐明皓
 * Date: 2021-08-05 17:42
 * Description: <描述>
 */
@Controller
@RequestMapping("/backend/product")
public class ProductController {

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductService productService;

    //@ModelAttribute最主要的作用是将数据添加到模型对象中，用于视图页面展示时使用
    @ModelAttribute("productTypes")
    public List<ProductType> loadProductType(){
        List<ProductType> productTypes = productTypeService.findAll();
        return productTypes;
    }

    @RequestMapping("/findAll")
    public String findAll(Map map){
        List<Product> products = productService.findAll();
        map.put("products",products);
        return "productManager";
    }

    @RequestMapping("/add")
    public String add(ProductVo productVo, HttpSession session, Map map){
        String uploadPath = session.getServletContext().getRealPath("/WEB-INF/upload");
        try {
            //将VO转换DTO
            ProductDto productDto = new ProductDto();
            PropertyUtils.copyProperties(productDto,productVo);//对象间属性的拷贝
            productDto.setInputStream(productVo.getFile().getInputStream());
            productDto.setFileName(productVo.getFile().getOriginalFilename());
            productDto.setUploadPath(uploadPath);

            productService.add(productDto);
            map.put("successMsg","添加成功");
        }catch(Exception e) {
            //e.printStackTrace();
            map.put("errorMsg",e.getMessage());
        }

        return "forward:findAll";
    }

}
