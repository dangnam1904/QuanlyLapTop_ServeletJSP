package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.LoaiLaptop;

public class LoaiLaptopDAO {
	public static PreparedStatement ps;
	
	public static ArrayList<LoaiLaptop> getAllLoaiLaptop(String sql){
		ArrayList<LoaiLaptop> listLoaiLaptop=new ArrayList<>();
		try {
			ps= ConnectDB.getConnect().prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				listLoaiLaptop.add(new LoaiLaptop(rs.getInt(1), rs.getString(2)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listLoaiLaptop;
	}

	public static LoaiLaptop getALoaiLaptop(int idLoai){
		LoaiLaptop l= null;
		try {
			ps= ConnectDB.getConnect().prepareStatement("select * from loailaptop where idloai=?");
			ps.setInt(1, idLoai);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				l=new LoaiLaptop(rs.getInt(1), rs.getString(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	public static LoaiLaptop getALoaiLaptopByName(String name){
		LoaiLaptop l= null;
		try {
			ps= ConnectDB.getConnect().prepareStatement("select * from loailaptop where tenloai=?");
			ps.setString(1, name);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				l=new LoaiLaptop(rs.getInt(1), rs.getString(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public static boolean insertLoaiLapTop(LoaiLaptop loaiLapTop) {
		boolean sucess= true;
		try {
			String sql= "insert into loailaptop values(?)";
			ps=ConnectDB.getConnect().prepareStatement(sql);
		
			ps.setString(1, loaiLapTop.getTenLoai());
			ps.execute();
		}catch(Exception e) {
			sucess=false;
			e.printStackTrace();
		}
		return sucess;
	}
	public static boolean updateLoaiLapTop(LoaiLaptop loaiLapTop) {
		boolean sucess= true;
		try {
			String sql= "update loailaptop set tenloai=? where idLoai=?";
			ps=ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(2, loaiLapTop.getIdLoai());
			ps.setString(1, loaiLapTop.getTenLoai());
			ps.execute();
		}catch(Exception e) {
			sucess=false;
			e.printStackTrace();
		}
		return sucess;
	}
	
	public static boolean deleteLoaiLapTop(int idLoai) {
		boolean sucess= true;
		try {
			String sql= "delete from  loailaptop  where idLoai=?";
			ps=ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idLoai);
			ps.execute();
		}catch(Exception e) {
			sucess=false;
			e.printStackTrace();
		}
		return sucess;
	}
	
	
}
