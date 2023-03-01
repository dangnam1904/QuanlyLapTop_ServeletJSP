package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ChitietNhapHang;
import model.HoaDonFullNhapHang;

public class ChitietNhapHangDAO {
	public static PreparedStatement ps;

	public static ArrayList<ChitietNhapHang> getAllCTNH(String sql) {
		ArrayList<ChitietNhapHang> listCTNH = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listCTNH.add(new ChitietNhapHang(s.getInt(1),s.getInt(2),s.getInt(3),s.getInt(4),
						s.getInt(5),s.getInt(6),s.getInt(7),s.getInt(8),s.getInt(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCTNH;
	}
	
	public static ChitietNhapHang getACTNH(int idctnh) {
		ChitietNhapHang ctnh = new ChitietNhapHang();
		try {
			ps = ConnectDB.getConnect().prepareStatement("select * from ctnhaphang where idctnh=?");
			ps.setInt(1, idctnh);
			ResultSet s = ps.executeQuery();
			
			while (s.next()) {
				ctnh=(new ChitietNhapHang(s.getInt(1),s.getInt(2),s.getInt(3),s.getInt(4),
						s.getInt(5),s.getInt(6),s.getInt(7),s.getInt(8),s.getInt(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ctnh;
	}

	public static boolean insertCTNH(ChitietNhapHang ctnh) {
		boolean sucess = true;
		try {
		
			String sql = "insert into ctnhaphang values(?,?,?,?,?,?,?,?)";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setInt(1, ctnh.getIdLapTop());
			ps.setInt(2, ctnh.getSoLuongLaptop());
			ps.setInt(3, ctnh.getGiaLaptop());
			
			ps.setInt(4, ctnh.getIdPK());
			ps.setInt(5, ctnh.getSoLuongPhuKien());
			ps.setInt(6, ctnh.getGiaPhuKien());
			
			ps.setInt(7, ctnh.getTongtien());
			ps.setInt(8, ctnh.getIdNhapHang());
			
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean updateCTNH(ChitietNhapHang ctnh) {
		boolean sucess = true;
		try {
			String sql = "update ctnhaphang set idlaptop=?, soluonglaptop=?,gialaptop=?,"
					+ "idPkien=?, soluongpk=?, giaphukien=? ,tongtien=?, idnhaphang=? where idctnh=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setInt(1, ctnh.getIdLapTop());
			ps.setInt(2, ctnh.getSoLuongLaptop());
			ps.setInt(3, ctnh.getGiaLaptop());
			ps.setInt(4, ctnh.getIdPK());
			ps.setInt(5, ctnh.getSoLuongPhuKien());
			ps.setInt(6, ctnh.getGiaPhuKien());
			ps.setInt(7, ctnh.getTongtien());
			ps.setInt(8, ctnh.getIdNhapHang());
			ps.setInt(9, ctnh.getIdCTNH());
			
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean deleteCTNH(int idCTNH) {
		boolean sucess = true;
		try {
			String sql = "delete from  ctnhaphang  where idctnh=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idCTNH);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean deleteCTNHByIdNhapHang(int idNH) {
		boolean sucess = true;
		try {
			String sql = "delete from  ctnhaphang  where idnhaphang=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idNH);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}
	
	public static ArrayList<HoaDonFullNhapHang> getAllFullHoaDonNhapHang(int idNhapHang) {
		ArrayList<HoaDonFullNhapHang> listNH = new ArrayList<>();
		String sql="select ctnh.idCTNH, ctnh.idLapTop, lt.TenLapTop,  ctnh.SoLuongLaptop,ctnh.GiaLaptop, ctnh.idPKien, pk.TenPhuKien, ctnh.SoLuongPK,ctnh.GiaPhuKien,ctnh.TongTien, ctnh.idNhapHang\r\n"
				+ "from NhapHang nh join CTNhapHang ctnh on ctnh.idNhapHang= nh.idNhapHang join Laptop lt on lt.idLapTop= ctnh.idLapTop join PhuKien pk on pk.idPKien= ctnh.idPKien where ctnh.idNhapHang=?";
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idNhapHang);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listNH.add(new HoaDonFullNhapHang(s.getInt(1), s.getInt(2), s.getString(3), s.getInt(4), s.getInt(5),s.getInt(6),  s.getString(7),
						s.getInt(8), s.getInt(9),s.getInt(10), s.getInt(11)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNH;
	}
	public static void main(String[] args) {

	}

}
