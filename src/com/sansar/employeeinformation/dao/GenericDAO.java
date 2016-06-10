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
public interface GenericDAO<T> {

    int insert(T t) throws ClassNotFoundException, SQLException;

    int update(T t) throws ClassNotFoundException, SQLException;

    int delete(int id) throws ClassNotFoundException, SQLException;

    T searchByID(int id) throws ClassNotFoundException, SQLException;

    List<T> showAll() throws ClassNotFoundException, SQLException;

    Boolean isEmailExist(String email) throws ClassNotFoundException, SQLException;

    void export() throws ClassNotFoundException, SQLException;

}
