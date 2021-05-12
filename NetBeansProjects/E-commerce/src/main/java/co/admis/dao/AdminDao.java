/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.model.Admin;

/**
 *
 * @author manyaagarwal
 */
public interface AdminDao{
    public Admin addAdmin(Admin admin);
    public Admin getAdminByUsername(String username);
    public Admin updateAdmin(Admin admin);
    public boolean deleteAdmin(Admin admin);
    public Admin authenticateAdmin(Admin admin);
}
