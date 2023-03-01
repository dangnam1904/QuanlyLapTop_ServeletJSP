package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.NhapHang;
import model.ThongKeNhapHang;

public class NhapHangDAO {
	public static PreparedStatement ps;

	public static ArrayList<NhapHang> getAllNhapHang(String sql) {
		ArrayList<NhapHang> listNH = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listNH.add(new NhapHang(s.getInt(1), s.getString(2), s.getString(3), s.getString(4),s.getDate(5), s.getDate(6),
						s.getDate(7), s.getString(8)));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNH;
	}
	
	public static ArrayList<NhapHang> findNhapHangByTenNguoGui(String tennguoigui) {
		ArrayList<NhapHang> listNH = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement("select * from NhapHang where TenNguoiGui like '%"+tennguoigui.trim()+"%'");
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listNH.add(new NhapHang(s.getInt(1), s.getString(2), s.getString(3), s.getString(4),s.getDate(5), s.getDate(6),
						s.getDate(7), s.getString(8)));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNH;
	}

	public static NhapHang getANhapHang(int idNhaphang) {
		NhapHang nhaphang = new NhapHang();
		try {
			ps = ConnectDB.getConnect().prepareStatement("select *from nhaphang where idnhaphang=?");
			ps.setInt(1, idNhaphang);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				nhaphang=(new NhapHang(s.getInt(1), s.getString(2), s.getString(3), s.getString(4),s.getDate(5), s.getDate(6),
						s.getDate(7), s.getString(8)));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhaphang;
	}
	
	public static int sumCount() {
		int sumRow= 0;
		try {
			ps = ConnectDB.getConnect().prepareStatement("select count(*)  from nhaphang ");
		
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				sumRow= s.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sumRow;
	}
	
	public static boolean insertNhapHang(NhapHang nh) {
		boolean sucess = true;
		try {
			String sql = "insert into nhaphang values(?,?,?,?,?,?,?)";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setString(1, nh.getTenNguoiGui());
			ps.setString(2, nh.getSdt());
			ps.setString(3, nh.getDiaChi());
			ps.setDate(4, (Date) nh.getNgayNhap());
			ps.setDate(5, (Date) nh.getNgaySua());
			ps.setDate(6, (Date) nh.getNgayTao());
			ps.setString(7, nh.getGhiChu());

			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean updateNhapHang(NhapHang nh) {
		boolean sucess = true;
		try {
			String sql = "update nhaphang set tennguoigui=?, sdtnguoigui=?,diachi=?, ngaynhap=?,ngaysua=?,ghichu=? where idnhaphang=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setInt(7, nh.getIdNhapHang());
			ps.setString(1, nh.getTenNguoiGui());
			ps.setString(2, nh.getSdt());
			ps.setString(3, nh.getDiaChi());
			ps.setDate(4, (Date) nh.getNgayNhap());
			ps.setDate(5, (Date) nh.getNgaySua());
			ps.setString(6, nh.getGhiChu());

			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean deleteNhapHang(int idnh) {
		boolean sucess = true;
		try {
			String sql = "delete from  nhaphang  where idnhaphang=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idnh);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static ArrayList<ThongKeNhapHang> thongkeNhapHang(String dateStart, String dateEnd) {
		ArrayList<ThongKeNhapHang> listTKNH= new ArrayList<>();
		try {
			String sql="select  nh.TenNguoiGui, nh.SdtNguoiGui,nh.DiaChi,nh.GhiChu,nh.NgayNhap  ,sum(ctnh.TongTien) as tongtien\r\n"
					+ "from NhapHang  nh join CTNhapHang ctnh on nh.idNhapHang= ctnh.idNhapHang join Laptop on ctnh.idLapTop= Laptop.idLapTop join PhuKien on ctnh.idPKien=PhuKien.idPKien  where nh.NgayNhap between '"+dateStart+"' and '"+dateEnd+"'  \r\n"
					+ "group by\r\n"
					+ "nh.TenNguoiGui, nh.SdtNguoiGui,nh.DiaChi,nh.GhiChu,nh.NgayNhap";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listTKNH.add(new ThongKeNhapHang( s.getString(1), s.getString(2),s.getString(3),s.getString(4),s.getString(5),
						s.getInt(6)));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTKNH;
	}
	
public static String [] thongkeNhapHangChart(String last30Days, String now) {
		
		String [] arr = new String[2];
		try {
			
			String sql = "select sum(ctbh.TongTien) as tongtien, NgayNhap from NhapHang  bh join CTNhapHang ctbh on bh.idNhapHang= ctbh.idNhapHang join Laptop on ctbh.idLapTop= Laptop.idLapTop join PhuKien on ctbh.idPKien=PhuKien.idPKien  where bh.NgayNhap between '"+last30Days+"' and '"+now+"'  group by NgayNhap";
			System.out.println(sql);
			ps = ConnectDB.getConnect().prepareStatement(sql);
			
			String valueNgay = "";
			valueNgay += "[";
			String valueTongTien = "";
			valueTongTien += "[";
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				valueNgay += "'" + rs.getString("ngaynhap").split(" ")[0] + "', ";
				valueTongTien += rs.getString("tongtien") + ", ";
				
			}
			try {
				if(valueNgay.equals("[") || valueTongTien.equals("[")) {
					
				}else {
					valueNgay = valueNgay.substring(0, valueNgay.length() - 2);
					valueTongTien = valueTongTien.substring(0, valueTongTien.length() - 2);
				}

				valueNgay += "]";
				valueTongTien += "]";
				arr[0] = valueNgay;
				arr[1] = valueTongTien;
				// Đóng kết nối
			} catch (StringIndexOutOfBoundsException e) {
				
				e.getMessage();
			}
			
			return arr;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {

	}

}
