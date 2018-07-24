package cn.richinfo.test;

import cn.richinfo.test.util.DBManager;
import org.junit.Test;

import java.sql.*;

public class DBManagertest {

    @Test
    public void test1(){
        Connection conn = null;
        PreparedStatement pstmst = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection("test");
            conn.setAutoCommit(false);
            pstmst = conn.prepareStatement("SELECT * FROM test.t_user");
            rs = pstmst.executeQuery();
            if(rs!=null&&rs.next()){
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
