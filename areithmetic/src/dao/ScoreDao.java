package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.JdbcUtil;
import beans.Score;

public class ScoreDao {
	public boolean insert(String id,int score){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num =0;
		try {
			String sql = "insert into paihang(id,score) values(?,?);";
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, score);
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

	public  List<Score> rank_all() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		List<Score> slist = new ArrayList<Score>();
		try {
			String sql = "select id,score from paihang order by score desc";
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Score temp = new Score();
				temp.setId(rs.getString(1));
				temp.setScore(rs.getInt(2));
				slist.add(temp);
			}
		} catch (SQLException e) {
		} finally{
			JdbcUtil.free(rs, pstmt, conn);
		}
		return slist;
	}
	
	public List<Score> rank_me(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		List<Score> slist = new ArrayList<Score>();
		try {
			String sql = "select id,score from paihang where id=? order by score desc";
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Score temp = new Score();
				temp.setId(rs.getString(1));
				temp.setScore(rs.getInt(2));
				slist.add(temp);
			}
		} catch (SQLException e) {
		} finally{
			JdbcUtil.free(rs, pstmt, conn);
		}
		return slist;
	}
}
