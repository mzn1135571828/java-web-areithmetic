package dao;
import beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.JdbcUtil;

public class UserDao {
	public boolean insert(User u){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num =0;
		try {
			String sql = "insert into user(id,pwd) values(?,?);";
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getId());
			pstmt.setString(2, u.getPwd());
			num = pstmt.executeUpdate();	
		} catch (SQLException e) {
		} finally{
			JdbcUtil.free(null, pstmt, conn);
		}
		if(num==1)
			return true;
		else
			return false;	
	}

	public boolean checkLogin(User u) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			String sql = "select id,pwd from user where id=? and pwd=?;";
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getId());
			pstmt.setString(2, u.getPwd());
			rs = pstmt.executeQuery();
			rs.last();
			if(rs.getRow()==1){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
		} finally{
			JdbcUtil.free(rs, pstmt, conn);
		}
		return false;
	}
	
	public boolean register(User u) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			String sql = "select id,pwd from user where id=?;";
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getId());
			rs = pstmt.executeQuery();
			rs.last();
			if(rs.getRow()>=1){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
		} finally{
			JdbcUtil.free(rs, pstmt, conn);
		}
		return false;
	}
}
