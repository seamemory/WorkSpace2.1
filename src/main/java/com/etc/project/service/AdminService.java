package com.etc.project.service;

import com.etc.project.domain.Admin;

public interface AdminService {
    Admin login(String account,String password);
}
