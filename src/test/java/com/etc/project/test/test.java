package com.etc.project.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.etc.project.dao.Impl.ProductDaoImpl;
import com.etc.project.dao.ProductDao;
import com.etc.project.domain.Product;
import com.etc.project.domain.Student;
import com.etc.project.service.Impl.ProductServiceImpl;
import com.etc.project.service.ProductService;

import java.util.List;

public class test {
    public static void main(String[] args) {
        /*ProductDao productDao = new ProductDaoImpl();
        List<Product> list = productDao.findProductByNameLike("电");
        list.forEach(System.out::println);*/

        ProductService productService = new ProductServiceImpl();
        List<Product> list1 = productService.findProductByNameLike("电");
        list1.forEach(System.out::println);

        /*System.out.println("========================================================================");

        ProductDao productDao = new ProductDaoImpl();
        List<Product> products = productDao.findProductByNameLike("");
                                                // 将为空数据转换为零                        生成带有格式的json字符串
        String s = JSON.toJSONString(products, SerializerFeature.WriteNullNumberAsZero,SerializerFeature.PrettyFormat);
        System.out.println(s);*/
        System.out.println("============================");

        Student s1= new Student(1001,"张三");
        Student s2 = new Student(1002,"赵四");
        s1.setStudent(s2);
        s2.setStudent(s1);
        //JSON.DEFAULT_GENERATE_FEATURE|=SerializerFeature.DisableCircularReferenceDetect.getMask();
        // 进行格式转换
        String str = JSON.toJSONString(s1,SerializerFeature.PrettyFormat);
        System.out.println(str);
        String str1 = JSON.toJSONString(s2,SerializerFeature.PrettyFormat);
        System.out.println(str1);

    }
}
