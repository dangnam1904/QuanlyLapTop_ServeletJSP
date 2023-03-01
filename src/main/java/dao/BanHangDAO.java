package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BanHang;
import model.ThongKeDoanhThu;

public class BanHangDAO {
	public static PreparedStatement ps;

	public static ArrayList<BanHang> getAllBanHang(String sql) {
		ArrayList<BanHang> listBH = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listBH.add(new BanHang(s.getInt("idBH"),s.getString("TenNguoiMua"),s.getString("sdtNguoiMua"),
						s.getString("Dchi"),s.getDate("NgayBan"), s.getDate("ngaysua"), s.getDate("NgayTao"),s.getString("GhiChu")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBH;
	}
	
	public static ArrayList<BanHang> getAlLBanHangByName(String tenkhach) {
		ArrayList<BanHang> listBH = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement("select * from banhang where tennguoimua like '%"+tenkhach.trim()+"%'");
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listBH.add(new BanHang(s.getInt("idBH"),s.getString("TenNguoiMua"),s.getString("sdtNguoiMua"),
						s.getString("Dchi"),s.getDate("NgayBan"), s.getDate("ngaysua"), s.getDate("NgayTao"),s.getString("GhiChu")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBH;
	}
	
	
	
	public static BanHang getAHoaDon(int idBanHang) {
		BanHang bh= null;
		try {
			ps = ConnectDB.getConnect().prepareStatement("select *from banhang where idBH=?");
			ps.setInt(1, idBanHang);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				bh=new BanHang(s.getInt("idBH"),s.getString("TenNguoiMua"),s.getString("sdtNguoiMua"),
						s.getString("Dchi"),s.getDate("NgayBan"), s.getDate("ngaysua"), s.getDate("NgayTao"),s.getString("GhiChu"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bh;
	}

	public static boolean insertBH(BanHang bh) {
		boolean sucess = true;
		try {
			String sql = "insert into banhang values(?,?,?,?,?,?,?)";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setString(1, bh.getTenNguoiMua());
			ps.setString(2, bh.getSdtNguoiMua());
			ps.setString(3, bh.getDiaChi());
			ps.setDate(4, (Date) bh.getNgayBan());
			ps.setDate(5, (Date) bh.getNgaySua());
			ps.setDate(6, (Date) bh.getNgayTao());
			ps.setString(7, bh.getGhiChu());
			
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean updateBH(BanHang bh) {
		boolean sucess = true;
		try {
			String sql = "update banhang set tennguoimua=?, sdtnguoimua=?,dchi=?, ngayban=?,"
					+ "ngaysua=?, ngaytao=?, ghichu=? where idBH=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setString(1, bh.getTenNguoiMua());
			ps.setString(2, bh.getSdtNguoiMua());
			ps.setString(3, bh.getDiaChi());
			ps.setDate(4, (Date) bh.getNgayBan());
			ps.setDate(5, (Date) bh.getNgaySua());
			ps.setDate(6, (Date) bh.getNgayTao());
			ps.setString(7, bh.getGhiChu());
			ps.setInt(8, bh.getIdBH());
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean deleteBH(int idBH) {
		boolean sucess = true;
		try {
			String sql = "delete from  banhang  where idbh=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idBH);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static ArrayList<ThongKeDoanhThu> thongkeDoanhThu(String dateStart, String dateEnd) {
		ArrayList<ThongKeDoanhThu> listTKDT= new ArrayList<>();
		try {
			String sql="select  bh.TenNguoiMua, bh.SdtNguoiMua,bh.DChi, bh.GhiChu, bh.NgayBan ,sum(ctbh.TongTien) as tongtien\r\n"
					+ "from BanHang  bh join CTBanHang ctbh on bh.idBH= ctbh.idBH join Laptop on ctbh.idLapTop= Laptop.idLapTop join PhuKien on ctbh.idPKien=PhuKien.idPKien  where bh.NgayBan between '"+dateStart+"' and '"+dateEnd+"'  \r\n"
					+ "group by\r\n"
					+ "bh.TenNguoiMua, bh.SdtNguoiMua,bh.DChi, bh.GhiChu, bh.NgayBan";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listTKDT.add(new ThongKeDoanhThu( s.getString(1), s.getString(2),s.getString(3),s.getString(4),s.getString(5),
						s.getInt(6)));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTKDT;
	}
	
	public static String [] thongkeDoanhThu30NgayGanNhat(String last30Days, String now) {
		
		String [] arr = new String[2];
		try {
			
			String sql = "select sum(ctbh.TongTien) as tongtien, NgayBan from BanHang  bh join CTBanHang ctbh on bh.idBH= ctbh.idBH join Laptop on ctbh.idLapTop= Laptop.idLapTop"
					+ " join PhuKien on ctbh.idPKien=PhuKien.idPKien  where bh.NgayBan between '"+last30Days+"' and '"+now+"'  group by NgayBan ";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			
			String valueNgay = "";
			valueNgay += "[";
			String valueTongTien = "";
			valueTongTien += "[";
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				valueNgay += "'" + rs.getString("ngayban").split(" ")[0] + "', ";
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
	
	public static int sumCount() {
		int sumRow= 0;
		try {
			ps = ConnectDB.getConnect().prepareStatement("select count(*)   from banhang ");
		
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				sumRow= s.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sumRow;
	}
	public static void main(String[] args) {

		System.out.println(BanHangDAO.thongkeDoanhThu("2000-02-11", "2023-12-01"));
		String[] data=BanHangDAO.thongkeDoanhThu30NgayGanNhat("2000-12-12", "2023-12-12");
		for(int i=0; i<data.length;i++) {
			System.out.println(data[i]);
		}
		System.out.println(BanHangDAO.sumCount());
	}

}
