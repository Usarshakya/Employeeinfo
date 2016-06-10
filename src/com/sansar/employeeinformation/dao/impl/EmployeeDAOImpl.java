/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sansar.employeeinformation.dao.impl;

import com.sansar.employeeinformation.dao.EmployeeDAO;
import com.sansar.employeeinformation.dbutil.DBConnection;
import com.sansar.employeeinformation.entity.Employee;
import java.io.FileWriter;
import java.io.IOException;
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
        stmt.setInt(4, e.getId());

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

    public Boolean isEmailExist(String email) throws ClassNotFoundException, SQLException {

        Boolean found = false;
        db.open();
        String sql = "select * from tbl_categories where email=?";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, email);
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            found = true;

        }
        db.close();
        return found;

    }

    @Override
    public void export() throws ClassNotFoundException, SQLException {
        String filename = "D:\\sansar.csv";
        try {
            FileWriter fw = new FileWriter(filename);
            // Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            db.open();
            String sql = "select * from tbl_categories";
            PreparedStatement stmt = db.initStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append('\t');
            }
            fw.flush();
            fw.close();
            db.close();
            //System.out.println("CSV File is created successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
