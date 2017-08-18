package com.example.dao;

import com.example.model.Employee;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOJDBCImpl2 implements EmployeeDAO {

    // Not thread-safe
    private Connection con = null;

    // package level access
    EmployeeDAOJDBCImpl2() {
        String url = "jdbc:derby://localhost:1527/EmployeeDB";
        //String username = "public";
        String username = "dbadmin";
        String password = "tiger";
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException se) {
            System.out.println("Error obtaining connection with the database: " + se);
            System.exit(-1);
        }
    }

    // Add an Employee record using an INSERT SQL command
    @Override
    public void add(Employee emp) throws DAOException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?)");) {
            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getFirstName());
            pstmt.setString(3, emp.getLastName());
            pstmt.setDate(4, new java.sql.Date(emp.getBirthDate().getTime()));
            pstmt.setFloat(5, emp.getSalary());

            if (pstmt.executeUpdate() != 1) {
                throw new DAOException("Error adding employee");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error adding employee in DAO", se);
        }
    }

    // Update an employee record with a SQL UPDATE command
    @Override
    public void update(Employee emp) throws DAOException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "UPDATE EMPLOYEE SET FIRSTNAME=?, LASTNAME=?, BIRTHDATE=?, SALARY=? WHERE ID=?");) {
            pstmt.setString(1, emp.getFirstName());
            pstmt.setString(2, emp.getLastName());
            pstmt.setDate(3, new java.sql.Date(emp.getBirthDate().getTime()));
            pstmt.setFloat(4, emp.getSalary());
            pstmt.setInt(5, emp.getId());

            if (pstmt.executeUpdate() != 1) {
                throw new DAOException("Error updating employee");
            }
        } catch (SQLException se) {
            throw new DAOException("Error updating employee in DAO", se);
        }
    }

    // Delete an employee record that has this ID from the database using the DELETE command
    @Override
    public void delete(int id) throws DAOException {
        Employee emp = findById(id);
        if (emp == null) {
            throw new DAOException("Employee id: " + id + " does not exist to delete.");
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM EMPLOYEE WHERE ID=?");) {
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() != 1) {
                throw new DAOException("Error deleting employee");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error deleting employee in DAO", se);
        }
    }

    // Find an Employee record using this ID
    @Override
    public Employee findById(int id) throws DAOException {
        try (PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM EMPLOYEE WHERE ID=?");) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return (new Employee(rs.getInt("ID"), rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"), rs.getDate("BIRTHDATE"),
                    rs.getFloat("SALARY")));
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error finding employee in DAO", se);
        }
    }

    // Return an array of all of the Employee records
    // We are using a collection List object to store the results
    // This makes it easier to just add to the collection
    public Employee[] getAllEmployees() throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM EMPLOYEE";
            ResultSet rs = stmt.executeQuery(query);
            // Create an ArrayList to save resulting records
            ArrayList<Employee> emps = new ArrayList<>();
            // Iterate through the results and create Employee objects
            while (rs.next()) {
                emps.add(new Employee(rs.getInt("ID"), rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"), rs.getDate("BIRTHDATE"),
                        rs.getFloat("SALARY")));
            }
            return emps.toArray(new Employee[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error getting all employees in DAO: " + se.getMessage(), se);
        }
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Exception closing Connection: " + se);
        }
    }
}
