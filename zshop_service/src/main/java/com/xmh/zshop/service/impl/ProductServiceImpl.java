package com.xmh.zshop.service.impl;

import com.xmh.zshop.dao.ProductDao;
import com.xmh.zshop.dto.ProductDto;
import com.xmh.zshop.exception.FileUploadException;
import com.xmh.zshop.pojo.Product;
import com.xmh.zshop.pojo.ProductType;
import com.xmh.zshop.service.ProductService;
import com.xmh.zshop.util.StringUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Author: 徐明皓
 * Date: 2021-08-05 18:42
 * Description: <描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Product> findAll() {
        return productDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Product findById(int id) {
        return productDao.selectById(id);
    }

    @Override
    public void add(ProductDto productDto) throws FileUploadException {
        // 1.文件上传
        String fileName = StringUtils.renameFileName(productDto.getFileName());
        String filePath=productDto.getUploadPath()+"/"+fileName;

        try {
            StreamUtils.copy(productDto.getInputStream(),new FileOutputStream(filePath));
        } catch (IOException e) {
            throw new FileUploadException("文件上传失败"+e.getMessage());
        }

        //将文件上传到FTP服务器
        //String filePath = new SimpleDateFormat("yyyyMMdd").format(new Date());
        //String fileName = StringUtils.renameFileName(productDto.getFileName());
        //boolean flag = FtpUtils.uploadFile(host, port, username, password, basePath, filePath, fileName, productDto.getInputStream());
        //System.out.println(baseUrl);
        //System.out.println(filePath);
        //System.out.println(fileName);
        //if (!flag){
        //    throw new FileUploadException("文件上传失败");
        //}

        // 2.保存到数据库，将DTO转换为PO
        Product product = new Product();
        try {
            PropertyUtils.copyProperties(product,productDto);
            product.setImage(filePath);

            //product.setImage(baseUrl+"/"+filePath+"/"+fileName);  //http://192.168.1.68/images/20180509/aasd234234234.JPG

            ProductType productType = new ProductType();
            productType.setId(productDto.getProductTypeId());

            product.setProductType(productType);

            productDao.insert(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(ProductDto productDto) {

    }

    @Override
    public void removeById(int id) {

    }
}
