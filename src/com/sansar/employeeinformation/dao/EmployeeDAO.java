/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sansar.employeeinformation.dao;

import com.sansar.employeeinformation.entity.Employee;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rasna
 */
public interface EmployeeDAO {

    int insert(Employee e) throws ClassNotFoundException, SQLException;

    int update(Employee e) throws ClassNotFoundException, SQLException;

    int delete(int id) throws ClassNotFoundException, SQLException;

    Employee searchByID(int id) throws ClassNotFoundException, SQLException;

    List<Employee> showAll() throws ClassNotFoundException, SQLException;

}
