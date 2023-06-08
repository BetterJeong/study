package final1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardBean {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String jdbc_driver = "con.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1:3306/jspdb?useSSL=false&serverTimezone=Asia/Seoul";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean insertBoard(Board board) throws SQLException {
		connect();
		
		String sql = "INSERT INTO board(board_title, board_name, board_id, board_date, board_content) VALUES(?, ?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_title());
			pstmt.setString(2, board.getBoard_name());
			pstmt.setString(3, board.getBoard_id());
			pstmt.setString(4, board.getBoard_date());
			pstmt.setString(5, board.getBoard_content());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public Board getBoard(int board_num) throws SQLException {
		connect();
		Board board = null;
		String sql = "select * from board where board_num? ";
		try {
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) {
				board = new Board();
				board.setBoard_id(rs.getString("board_id"));
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_title(rs.getString("board_title"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_date(rs.getString("board_date"));
				board.setBoard_content(rs.getString("board_content"));
			}
			rs.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}
		finally {
			disconnect();
		}
		return board;
	}
	
	public ArrayList<Board> getBoardList() throws SQLException {
		connect();
		ArrayList<Board> boards = new ArrayList<Board>();
		String sql = "select * from board order by board_num desc";
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Board board = new Board();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_title(rs.getString("board_title"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_date(rs.getString("board_date"));
				boards.add(board);
			}
			rs.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}
		finally {
			disconnect();
		}
		return boards;
	}
	
	public boolean deleteBoard(int board_num) throws SQLException {
		connect();
		
		String sql = "delete from board where board_num=?";
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
	
	public boolean updateBoard(Board board) throws SQLException {
		connect();
		String sql = "update board set board_title=?, board_date=?, board_content=? where board_num=?";
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_title());
			pstmt.setString(2, board.getBoard_date());
			pstmt.setString(3, board.getBoard_content());
			pstmt.setInt(4, board.getBoard_num());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
}
