/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sansar.employeeinformation;

import com.sansar.employeeinformation.UI.EmployeeUI;
import com.sansar.employeeinformation.dao.impl.EmployeeDAOImpl;
import com.sansar.employeeinformation.dao.EmployeeDAO;
import com.sansar.employeeinformation.dbutil.DBConnection;
import com.sansar.employeeinformation.entity.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Rasna
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EmployeeUI emp = new EmployeeUI();
        emp.setVisible(true);

    }
}
