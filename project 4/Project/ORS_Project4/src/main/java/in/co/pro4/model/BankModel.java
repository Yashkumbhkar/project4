package in.co.pro4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.pro4.bean.BankBean;
import in.co.pro4.bean.OrderBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.DuplicateRecordException;
import in.co.pro4.utility.JDBCDataSource;

public class BankModel {
	
	public static Integer nextPK() throws ApplicationException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_BANK");
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

	/**
	 * 
	 * Add a User
	 *
	 */
	public static long add(BankBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_BANK VALUES(?, ?, ? )");
			pstmt.setLong(1, pk);
		     pstmt.setString(2, bean.getAccountName());
		     pstmt.setString(3, bean.getType());
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
		// log.debug("Model Add Ended");
		return pk;
	}

	/**
	 * 
	 * Update a user
	 * @throws Exception 
	 *
	 */
	public void update(BankBean bean) throws Exception {
	
		Connection conn = null;

		 
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("UPDATE ST_BANK SET ACCOUNT_NAME=?, TYPE=? WHERE ID=?");
			pstmt.setString(1, bean.getAccountName());
			pstmt.setString(2, bean.getType());
			pstmt.setLong(3, bean.getId());

			pstmt.executeUpdate();

			conn.commit();
			pstmt.close();

		
		}

	

	/**
	 * 
	 * Delete a User
	 *
	 */
	public static void delete(BankBean bean) throws ApplicationException {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ST_BANK WHERE id=?");
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
	 
	public BankBean findByPK(long pk) throws ApplicationException {

		Connection conn = null;
		BankBean bean = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from ST_BANK where id = ?");
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new BankBean();

				bean.setId(rs.getInt(1));
			    bean.setAccountName(rs.getString(2));
			    bean.setType(rs.getString(3));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
			throw new ApplicationException("Exception : In getting user by PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;
	}
	public List search(BankBean bean, int pageNo, int pageSize) throws ApplicationException {
		System.out.println("List search(BankBean bean, int pageNo, int pageSize)");

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_BANK WHERE 1=1");

		if (bean != null) {
		
			if (bean.getAccountName() !=  null  && bean.getAccountName().length() >0 ) {
				
				sql.append(" AND Account_Name like '" + bean.getAccountName() +"%'");
			}
			

		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;

			sql.append(" LIMIT " + pageNo + ", " + pageSize);
		}

		System.out.println(sql.toString());

		ArrayList list = new ArrayList();
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new BankBean();

				bean.setId(rs.getLong(1));
				bean.setAccountName(rs.getString(2));
				bean.setType(rs.getString(3));
				
				
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {

			throw new ApplicationException("Exception : in getting user list");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return list;

	}
}

	
	 
