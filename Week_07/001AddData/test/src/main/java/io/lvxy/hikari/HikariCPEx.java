package io.lvxy.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO
 * https://zetcode.com/articles/hikaricp/
 * https://github.com/brettwooldridge/HikariCP#rocket-initialization
 *
 * @author lxy
 * @date 2021/2/20 19:56
 * @return
 */

public class HikariCPEx {
    /**
     * 线程100w,提交,用时：47s
     *
     * @param args
     */
    public static void main(String[] args) {

        String configFile = "/db.properties";

        HikariConfig cfg = new HikariConfig(configFile);
        HikariDataSource ds = new HikariDataSource(cfg);

        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ds.getConnection();
            String sql = "INSERT INTO businessCenter.bo_order " +
                    "(id, customer_id, order_sn, create_time, user_username, total_amount, pay_amount, freight_amount, pay_type, source_type," +
                    " status, order_type, delivery_company, delivery_sn, auto_confirm_day, receiver_name, receiver_phone, receiver_post_code, receiver_province, receiver_city, " +
                    "receiver_region, receiver_detail_address, note, confirm_status, delete_status, payment_time, delivery_time, receive_time, comment_time, modify_time) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //(1, 1222222, '11', null, 'user1', 1111.00, 888.00, 111.00,   111, 111, 1, 1,   '1', '1', 1,
            // '1dsfsdf', '11111111111', '12233333', '被那个大大的', '上海', '订单', '的点点滴滴', 'cerres', 1, 1,
            // '2021-03-07 13:38:45', '2021-03-09 21:38:51', '2021-03-11 21:38:57', '2021-03-11 21:39:03', '2021-03-07 21:39:08');
            pstm = con.prepareStatement(sql);
            Long startTime = System.currentTimeMillis();
            for (Long i = 1000006l; i <= 2000006l; i++) {
                pstm.setLong(1, i + 2);
                pstm.setLong(2, i + 1);
                pstm.setString(3, "订单编号" + i);
                pstm.setDate(4, (java.sql.Date) new Date(startTime));
                pstm.setString(5, "用户帐号" + i);

                pstm.setFloat(6, 0.1f);
                pstm.setFloat(7, 0.2f);
                pstm.setFloat(8, 0.3f);

                pstm.setInt(9, 1);
                pstm.setInt(10, 2);
                pstm.setInt(11, 3);
                pstm.setInt(12, 4);

                pstm.setString(13, "物流公司(配送方式)");
                pstm.setString(14, "物流单号");
                pstm.setInt(15, 2);//自动确认时间（天

                pstm.setString(16, "收货人姓名");
                pstm.setString(17, "收货人电话");
                pstm.setString(18, "收货人邮编");
                pstm.setString(19, "省份/直辖市");
                pstm.setString(20, "城市");
                pstm.setString(21, "区");
                pstm.setString(22, "详细地址");
                pstm.setString(23, "订单备注");

                pstm.setInt(24, 1);
                pstm.setInt(25, 1);

                pstm.setDate(26, (java.sql.Date) new Date(startTime));
                pstm.setDate(27, (java.sql.Date) new Date(startTime));
                pstm.setDate(28, (java.sql.Date) new Date(startTime));
                pstm.setDate(29, (java.sql.Date) new Date(startTime));
                pstm.setDate(30, (java.sql.Date) new Date(startTime));
                pstm.addBatch();
            }
            pstm.executeBatch();
            Long endTime = System.currentTimeMillis();
            System.out.println("100w,提交,用时：" + (endTime - startTime) / 1000 + "s");
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(HikariCPEx.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {


                if (pstm != null) {
                    pstm.close();
                }

                if (con != null) {
                    con.close();
                }

                ds.close();

            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(HikariCPEx.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}
