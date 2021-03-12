package io.lvxy.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * TODO
 *
 * @author lxy
 * @version 1.0
 * @date 2021/2/20 12:25
 */
public class MainDemo {


    /*
      单线程 100w,提交,用时：49s 47s
     */
    public static void main(String[] args) throws SQLException {

        try {
            Connection con = JdbcUtils.getConn();
            PreparedStatement pstm = null;

            String sql = "INSERT INTO businessCenter.bo_order " +
                    "( customer_id, order_sn, create_time, user_username, total_amount, pay_amount, freight_amount, pay_type, source_type," +
                    " status, order_type, delivery_company, delivery_sn, auto_confirm_day, receiver_name, receiver_phone, receiver_post_code, receiver_province, receiver_city, " +
                    "receiver_region, receiver_detail_address, note, confirm_status, delete_status, payment_time, delivery_time, receive_time, comment_time, modify_time) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //(1, 1222222, '11', null, 'user1', 1111.00, 888.00, 111.00,   111, 111, 1, 1,   '1', '1', 1,
            // '1dsfsdf', '11111111111', '12233333', '被那个大大的', '上海', '订单', '的点点滴滴', 'cerres', 1, 1,
            // '2021-03-07 13:38:45', '2021-03-09 21:38:51', '2021-03-11 21:38:57', '2021-03-11 21:39:03', '2021-03-07 21:39:08');
            pstm = con.prepareStatement(sql);
            Long startTime = System.currentTimeMillis();
            for (Long i = 5l; i < 1000006l; i++) {
                //pstm.setLong(1, i+2);
                int k = 0;
                pstm.setLong(++k, i+1);
                pstm.setString(++k, "订单编号"+i);
                pstm.setDate(++k, (java.sql.Date) new Date(startTime));
                pstm.setString(++k, "用户帐号"+i);

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

                pstm.setDate(++k, (java.sql.Date) new Date(startTime));
                pstm.setDate(++k, (java.sql.Date) new Date(startTime));
                pstm.setDate(++k, (java.sql.Date) new Date(startTime));
                pstm.setDate(++k, (java.sql.Date) new Date(startTime));
                pstm.setDate(++k, (java.sql.Date) new Date(startTime));
                pstm.addBatch();
            }
            pstm.executeBatch();
            pstm.close();
            con.close();
            Long endTime = System.currentTimeMillis();
            System.out.println("100w,提交,用时：" + (endTime - startTime)/1000+"s");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
