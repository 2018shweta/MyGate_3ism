package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.bean.HouseBean;
import com.util.DbConnection;

public class HouseDao {

	public void AddHouseDetails(HouseBean houseBean,int userid) {
		
		try {
			
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("insert into houses (houseno,houseflor,block,userid) values (?,?,?,?)");
			pstmt.setInt(1, houseBean.getHouseno());
			pstmt.setInt(2, houseBean.getHouseflor());
			pstmt.setString(3, houseBean.getBlock());
			pstmt.setInt(4, userid);
			
			pstmt.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	
	}

	public ArrayList<HouseBean> ListHousedetails(int userid) {
		ArrayList<HouseBean> houses= new ArrayList<>();
		try {
			Connection con =DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from houses where userid=?");
			pstmt.setInt(1,userid);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{System.out.println("shweta");
				HouseBean h =new HouseBean();
				h.setHouseno(rs.getInt("houseno"));
				h.setHouseflor(rs.getInt("houseflor"));
				h.setBlock(rs.getString("block"));
				h.setHouseid(rs.getInt("houseid"));
				h.setUserid(rs.getInt("userid"));
				houses.add(h);
				System.out.println(h);
			}
			
			
		} catch (Exception e) {
			
			
			
		}
		
		return houses;
	}

	public void DeleteHouse(int houseid) {
		
		
		try {
			Connection con =DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("delete from houses where houseid=?");
			pstmt.setInt(1, houseid);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	
	
	
	
	
	
	
}
