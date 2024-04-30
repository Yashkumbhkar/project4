package in.co.pro4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.pro4.bean.SchoolBean;
import in.co.pro4.bean.TopicBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.DuplicateRecordException;
import in.co.pro4.utility.JDBCDataSource;

public class TopicModel {
	
	public static Integer nextPK() throws ApplicationException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_TOPIC");
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

	public static long add(TopicBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_TOPIC VALUES(?, ? , ?)");
			pstmt.setLong(1, pk);
		     pstmt.setString(2, bean.getName());
		     pstmt.setString(3, bean.getDestruction());
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

		public void update(TopicBean bean) throws Exception {
	
		Connection conn = null;

		 
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("UPDATE ST_TOPIC SET NAME=? , DESTRUCTION = ? WHERE ID=?");
			 pstmt.setString(1, bean.getName());
			 pstmt.setString(2, bean.getDestruction());
			pstmt.setLong(3, bean.getId());

			pstmt.executeUpdate();

			conn.commit();
			pstmt.close();

		
		}

	

	public static void delete(TopicBean delete) throws ApplicationException {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ST_TOPIC WHERE id=?");
			pstmt.setLong(1, delete.getId());

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
	 
	public TopicBean findByPK(long pk) throws ApplicationException {

		Connection conn = null;
		TopicBean bean = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from ST_TOPIC where id = ?");
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new TopicBean();

				bean.setId(rs.getInt(1));
			     bean.setName(rs.getNString(2));
			     bean.setDestruction(rs.getString(3));
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
	
	public List search(TopicBean bean, int pageNo, int pageSize) throws Exception {
		System.out.println("List search(TopicBean bean, int pageNo, int pageSize)");

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_TOPIC WHERE 1=1");

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
				bean = new TopicBean();

				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));	
				bean.setDestruction(rs.getString(3));
				
				list.add(bean);
			}
			rs.close();
	

		return list;

	}

}
