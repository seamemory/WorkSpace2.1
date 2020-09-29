package com.etc.project.dao;

import com.etc.project.domain.Admin;

public interface AdminDao {
    // 根据账号和密码查询管理员
    Admin selectByNameAndPassword(String account,String password);
}
