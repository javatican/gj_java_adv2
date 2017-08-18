package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {

    public static void main(String[] args) {
        String url = "jdbc:derby://localhost:1527/EmployeeDB";
        String username = "public";
        String password = "tiger";
        String input = "";
        int id;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement pStmt = con.prepareStatement("DELETE FROM Employee WHERE id = ?")) {
            //set auto commit false
            con.setAutoCommit(false);

            try {
                while (true) {
                    System.out.print("Enter employee id to delete, Y to commit or N to rollback: ");
                    input = in.readLine();
                    if (input.equals("Y") || input.equals("y")) {
                        con.commit();
                        System.out.println("Transaction commits!");
                        break;
                    }
                    if (input.equals("N") || input.equals("n")) {
                        con.rollback();
                        System.out.println("Transaction rollbacks!");
                        break;
                    }
                    try {
                        id = Integer.valueOf(input);
                    } catch (NumberFormatException n) {
                        System.out.println("Please enter a valid id.");
                        continue;
                    }
                    pStmt.setInt(1, id);
                    int result = pStmt.executeUpdate();
                    if (result != 1) {
                        System.out.println("Employee id does not exists! ");
                    }// end of while
                }
            } catch (IOException | SQLException e) {
                System.out.println("SQLException: " + e);
                con.rollback();
            }
        } catch (IOException | SQLException e) {
            System.out.println("SQLException: " + e);

        } // end of try-with-resources
    }
}
