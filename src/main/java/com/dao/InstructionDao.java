package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.HouseBean;
import com.bean.InstructionBean;
import com.util.DbConnection;

public class InstructionDao {

	public void AddInstruction(int userid,InstructionBean instructionBean) {
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("insert into instructions (userid,memberid,houseid,name,type,description,allow) values (?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, userid);
			pstmt.setInt(2,instructionBean.getMemberid() );
			pstmt.setInt(3, instructionBean.getHouseid());
			pstmt.setString(4, instructionBean.getName());
			pstmt.setString(6, instructionBean.getDescription());
			pstmt.setString(5, instructionBean.getType());
			pstmt.setInt(7, instructionBean.getAllow());
			
			pstmt.executeQuery();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	public ArrayList<InstructionBean> AllInstructionList(int userid) {
		ArrayList<InstructionBean> instructions= new ArrayList<>();
		try {
			
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from instructions where userid=?");
			pstmt.setInt(1, userid);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{System.out.println("shweta");
			InstructionBean i =new InstructionBean();
				i.setName(rs.getString("name"));
				i.setInstructionid(rs.getInt("instructionid"));
				System.out.println("instructionid");
				i.setType(rs.getString("type"));
				i.setDescription(rs.getString("description"));
				i.setAllow(rs.getInt("allow"));
				
				
				i.setUserid(rs.getInt("userid"));
				instructions.add(i);
				System.out.println(i);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instructions;
	}

	public ArrayList<InstructionBean> AllInstructionListForSecurity() {
		
		ArrayList<InstructionBean> instructions= new ArrayList<>();
		try {
			
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from instructions ");
			
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{System.out.println("shweta");
			InstructionBean i =new InstructionBean();
				i.setName(rs.getString("name"));
				i.setType(rs.getString("type"));
				i.setDescription(rs.getString("description"));
				i.setAllow(rs.getInt("allow"));
				
				
				i.setUserid(rs.getInt("userid"));
				instructions.add(i);
				System.out.println(i);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instructions;
		
		
	}

	public void AllowToDisable(int instructionid) {
		
		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update instructions set allow = ? where instructionid=?");
				){
			System.out.println(instructionid);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, instructionid);
		 pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void DeleteInstruction(int instructionid) {
		
		try {
			
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("delete from instructions where instructionid=?");
			pstmt.setInt(1, instructionid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
