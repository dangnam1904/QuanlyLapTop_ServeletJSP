package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DichVuSuaChua;

public class DichVuSuaChuaDAO {
	public static PreparedStatement ps;

	public static ArrayList<DichVuSuaChua> getAllDV(String sql) {
		ArrayList<DichVuSuaChua> listDV = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listDV.add(new DichVuSuaChua(rs.getInt("idDV"), rs.getString("TenKH"), rs.getString("sdtkhach"),
						rs.getString("noidung"), rs.getInt("giatien"), rs.getDate("ngaynhan"), rs.getDate("ngaytra"),
						rs.getString("GhiChu")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDV;
	}
	
public static String [] thongkeSuaChuaChart(String last30Days, String now) {
		
		String [] arr = new String[2];
		try {
			
			String sql = "select sum(GiaTien) as tongtien, NgayNhan from dichvusuachua where  ngaynhan between '"+last30Days+"' and '"+now+"'  group by ngaynhan";
			System.out.println(sql);
			ps = ConnectDB.getConnect().prepareStatement(sql);
			
			String valueNgay = "";
			valueNgay += "[";
			String valueTongTien = "";
			valueTongTien += "[";
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				valueNgay += "'" + rs.getString("ngaynhan").split(" ")[0] + "', ";
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
	
	public static ArrayList<DichVuSuaChua> getDVByName(String tenkhachhang) {
		ArrayList<DichVuSuaChua> listDV = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement("select * from dichvusuachua where TenKH like '%"+tenkhachhang.trim()+"%'");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listDV.add(new DichVuSuaChua(rs.getInt("idDV"), rs.getString("TenKH"), rs.getString("sdtkhach"),
						rs.getString("noidung"), rs.getInt("giatien"), rs.getDate("ngaynhan"), rs.getDate("ngaytra"),
						rs.getString("GhiChu")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDV;
	}
	
	public static ArrayList<DichVuSuaChua> thongkeNhapHang(String dateStart, String dateEnd) {
		ArrayList<DichVuSuaChua> listTKNH= new ArrayList<>();
		try {
			String sql="select * from DichVuSuaChua where NgayNhan between '"+dateStart.trim()+"' and '"+dateEnd.trim()+"'";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listTKNH.add(new DichVuSuaChua(s.getInt(1), s.getString(2), s.getString(3), s.getString(4), s.getInt(5), s.getDate(6), s.getDate(7), s.getString(8)));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTKNH;
	}
	public static DichVuSuaChua getADV(int iddv) {
		DichVuSuaChua dV = null;
		try {
			ps = ConnectDB.getConnect().prepareStatement("select * from dichvusuachua where idDV=?");
			ps.setInt(1, iddv);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dV=new DichVuSuaChua(rs.getInt("idDV"), rs.getString("TenKH"), rs.getString("sdtkhach"),
						rs.getString("noidung"), rs.getInt("giatien"), rs.getDate("ngaynhan"), rs.getDate("ngaytra"),
						rs.getString("GhiChu"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dV;
	}

	public static boolean insertDV(DichVuSuaChua dv) {
		boolean sucess = true;
		try {
			String sql = "insert into dichvusuachua values(?,?,?,?,?,?,?)";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setString(1, dv.getTenKhach());
			ps.setString(2, dv.getSdtKhach());
			ps.setString(3, dv.getNoiDungSuaChua());
			ps.setInt(4, dv.getGiaTien());
			ps.setDate(5, (Date) dv.getNgayNhan());
			ps.setDate(6, (Date) dv.getNgayTra());
			ps.setString(7, dv.getGhiChu());

			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean updateDV(DichVuSuaChua dv) {
		boolean sucess = true;
		try {
			String sql = "update dichvusuachua set tenKH=?, sdtkhach=?,noidung=?, giatien=?, ngaynhan=?,"
					+ "ngaytra=?, ghichu=? where idDV=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setString(1, dv.getTenKhach());
			ps.setString(2, dv.getSdtKhach());
			ps.setString(3, dv.getNoiDungSuaChua());
			ps.setInt(4, dv.getGiaTien());
			ps.setDate(5, (Date) dv.getNgayNhan());
			ps.setDate(6, (Date) dv.getNgayTra());
			ps.setString(7, dv.getGhiChu());
			ps.setInt(8, dv.getIdDV());

			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean deleteDV(int idDV) {
		boolean sucess = true;
		try {
			String sql = "delete from  dichvusuachua  where idDV=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idDV);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static void main(String[] args) {

		System.out.println(DichVuSuaChuaDAO.getDVByName("           Kh"));
	}
}
