package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
