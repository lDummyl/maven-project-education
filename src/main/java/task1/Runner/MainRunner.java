package task1.Runner;

import task1.Connection.OracleConn;

import java.sql.Connection;
import java.sql.SQLException;

public class MainRunner {
    public static void main(String[] args) {
        OracleConn oracleConn = new OracleConn();
        Connection conn = oracleConn.getConn();
        if (conn != null) {
            try {
                conn.close();
                System.out.println("conn closed!");
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
    }

}
