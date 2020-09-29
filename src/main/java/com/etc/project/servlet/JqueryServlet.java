package com.etc.project.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.etc.project.dao.Impl.ProductDaoImpl;
import com.etc.project.dao.ProductDao;
import com.etc.project.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class JqueryServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 处理编码方式
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*System.out.println("您已进入get请求");
        PrintWriter out = resp.getWriter();
        out.write("此方法为get");
        out.flush();*/

        ProductDao productDao = new ProductDaoImpl();
        List<Product> products = productDao.findProductByNameLike("");
        String s = JSON.toJSONString(products, SerializerFeature.WriteNullNumberAsZero,SerializerFeature.PrettyFormat);
        PrintWriter out = resp.getWriter();
        out.write(s);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        System.out.println("接受到的数据为:"+account+"===="+password);
        PrintWriter out = resp.getWriter();
        out.write("此方法为post");
        out.flush();
    }
}
