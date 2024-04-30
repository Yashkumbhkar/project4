package in.co.pro4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.pro4.bean.BankBean;
import in.co.pro4.bean.LessionBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.DuplicateRecordException;
import in.co.pro4.utility.JDBCDataSource;

public class LessionModel  {

	 
	public static Integer nextPK() throws ApplicationException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_LESSION");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {

			throw new ApplicationException("Exception : in getting next pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk + 1;
	}

	public static long add(LessionBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_LESSION VALUES(?, ?)");
			pstmt.setLong(1, pk);
		     pstmt.setString(2, bean.getName());
			pstmt.executeUpdate();

			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			// .error("Database Exception....", e);

			try {
				conn.rollback();
			} catch (Exception e1) {
				throw new ApplicationException("Exception : add rollback=" + e1.getMessage());
			}

			throw new ApplicationException("Exception : in adding user=" + e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk;
	}

		public void update(LessionBean bean) throws Exception {
	
		Connection conn = null;

		 
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("UPDATE ST_LESSION SET NAME=? WHERE ID=?");
			 pstmt.setString(1, bean.getName());
			pstmt.setLong(2, bean.getId());

			pstmt.executeUpdate();

			conn.commit();
			pstmt.close();

		
		}

	

	public static void delete(LessionBean bean) throws ApplicationException {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ST_LESSION WHERE id=?");
			pstmt.setLong(1, bean.getId());

			pstmt.executeUpdate();

			conn.commit();
			pstmt.close();
		} catch (Exception e) {

			try {
				conn.rollback();
			} catch (Exception e1) {
				throw new ApplicationException("Exception : delete rollback" + e1.getMessage());
			}
			throw new ApplicationException("Exception : in deleting user");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}
	 
	public LessionBean findByPK(long pk) throws ApplicationException {

		Connection conn = null;
		LessionBean bean = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from ST_LESSION where id = ?");
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new LessionBean();

				bean.setId(rs.getInt(1));
			     bean.setName(rs.getNString(2));			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
			throw new ApplicationException("Exception : In getting user by PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;
	}
	
	public List search(LessionBean bean, int pageNo, int pageSize) throws Exception {
		System.out.println("List search(LessionBean bean, int pageNo, int pageSize)");

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_LESSION WHERE 1=1");

		if (bean != null) {
		
			if (bean.getName()!= null && bean.getName().length() >0 ) {
				
				sql.append(" AND Name like '" + bean.getName() +"%'");
			}
			

		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;

			sql.append(" LIMIT " + pageNo + ", " + pageSize);
		}

		System.out.println(sql.toString());

		ArrayList list = new ArrayList();
		Connection conn = null;

		
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new LessionBean();

				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));				
				
				list.add(bean);
			}
			rs.close();
	

		return list;

	}
}

	
	 


