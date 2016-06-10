/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sansar.employeeinformation.dao;

import com.sansar.employeeinformation.entity.Salary;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rasna
 */
public interface SalaryDAO {

    int insert(Salary s) throws ClassNotFoundException, SQLException;

    
}
