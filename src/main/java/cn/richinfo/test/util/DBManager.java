package cn.richinfo.test.util;


import org.apache.log4j.Logger;
import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBManager {
	private static Logger logger = Logger.getLogger(DBManager.class.getName());

	static {
		InputStream is = DBManager.class
				.getResourceAsStream("/proxool.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
			PropertyConfigurator.configure(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized Connection getConnection(String dbname) {

		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		Connection conn = null;
		try {
			int i = 0;
			while (i < 10) {
				conn = DriverManager.getConnection("proxool." + dbname);
				if (conn != null) {
					break;
				}
				if (conn == null) {
					logger.info("数据库连接池无可用连接，等待0.1秒钟再次获取连接！");
					try {

						Thread.sleep(100);

					} catch (Exception e) {
					}

				}
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	/**
	 * 取公共数据连接
	 *
	 * @return
	 */
	public static synchronized Connection getPartIdConnection() {
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		Connection conn = null;
		try {
			int i = 0;
			while (i < 10) {
				conn = DriverManager.getConnection("proxool.commPartId");
				if (conn != null) {
					break;
				}
				if (conn == null) {
					logger.info("数据库连接池无可用连接，等待0.1秒钟再次获取连接！");
					try {

						Thread.sleep(100);

					} catch (Exception e) {
					}

				}
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	public static void close(Statement stmt, Connection conn) {

		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		closeConnection(conn);
	}

	public static void close(PreparedStatement stmt, Connection conn) {

		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		closeConnection(conn);
	}

	public static void close(java.sql.ResultSet rs, PreparedStatement stmt,
							 Connection conn) {

		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		closeConnection(conn);
	}

	public static void close(CallableStatement stmt, Connection conn) {

		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		closeConnection(conn);
	}

	public static void close(java.sql.ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void close(PreparedStatement stmt) {

		try {

			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void close(Statement stmt) {

		try {

			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * 检测连接是否有效
	 *
	 * @param conn
	 * @return
	 */
	public static boolean isConnectionAlive(Connection conn) {
		if (conn == null) {
			return false;
		}

		ResultSet rs = null;
		Statement stmt = null;
		String query = "select 1 from dual ";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			conn = null;
			return false;
		} finally {

			close(rs);
			close(stmt);
		}
		return true;
	}

	// 关闭数据库连接，释放回数据库连接池
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
	}

}
