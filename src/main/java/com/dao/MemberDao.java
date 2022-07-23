package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.HouseBean;
import com.bean.MemberBean;
import com.util.DbConnection;

public class MemberDao {

	public void AddFamilyMember(MemberBean memberBean) {
		
		try {
			
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt =con.prepareStatement("insert into members (userid,name,contactnumber,age,gender,email) values (?,?,?,?,?,?)");
			
			pstmt.setInt(1, memberBean.getUserid());
			//pstmt.setInt(2, memberBean.getHouseid());
			pstmt.setString(2, memberBean.getName());
			System.out.println(memberBean.getName());
			pstmt.setString(3, memberBean.getContactnumber());
			pstmt.setInt(4, memberBean.getAge());
			pstmt.setString(5, memberBean.getGender());
			pstmt.setString(6, memberBean.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
		
		
		
	}

	public  ArrayList<MemberBean> GetAllMembers(int userid) {
		ArrayList<MemberBean> members= new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from members where userid=?");
			pstmt.setInt(1, userid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				MemberBean m =new MemberBean();
				m.setName(rs.getString("name"));
				m.setContactnumber(rs.getString("contactnumber"));
				m.setAge(rs.getInt("age"));
				m.setGender(rs.getString("gender"));
				m.setEmail(rs.getString("email"));
				m.setMemberid(rs.getInt("memberid"));
				m.setUserid(rs.getInt("userid"));
				members.add(m);
				System.out.println(m);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return members;
		
		
	}

	public void DeletefamilyMember(int memberid) {
	
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("delete from members where memberid=?");
			pstmt.setInt(1, memberid);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			
		}
		
		
		
		
	}

	
	
	
	
	
	
}
