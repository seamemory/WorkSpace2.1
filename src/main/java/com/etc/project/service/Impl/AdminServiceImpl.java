package com.etc.project.service.Impl;

import com.etc.project.dao.AdminDao;
import com.etc.project.dao.Impl.AdminDaoImpl;
import com.etc.project.domain.Admin;
import com.etc.project.service.AdminService;

public class AdminServiceImpl implements AdminService {

    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin login(String account, String password) {
        Admin admin = adminDao.selectByNameAndPassword(account, password);
        return admin;
    }
}
