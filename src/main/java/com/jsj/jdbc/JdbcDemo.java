package com.jsj.jdbc;

import java.sql.*;

/**
 * JDBC的DEMO
 *
 * @author jsj
 * @date 2019-01-22
 */
public class JdbcDemo {
    private static String URL = "jdbc:mysql://119.23.204.78:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";

    /**
     * Driver类进行预加载
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    private static Connection getConn() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放资源
     *
     * @param connection
     */
    private static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    /**
     * 执行并返回结果
     *
     * @param sql
     * @return
     */
    public static void execute(String sql, String... params) {
        Connection conn = getConn();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            //参数填充
            for (int i = 0; i < params.length; i++) {
                ps.setString(i + 1, params[i]);
            }
            //SQL执行
            ResultSet rs = ps.executeQuery();
            //结果打印
            dealResultSet(rs);
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            close(conn);
        }
    }

    /**
     * 处理返回结果集
     *     
     */
    public static void dealResultSet(ResultSet rs) {
        if (rs == null) return;
        try {
            ResultSetMetaData data = rs.getMetaData();
            StringBuilder sb = new StringBuilder();
            int size = 0;
            for (int count = data.getColumnCount(); rs.next(); size++) {
                for (int i = 1; i <= count; i++) {
                    sb.append(data.getColumnName(i))
                            .append("=")
                            .append(rs.getString(i))
                            .append("\n");
                }
                sb.append("----------------------\n");
            }
            sb.append("共 ").append(size).append(" 条记录");
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String SQL = "select * from film where description like ?";
        execute(SQL, "%China%");
    }
}
