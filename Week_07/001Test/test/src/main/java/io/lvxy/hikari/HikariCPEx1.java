package io.lvxy.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.lvxy.jdbc.JdbcUtils;
import io.lvxy.jdbc.MainDemo2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.*;
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

public class HikariCPEx1 {
    /**
     * 线程100w,提交,用时：CountDownLatch=2 thread=2,26s thread=3,14s  thread=4,14s thread=4,15s thread=5,15s
     *CountDownLatch=3 thread=3,18s  thread=4,18s
     * @param args
     */
    public static void main(String[] args) {

        String configFile = "/db.properties";

        HikariConfig cfg = new HikariConfig(configFile);
        HikariDataSource ds = new HikariDataSource(cfg);

        Connection con = null;
        PreparedStatement pstm = null;
        final String sql = "INSERT INTO businessCenter.bo_order " +
                "( customer_id, order_sn, create_time, user_username, total_amount, pay_amount, freight_amount, pay_type, source_type," +
                " status, order_type, delivery_company, delivery_sn, auto_confirm_day, receiver_name, receiver_phone, receiver_post_code, receiver_province, receiver_city, " +
                "receiver_region, receiver_detail_address, note, confirm_status, delete_status, payment_time, delivery_time, receive_time, comment_time, modify_time) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //(1, 1222222, '11', null, 'user1', 1111.00, 888.00, 111.00,   111, 111, 1, 1,   '1', '1', 1,
        // '1dsfsdf', '11111111111', '12233333', '被那个大大的', '上海', '订单', '的点点滴滴', 'cerres', 1, 1,
        // '2021-03-07 13:38:45', '2021-03-09 21:38:51', '2021-03-11 21:38:57', '2021-03-11 21:39:03', '2021-03-07 21:39:08');

        Long startTime = System.currentTimeMillis();
        final int countSize = 3;
        CountDownLatch latch = new CountDownLatch(countSize);
        ExecutorService taskExecutor = Executors.newFixedThreadPool(4);
        for (int i=1; i<= countSize; i++){
            taskExecutor.execute(new MyTask(latch,ds,sql));
        }
        try {
            latch.await();
            taskExecutor.shutdown();
        } catch (InterruptedException E) {
            // handle
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("100w,提交,用时：" + (endTime - startTime)/1000+"s");

    }

    static class  MyTask implements Runnable{
        private CountDownLatch countDownLatch;
        HikariDataSource ds;
        String sql;
        Connection con;
        PreparedStatement pstm;
        public MyTask(CountDownLatch count, HikariDataSource ds, String sql){
            this.countDownLatch = count;
            this.ds = ds;
            this.sql = sql;
            try {
                con = ds.getConnection();
                pstm = con.prepareStatement(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        @Override
        public void run() {
            for (Long i = 1l; i < 250006l; i++) {
                //pstm.setLong(1, i+2);
                int k = 0;
                try {
                    pstm.setLong(++k, i + 1);

                    pstm.setString(++k, "订单编号" + i);
                    pstm.setDate(++k, (Date) new Date(System.currentTimeMillis()));
                    pstm.setString(++k, "用户帐号" + i);

                    pstm.setFloat(++k, 0.1f);
                    pstm.setFloat(++k, 0.2f);
                    pstm.setFloat(++k, 0.3f);

                    pstm.setInt(++k, 1);
                    pstm.setInt(++k, 2);
                    pstm.setInt(++k, 3);
                    pstm.setInt(++k, 4);

                    pstm.setString(++k, "物流公司(配送方式)");
                    pstm.setString(++k, "物流单号");
                    pstm.setInt(++k, 2);//自动确认时间（天

                    pstm.setString(++k, "收货人姓名");
                    pstm.setString(++k, "收货人电话");
                    pstm.setString(++k, "收货人邮编");
                    pstm.setString(++k, "省份/直辖市");
                    pstm.setString(++k, "城市");
                    pstm.setString(++k, "区");
                    pstm.setString(++k, "详细地址");
                    pstm.setString(++k, "订单备注");

                    pstm.setInt(++k, 1);
                    pstm.setInt(++k, 1);

                    pstm.setDate(++k, (Date) new Date(System.currentTimeMillis()));
                    pstm.setDate(++k, (Date) new Date(System.currentTimeMillis()));
                    pstm.setDate(++k, (Date) new Date(System.currentTimeMillis()));
                    pstm.setDate(++k, (Date) new Date(System.currentTimeMillis()));
                    pstm.setDate(++k, (Date) new Date(System.currentTimeMillis()));
                    pstm.addBatch();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            try {
                pstm.executeBatch();
                pstm.close();
                con.close();
                countDownLatch.countDown();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
