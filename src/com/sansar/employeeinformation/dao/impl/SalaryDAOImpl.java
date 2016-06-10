/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sansar.employeeinformation.dao.impl;

import com.sansar.employeeinformation.dao.SalaryDAO;
import com.sansar.employeeinformation.dbutil.DBConnection;
import com.sansar.employeeinformation.entity.Salary;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rasna
 */
public class SalaryDAOImpl implements SalaryDAO {

    private DBConnection db = new DBConnection();

    @Override
    public int insert(Salary s) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "INSERT INTO tbl_salary(amount)VALUE(?)";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, s.getAmount());

        int result = db.executeUpdate();
        db.close();
        return result;
    }

}
