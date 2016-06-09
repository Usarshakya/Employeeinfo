/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sansar.employeeinformation.dao.impl;

import com.sansar.employeeinformation.dao.EmployeeDAO;
import com.sansar.employeeinformation.dbutil.DBConnection;
import com.sansar.employeeinformation.entity.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rasna
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private DBConnection db = new DBConnection();

    @Override
    public int insert(Employee e) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "INSERT INTO tbl_categories(first_name,last_name,email)VALUE(?,?,?)";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, e.getFirstName());
        stmt.setString(2, e.getLastName());
        stmt.setString(3, e.getEmail());

        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int update(Employee e) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "UPDATE tbl_categories SET first_name=?,last_name=?,email=? WHERE id=?";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, e.getFirstName());
        stmt.setString(2, e.getLastName());
        stmt.setString(3, e.getEmail());

        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "DELETE FROM tbl_categories WHERE id=?";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, id);

        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public Employee searchByID(int id) throws ClassNotFoundException, SQLException {
        Employee e = null;
        db.open();
        String sql = "SELECT * FROM tbl_categories WHERE id=?";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            e = mapdata(rs);
        }
        db.close();
        return e;
        
    }

    @Override
    public List<Employee> showAll() throws ClassNotFoundException, SQLException {
        List<Employee> eList = new ArrayList<Employee>();
        db.open();
        String sql = "SELECT * FROM employee";
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            eList.add(mapdata(rs));
        }
        db.close();
        return eList;
    }

    private Employee mapdata(ResultSet rs) throws SQLException {
        Employee e = new Employee();
        e.setId(rs.getInt("id"));
        e.setFirstName(rs.getString("first_name"));
        e.setLastName(rs.getString("last_name"));
        e.setEmail(rs.getString("email"));

        return e;
    }

}
