package cn.richinfo.test.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * 一个简单的DataSource实现
 *
 * @author leizhimin 2010-1-14 0:03:17
 */
public class SimpleDateSource implements DataSource {
    private static Log log = LogFactory.getLog(SimpleDateSource.class);
    private static final String dirverClassName = "oracle.jdbc.driver.OracleDriver";
    private static final String url = "jdbc:oracle:thin:@192.168.9.225:1521:umcdb";
    private static final String user = "global_user";
    private static final String pswd = "global_user";
    //连接池
    private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());
    private static SimpleDateSource instance = new SimpleDateSource();

    static {
        try {
            Class.forName(dirverClassName);
        } catch (ClassNotFoundException e) {
            log.error("找不到驱动类！", e);
        }
    }

    private SimpleDateSource() {
    }

    /**
     * 获取数据源单例
     *
     * @return 数据源单例
     */
    public SimpleDateSource instance() {
        if (instance == null) instance = new SimpleDateSource();
        return instance;
    }

    /**
     * 获取一个数据库连接
     *
     * @return 一个数据库连接
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        synchronized (pool) {
            if (pool.size() > 0) return pool.removeFirst();
            else return makeConnection();
        }
    }

    /**
     * 连接归池
     *
     * @param conn
     */
    public static void freeConnection(Connection conn) {
        pool.addLast(conn);
    }

    private Connection makeConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pswd);
    }

    public Connection getConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    public void setLoginTimeout(int seconds) throws SQLException {

    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

}