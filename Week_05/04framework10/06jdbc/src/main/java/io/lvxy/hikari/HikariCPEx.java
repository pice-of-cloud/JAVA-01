package io.lvxy.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public static void main(String[] args) {

        String configFile = "/db.properties";

        HikariConfig cfg = new HikariConfig(configFile);
        HikariDataSource ds = new HikariDataSource(cfg);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pst = con.prepareStatement("SELECT * FROM article");
            rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println(rs.getString(1)+"---"+rs.getString(2));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(HikariCPEx.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }

                if (pst != null) {
                    pst.close();
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
