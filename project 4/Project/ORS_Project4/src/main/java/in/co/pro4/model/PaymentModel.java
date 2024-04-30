package in.co.pro4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import in.co.pro4.bean.OrderBean;
import in.co.pro4.bean.PaymentBean;
import in.co.pro4.bean.UserBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.DuplicateRecordException;
import in.co.pro4.exception.RecordNotFoundException;
import in.co.pro4.utility.EmailBuilder;
import in.co.pro4.utility.EmailMassage;
import in.co.pro4.utility.EmailUtility;
import in.co.pro4.utility.JDBCDataSource;

public class PaymentModel{
	
	 
	public static Integer nextPK() throws ApplicationException {
		

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_PAYMENT");
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
	public static long add(PaymentBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO ST_PAYMENT VALUES(?, ?, ?, ?, ? ,?)");
			pstmt.setLong(1, pk);
	 	     pstmt.setString(2, bean.getPaymentType());
	 	     pstmt.setInt(3, bean.getAmount());
	 	     pstmt.setString(4, bean.getBankName());
	 	     pstmt.setString(5, bean.getCustomerName());
	 	     pstmt.setInt(6, bean.getTransactionId());
	 	     
	 	     
			pstmt.executeUpdate();
 
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
     
try {conn.rollback();} catch (Exception e1) {throw new ApplicationException("Exception : add rollback=" + e1.getMessage());}


       throw new ApplicationException("Exception : in adding user="+e.getMessage());	
			
	} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}
	/**
	 * 
	 * Update a user
	 * @throws Exception 
	 *
	 */
	public void update(PaymentBean bean) throws Exception {
		
		
		Connection conn = null ; 
	
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE ST_PAYMENT SET Payment_Type =?,Amount =?,Bank_Name =?, Customer_Name=?, Transaction_Id=? WHERE  ID=?");
			
			pstmt.setString(1, bean.getPaymentType());
		 	     pstmt.setInt(2, bean.getAmount());
		 	     pstmt.setString(3, bean.getBankName());
		 	     pstmt.setString(4, bean.getCustomerName());
		 	     pstmt.setInt(5, bean.getTransactionId());
		 	     pstmt.setLong(6, bean.getId());
		 	     
			
			pstmt.executeUpdate();

			conn.commit();
			pstmt.close();

		
	}
	/**
	 * 
	 * Delete a User
	 *
	 */
	public static void delete(PaymentBean bean) throws ApplicationException {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ST_PAYMENT WHERE id=?");
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


	/**
	 * 
	 * Find User by Login
	 *
	 */

	/**
	 * 
	 * Find User by PK
	 *
	 */
	public PaymentBean findByPK(long pk) throws ApplicationException {
	
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_PAYMENT WHERE ID=?");

		Connection conn = null;
		PaymentBean bean = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new PaymentBean();

				bean.setId(rs.getLong(1));
			    bean.setPaymentType(rs.getString(2));
		 	     bean.setAmount(rs.getInt(3));
		 	     bean.setBankName(rs.getString(4));
		 	     bean.setCustomerName(rs.getString(5));
		 	     bean.setTransactionId(rs.getInt(6));
		 	    
		 	     
			}
			rs.close();
		} catch (Exception e) {
			
			throw new ApplicationException("Exception : In getting user by PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
		return bean;
	}
	
	public List search(PaymentBean bean, int pageNo, int pageSize) throws ApplicationException, Exception {
		System.out.println("List search(PaymentBean bean, int pageNo, int pageSize)");

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_PAYMENT WHERE 1=1");

		if (bean != null) {
			System.out.println(bean.getId());
			if (bean.getId() > 0) {
				sql.append(" AND ID like '" + bean.getId() + "%'");
			}
			if (bean.getBankName()!=null && bean.getBankName().length()>0) {
				sql.append(" AND BANK_NAME like '" + bean.getBankName() + "%'");
			}

		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;

			sql.append(" LIMIT " + pageNo + "," + pageSize);
		}

		System.out.println(sql.toString());

		List list = new ArrayList();
		Connection conn = null;

		
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new  PaymentBean();

				bean.setId(rs.getLong(1));
				bean.setPaymentType(rs.getString(2));
				bean.setAmount(rs.getInt(3));
				bean.setBankName(rs.getString(4));
				bean.setCustomerName(rs.getString(5));
				bean.setTransactionId(rs.getInt(6));
				list.add(bean);
			}
			rs.close();
		
			JDBCDataSource.closeConnection(conn);
		

		return list;
		}

}

		