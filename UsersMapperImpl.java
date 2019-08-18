package util.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import poi.XLSXWriter;
import util.JDBCUtils;

public class UsersMapperImpl implements UsersMapper {

	@Override
	public User getClientById(User user) {
		Connection conn = JDBCUtils.createConnection();
		Statement stmt = null;
		User result = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM INNOWISEGROUPTASK.USERS WHERE ID = " + user.getId());
			if(rs.next()){
				// Strings
				result = new User();
				result.setId(user.getId());
				result.setName(rs.getString("First_Name"));
				result.setLastName(rs.getString("Last_Name"));;
				result.setEmail(rs.getString("Email"));
				result.setNumberPhone(rs.getString("Phone_Number"));
				result.setRole(rs.getString("Role"));
			} else {
				System.out.println("No such client found with ID = " + user.getId());
			}
			
			JDBCUtils.release(conn, stmt, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> resultCli = new ArrayList<>();
		User user = null;
        String selectSQL = "SELECT * FROM INNOWISEGROUPTASK.USERS";
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = JDBCUtils.createConnection();
            pstmt = conn.prepareStatement(selectSQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("First_Name"));
                user.setLastName(rs.getString("Last_Name"));;
                user.setEmail(rs.getString("Email"));
                user.setNumberPhone(rs.getString("Phone_Number"));
                user.setRole(rs.getString("Role"));
                resultCli.add(user);
            }
            JDBCUtils.release(conn, null, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultCli;
	}
	
	
	@Override
	public boolean insertClient(User user) {
		String insertSQL = "INSERT INTO INNOWISEGROUPTASK.USERS (First_Name, Last_Name, Email, Phone_Number, Role) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean isInserted = false;
		try {
			conn = JDBCUtils.createConnection();
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getNumberPhone());
			pstmt.setString(5, user.getRole());
			isInserted = pstmt.executeUpdate() == 1;
			
			JDBCUtils.release(conn, null, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isInserted;
	}

	@Override
	public boolean updateClient(User user) {
		String updateSQL = "UPDATE INNOWISEGROUPTASK.USERS SET First_Name = ?, Last_Name = ?, Email = ?, Phone_Number = ?, Role = ? WHERE ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean isUpdated = false;
		try {
			conn = JDBCUtils.createConnection();
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getNumberPhone());
			pstmt.setString(5, user.getRole());
			pstmt.setInt(6, user.getId());
			
			isUpdated = pstmt.executeUpdate() == 1;

			JDBCUtils.release(conn, null, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdated;
	}

	@Override
	public boolean deleteClient(User user) {
		String deleteSQL = "DELETE FROM INNOWISEGROUPTASK.USERS WHERE ID = ?";
		
		user = getClientById(user);

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean isDelited = false;
		try {
			conn = JDBCUtils.createConnection();
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, user.getId());
			
			isDelited = pstmt.executeUpdate() == 1;
			JDBCUtils.release(conn, null, pstmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return isDelited;
	}
	
	public static void main(String[] args) {
		UsersMapperImpl impl = new UsersMapperImpl();
		User key = new User(2);
		User dbu = impl.getClientById(key);
		System.out.println(dbu);
		
	//	User us = new User("John", "Johnson", "Johnson@gmail.com", "Student", "375295485968");
	//	impl.insertClient(us);
	//	System.out.println(us);
		dbu.setEmail("Alex@gmail");
		boolean isUp = impl.updateClient(dbu);
		System.out.println(isUp);
//		impl.deleteClient(impl.getClientById(key));
//		System.out.println(impl.getAllUsers());
		
//		try {
//			List<User> users = new XLSXWriter("resources\\file_example_XLS_1000.xlsx").setUsers(impl.getAllUsers());
//			for (User user : users) {
//				impl.insertClient(user);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
