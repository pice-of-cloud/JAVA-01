package io.lvxy.jdbc;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author lxy
 * @version 1.0
 * @date 2021/2/20 12:25
 */
public class MainDemo {


    public static void main(String[] args) throws SQLException {


        System.out.println(JdbcUtils.selectTitleById(1L));

        JdbcUtils.add("增加标题","这是文章内容");
        System.out.println(JdbcUtils.selectTitleAll());

        JdbcUtils.editById("edit title", "edit content", 7L);

        System.out.println(JdbcUtils.selectTitleAll());

        JdbcUtils.removeById(21L);

        System.out.println(JdbcUtils.selectTitleAll());

        //PreparedStatement
        System.out.println(JdbcUtils.selectAllPer());
        String[] co = {"pre-titile","pre--content"};
        String sql = "insert into article (title,content) values (?,?)";
        JdbcUtils.excudePrepare( sql, co);
        System.out.println(JdbcUtils.selectAllPer());


        String[] co_edit = {"pre-titile_co_edit","pre--content--co_edit"};
        String sql_edit = "update article set title =?,content = ? where id="+7L;
        JdbcUtils.excudePrepare( sql_edit, co_edit);
        System.out.println(JdbcUtils.selectAllPer());

        //事务
        String sql_1 = "insert into article (id,title,content) values (27,?,?)";
        String sql_2 = "insert into article (id,title,content) values (27,?,?)";
        String[] co_commit = {"pre-titile_commit","pre--content--commit"};
        String[] co_commit_1 = {"pre-titile_commit_1","pre--content--commit_1"};


        JdbcUtils.excudeCommit(sql_1, sql_2,co_commit, co_commit_1);

        System.out.println(JdbcUtils.selectAllPer());
    }
}
