package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	public void insertUser(UserBean userBean) {
		
		
		
		System.out.println("insertUser method");
		try {
			Connection con = DbConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"insert into users (firstname,lastname,email,password,gender,contactnumber,role,approve) values (?,?,?,?,?,?,'member',?)");
			pstmt.setString(1, userBean.getFirstname());
			pstmt.setString(2, userBean.getLastname());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
			pstmt.setString(6, userBean.getContactnumber());
			pstmt.setInt(7, userBean.getApprove());
			
			int records = pstmt.executeUpdate();

			System.out.println(records + " inserted...........");
		} catch (Exception e) {
			System.out.println("SMW in insertUser() ");
			e.printStackTrace();
		}
		
	}

	public UserBean login(String email, String password) {
		UserBean user = null;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ? ");
			pstmt.setString(1, email);
//			System.out.println(email);
			System.out.println(" dao login method");
			pstmt.setString(2, password);

			// read select
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserid(rs.getInt("userid"));
				user.setFirstname(rs.getString("firstname"));
				user.setRole(rs.getString("role"));
				user.setApprove(rs.getInt("approve"));
				//
				System.out.println(" dao login method andar");
			}

		} catch (Exception e) {
			System.out.println("SMW in login Dao ");
			e.printStackTrace();
		}

		return user;
		
	}

	public static ArrayList<UserBean> getAllMember() {
		
		
		
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users");

			ResultSet rs = pstmt.executeQuery();// select readonly ==>query

			while (rs.next() == true) { // 1st row 2nd row
				int userId = rs.getInt("userid");// db column name
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String contactnumber=rs.getString("contactnumber");

				UserBean user = new UserBean();
				user.setUserid(userId);
				user.setFirstname(firstName);
				user.setLastname(lastName);
				user.setEmail(email);
				user.setPassword(password);
				user.setGender(gender);
				user.setContactnumber(contactnumber);
				users.add(user);
			}
			// go to line num -> 63

			// user1
			// user2

		} catch (Exception e) {
			System.out.println("SMW in UserDAO::getAllUsers()");
			e.printStackTrace();
		}

		return users;
		
		
		
		
	}

	public int approve(int userid) {
		
		try{

			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set approve = ? where userid=?");
			pstmt.setInt(1, 1);
			pstmt.setInt(2, userid);
			int records = pstmt.executeUpdate();
			return records;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;

	
	}

	public Boolean ForgetPassword(String email, String contactnumber) {
		
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from users where email=? and contactnumber=?");
			pstmt.setString(2, contactnumber);
			pstmt.setString(1, email);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		} catch (Exception e) {
			
		}
		return false;
	}

	public Boolean ResetPassword(String email, String newpassword) {
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("update  users set password=? where email=?   ");
			pstmt.setString(1, newpassword);
			pstmt.setString(2, email);
			
			pstmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	
}
