package com.etc.project.servlet;

import com.etc.project.domain.Admin;
import com.etc.project.service.AdminService;
import com.etc.project.service.Impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminServlet extends HttpServlet {
    private AdminService service;
    public AdminServlet(){
        this.service = new AdminServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 获取账号和密码
        req.setCharacterEncoding("utf-8");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        Admin admin = this.service.login(account,password);
        if(admin==null){
            req.setAttribute("message","对不起，登录失败，请重新登录");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else{
            // 将用户信息存储到session中
            HttpSession session = req.getSession();
            session.setAttribute("admin",admin);
            // 只要登录成功就证明有人登录 就需要把登录的人记录到全局变量ServletContext对象中
            int num = (int)this.getServletContext().getAttribute("num");
            // 将数值+1 在存储到全局变量
            this.getServletContext().setAttribute("num",num+1);
            resp.sendRedirect("index.jsp");
        }
    }
}
