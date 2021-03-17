package io.lvxy.jdbc;

import java.sql.*;

public class JdbcUtils {
    //通过上面的工具就可以获取到properties文件中的键值从而可以加载驱动 获取链接 从而 可以增删改查
    private static Connection conn = null;

    public static Connection getConn() {
        PropertiesUtil.loadFile("jdbc.properties");
        String driver = PropertiesUtil.getPropertyValue("driver");
        String url = PropertiesUtil.getPropertyValue("url");
        String username = PropertiesUtil.getPropertyValue("username");
        String password = PropertiesUtil.getPropertyValue("password");


        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            close();
        }
        return conn;
    }


    public static void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过id到数据库中获取内容
     *
     * @param id
     * @return
     */
    public static String selectTitleById(Long id) {
        //SQL语句
        String sql = "select title from article where id = +" + id;
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        ResultSet ret = null;
        String title = null;
        try {
            stmt = conn.createStatement();
            //执行语句，得到结果集
            ret = stmt.executeQuery(sql);
            while (ret.next()) {
                //这里只查询的标题
                title = ret.getString(1);
            }
            ret.close();
            conn.close();//关闭连接
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return title;
    }


    public static String selectTitleAll() {
        //SQL语句
        String sql = "select title,id from article";
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        ResultSet ret = null;
        StringBuffer title = new StringBuffer("selectTitleAll---");
        try {
            stmt = conn.createStatement();
            //执行语句，得到结果集
            ret = stmt.executeQuery(sql);
            while (ret.next()) {
                title.append("~~~~~id:").append((ret.getString(2))).append("~title").append(ret.getString(1)).append("---");

            }
            ret.close();
            conn.close();//关闭连接
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return title.toString();
    }

    public static int add(String title, String content) {
        //SQL语句
        String sql = "insert into article (title,content) values ('" + title + "','" + content + "')";
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        int ret = 0;
        try {
            stmt = conn.createStatement();
            //执行语句，得到结果集
            ret = stmt.executeUpdate(sql);

            conn.close();//关闭连接
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return ret;
    }


    public static int editById(String title, String content, Long id) {
        //SQL语句
        String sql = "update article set title ='" + title + "',content = '" + content + "' where id=" + id;
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        int ret = 0;
        try {
            stmt = conn.createStatement();
            //执行语句，得到结果集
            ret = stmt.executeUpdate(sql);

            conn.close();//关闭连接
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return ret;
    }


    public static int removeById(Long id) {
        String sql = "delete from article where id=" + id;
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        int ret = 0;
        try {
            stmt = conn.createStatement();
            //执行语句，得到结果集
            ret = stmt.executeUpdate(sql);

            conn.close();//关闭连接
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return ret;
    }


    public static String selectAllPer() {

        //SQL语句
        String sql = "select * from article";
        Connection conn = JdbcUtils.getConn();
        // Statement stmt = null;
        PreparedStatement preparedStatement = null;
        ResultSet ret = null;
        StringBuffer title = new StringBuffer("selectAllPer---");
        try {
            //stmt = conn.createStatement();
            preparedStatement = conn.prepareStatement(sql);
            //执行语句，得到结果集
            // ret = stmt.executeQuery(sql);
            ret = preparedStatement.executeQuery();
            while (ret.next()) {
                //这里只查询的标题

                title.append("~~~~~id:").append((ret.getString(2))).append("~title").append(ret.getString(1)).append("---");
            }
            ret.close();
            conn.close();//关闭连接
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return title.toString();

    }


    public static void excudePrepare(String sql, String[] values) {
        //SQL语句
        Connection conn = JdbcUtils.getConn();
        PreparedStatement stmt = null;
        int ret = 0;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, values[0]);
            stmt.setString(2, values[1]);
            //执行语句，得到结果集
            ret = stmt.executeUpdate();

            conn.close();//关闭连接
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


    /**
     * 事务隔离级别
     * <p>
     * 1、事务的并发读问题
     * <p>
     * 脏读：读取到另外一个事务未提交数据（不允许出来的事）；
     * 不可重复读：两次读取不一致；
     * 幻读（虚读）：读到另一事务已提交数据。
     * 2、并发事务问题
     * <p>
     * 因为并发事务导致的问题大致有5类，其中两类是更新问题三类是读问题。
     * <p>
     * 脏读（dirty read）：读到另一个事务的未提交新数据，即读取到了脏数据；
     * 不可重复读（unrepeatable）：对同一记录的两次读取不一致，因为另一事务对该记录做了修改；
     * 幻读（虚读）（phantom read）：对同一张表的两次查询不一致，因为另一事务插入了一条记录。
     * 3、四大隔离级别
     * <p>
     * 4个等级的事务隔离级别，在相同的数据环境下，使用相同的输入，执行相同的工作，根据不同的隔离级别，可以导致不同的结果。不同事务隔离级别能够解决的数据并发问题的能力是不同的。
     * <p>
     * 1、SERIALIZABLE(串行化)
     * <p>
     * 不会出现任何并发问题，因为它是对同一数据的访问是串行的，非并发访问的；
     * 性能最差
     * 2、REPEATABLE READ(可重复读)（MySQL）
     * <p>
     * 防止脏读和不可重复读，不能处理幻读
     * 性能比SERIALIZABLE好
     * 3、READ COMMITTED(读已提交数据)（Oracle）
     * <p>
     * 防止脏读，不能处理不可重复读和幻读；
     * 性能比REPEATABLE READ好
     * 4、READ UNCOMMITTED(读未提交数据)
     * <p>
     * 可能出现任何事物并发问题，什么都不处理。
     * 性能最好
     * 六、MySQL隔离级别
     * <p>
     * MySQL的默认隔离级别为Repeatable read,可以通过下面语句查看：
     * <p>
     * SELECT @@`TX_ISOLATION`;
     * <p>
     * 也可以通过下面语句来设置当前连接的隔离级别：
     * <p>
     * SET TRANSACTION ISOLATION LEVEL REPEATABLE READ ;//[4选1]
     * <p>
     * JDBC设置隔离级别
     * <p>
     * con.setTransactionIsolation(int level) :参数可选值如下：
     * <p>
     * Connection.TRANSACTION_READ_UNCOMMITTED；
     * Connection.TRANSACTION_READ_COMMITTED；
     * Connection.TRANSACTION_REPEATABLE_READ；
     * Connection.TRANSACTION_READ_SERIALIZABLE。
     */

    public static void excudeCommit(String sql, String sql2, String[] values, String[] values2) throws SQLException {
        //SQL语句
        Connection conn = JdbcUtils.getConn();

        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;

        int ret = 0;

        try {
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, values[0]);
            stmt.setString(2, values[1]);
            //执行语句，得到结果集
            ret = stmt.executeUpdate();

            stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, values2[0]);
            stmt2.setString(2, values2[1]);
            stmt.executeUpdate();

            conn.commit();

        } catch (SQLException e1) {
            e1.printStackTrace();
            System.out.println("---------------异常了");
            try {
                conn.rollback();
                System.out.println("事务回滚");
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        conn.close();

    }
}


