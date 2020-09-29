package com.etc.project.servlet;

import com.etc.project.domain.Product;
import com.etc.project.service.Impl.ProductServiceImpl;
import com.etc.project.service.ProductService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProductServlet extends HttpServlet {

    // 创建业务层对象
    private ProductService productService;
    public ProductServlet(){
        this.productService = new ProductServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入到post");
        //设置编码方式
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        // 接受op值
        String op = req.getParameter("op");
        //判断op值
        if("like".equals(op)){
            this.like(req,resp);
        }
    }

    private void like(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("我被请求了");
        String name = req.getParameter("name");
        System.out.println(name);
        List<Product> list = this.productService.findProductByNameLike(name);
        System.out.println(list);
        // 获取输出流
        PrintWriter out = resp.getWriter();
        // 将list集合进行转化
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        out.write(jsonString);
        out.flush();
    }
}
