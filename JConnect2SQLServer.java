package net.coffee.java.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class JConnect2SQLServer {

    public static void main(String[] args) {

        Connection conn = null;

        try {

            String dbURL = "jdbc:sqlserver://SAMHAIN;databaseName=bulletins2;encrypt=true;trustServerCertificate=true";
            String user = "bulletins";
            String pass = "qwerty";
            String queryString = "SELECT * FROM audit_event_types";
            conn = DriverManager.getConnection(dbURL, user, pass);

            if (conn != null) {

                System.out.println("\nConnected to the database");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());

                System.out.println("\nExecuting Test");
                System.out.println("\nQuery string:");
                System.out.println(queryString);
                System.out.println("\nKeyname");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(queryString);

                while (rs.next()) {
                    System.out.println(rs.getString("keyname"));
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("\nClosed connection to the database");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}