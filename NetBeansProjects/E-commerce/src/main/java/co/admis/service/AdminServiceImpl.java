/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.AdminDao;

import co.admis.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;
    
    @Override
    public Admin addAdmin(Admin admin) {
    return adminDao.addAdmin(admin);
    }
    
    @Override
    public Admin getAdminByUsername(String username) {
        return adminDao.getAdminByUsername(username);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
                }

    @Override
    public boolean deleteAdmin(Admin admin) {
        return adminDao.deleteAdmin(admin);
    }

    @Override
    public Admin authenticateAdmin(Admin admin) {
        return adminDao.authenticateAdmin(admin);
    }

    
}
