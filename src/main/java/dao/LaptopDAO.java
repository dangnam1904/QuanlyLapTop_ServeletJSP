package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Laptop;


public class LaptopDAO {
	public static PreparedStatement ps;
	
	public static ArrayList<Laptop> getAlLLaptop(String sql){
		ArrayList<Laptop> listLaptop=new ArrayList<>();
		try {
			ps= ConnectDB.getConnect().prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				listLaptop.add(new Laptop(rs.getInt("idlaptop"),rs.getString("TenLapTop"),rs.getString("ThongSo"),rs.getInt("soluong"),rs.getInt("GiaNhap"),
						rs.getInt("GiaBan"),rs.getDate("NgayTao"),rs.getDate("NgaySua"),rs.getString("Anh"),rs.getInt("idLoai")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listLaptop;
	}
	
	public static int sumCount() {
		int sumRow= 0;
		try {
			ps = ConnectDB.getConnect().prepareStatement("select count(*)   from laptop ");
		
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				sumRow= s.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sumRow;
	}
	
	public static ArrayList<Laptop> getLaptopByName(String name){
		ArrayList<Laptop> listLaptop=new ArrayList<>();
		try {
			ps= ConnectDB.getConnect().prepareStatement("select * from laptop where tenlaptop like '%"+name.trim()+"%'");
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				listLaptop.add(new Laptop(rs.getInt("idLapTop"),rs.getString("TenLapTop"),rs.getString("ThongSo"),rs.getInt("soluong"),rs.getInt("GiaNhap"),
						rs.getInt("GiaBan"),rs.getDate("NgayTao"),rs.getDate("NgaySua"),rs.getString("Anh"),rs.getInt("idLoai")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listLaptop;
	}

	
	public static Laptop getALaptop(int idLaptop){
		Laptop laptop = new Laptop();
		try {
			ps= ConnectDB.getConnect().prepareStatement("select * from laptop where idLaptop=?");
			ps.setInt(1, idLaptop);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				laptop= new Laptop(rs.getInt("idLapTop"),rs.getString("TenLapTop"),rs.getString("ThongSo"),rs.getInt("soluong"),rs.getInt("GiaNhap"),
						rs.getInt("GiaBan"),rs.getDate("NgayTao"),rs.getDate("NgaySua"),rs.getString("Anh"),rs.getInt("idLoai"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return laptop;
	}
	
	public static boolean checkTonTaiLaptop(String name){
			boolean check= false;
		try {
			ps= ConnectDB.getConnect().prepareStatement("select * from laptop where tenlaptop =?");
			ps.setString(1, name);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				check= true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	public static boolean insertLapTop(Laptop lapTop) {
		boolean sucess= true;
		try {
			String sql= "insert into laptop values(?,?,?,?,?,?,?,?,?)";
			ps=ConnectDB.getConnect().prepareStatement(sql);
		
			ps.setString(1, lapTop.getTenLaptop());
			ps.setString(2, lapTop.getThongSo());
			ps.setInt(3, lapTop.getSoLuong());
			ps.setInt(4, lapTop.getGiaNhap());
			ps.setInt(5, lapTop.getGiaBan());
			ps.setDate(6, (Date) lapTop.getNgayTao());
			ps.setDate(7, (Date) lapTop.getNgaySua());
			ps.setString(8, lapTop.getAnh());
			ps.setInt(9, lapTop.getIdLoai());
			ps.execute();
		}catch(Exception e) {
			sucess=false;
			e.printStackTrace();
		}
		return sucess;
	}
	public static boolean updateLapTop(Laptop lapTop) {
		boolean sucess= true;
		try {
			String sql= "update laptop set tenlaptop=?, thongso=?, soluong=?, gianhap=?, giaban=?,ngaysua=?, anh=?, idLoai=? where idLaptop=?";
			ps=ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, lapTop.getTenLaptop());
			ps.setString(2, lapTop.getThongSo());
			ps.setInt(3, lapTop.getSoLuong());
			ps.setInt(4, lapTop.getGiaNhap());
			ps.setInt(5, lapTop.getGiaBan());
			
			ps.setDate(6, (Date) lapTop.getNgaySua());
			ps.setString(7, lapTop.getAnh());
			ps.setInt(8, lapTop.getIdLoai());
			ps.setInt(9, lapTop.getIdLaptop());
			ps.execute();
		}catch(Exception e) {
			sucess=false;
			e.printStackTrace();
		}
		return sucess;
	}
	
	public static boolean updateSoluongLaptop(int soluong, int idLaptop) {
		boolean sucess= true;
		try {
			String sql= "update laptop set  soluong=? where idLaptop=?";
			ps=ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, soluong);
			ps.setInt(2, idLaptop);
			ps.execute();
		}catch(Exception e) {
			sucess=false;
			e.printStackTrace();
		}
		return sucess;
	}
	public static boolean deleteLapTop(int idLaptop) {
		boolean sucess= true;
		try {
			String sql= "delete from  laptop  where idlaptop=?";
			ps=ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idLaptop);
			ps.execute();
		}catch(Exception e) {
			sucess=false;
			e.printStackTrace();
		}
		return sucess;
	}
public static void main(String[] args) {
	ArrayList<Laptop> list=LaptopDAO.getAlLLaptop("select * from laptop");
	for (Laptop laptop : list) {
		System.out.println(laptop.toString());
	}
}
}
