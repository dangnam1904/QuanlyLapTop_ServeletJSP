package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ChitietBanHang;
import model.HoaDonFullBanHang;

public class ChiTietBanHangDAO {
	public static PreparedStatement ps;

	public static ArrayList<ChitietBanHang> getAllCTBH(String sql) {
		ArrayList<ChitietBanHang> listCTBH = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listCTBH.add(new ChitietBanHang(s.getInt(1),s.getInt(2),s.getInt(3),s.getInt(4),
						s.getInt(5),s.getInt(6),s.getInt(7),s.getInt(8),s.getInt(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCTBH;
	}
	
	public static ChitietBanHang getACTBH(int idctbh) {
		ChitietBanHang ctbh = null;
		try {
			ps = ConnectDB.getConnect().prepareStatement("select * from ctbanhang where idctbh=?");
			ps.setInt(1, idctbh);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				ctbh=(new ChitietBanHang(s.getInt(1),s.getInt(2),s.getInt(3),s.getInt(4),
						s.getInt(5),s.getInt(6),s.getInt(7),s.getInt(8),s.getInt(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ctbh;
	}
	
	public static ArrayList<ChitietBanHang> getAllCTBHByIDBH(int idbanhang) {
		ArrayList<ChitietBanHang> listCTBH = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement("select *from ctbanhang where idbh=?");
			ps.setInt(1, idbanhang);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listCTBH.add(new ChitietBanHang(s.getInt(1),s.getInt(2),s.getInt(3),s.getInt(4),
						s.getInt(5),s.getInt(6),s.getInt(7),s.getInt(8),s.getInt(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCTBH;
	}
	
	public static ArrayList<HoaDonFullBanHang> getAllFullHoaDonBanHang(int idbanhang) {
		ArrayList<HoaDonFullBanHang> listBH = new ArrayList<>();
		String sql="select idCTBH, ctbh.idLapTop, Laptop.TenLapTop, ctbh.SoLuongLaptop, ctbh.gialaptop, ctbh.idPKien, PhuKien.TenPhuKien,ctbh.SoLuongPK,ctbh.giaphukien , ctbh.TongTien, ctbh.idBH\r\n"
				+ "from BanHang  bh join CTBanHang ctbh on bh.idBH= ctbh.idBH join Laptop on ctbh.idLapTop= Laptop.idLapTop join PhuKien on ctbh.idPKien=PhuKien.idPKien where ctbh.idBH=?";
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idbanhang);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				listBH.add(new HoaDonFullBanHang(s.getInt(1), s.getInt(2), s.getString(3), s.getInt(4), s.getInt(5),s.getInt(6),  s.getString(7),
						s.getInt(8), s.getInt(9),s.getInt(10), s.getInt(11)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBH;
	}


	public static boolean insertCTBH(ChitietBanHang ctbh) {
		boolean sucess = true;
		try {
			String sql = "insert into ctbanhang values(?,?,?,?,?,?,?,?)";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setInt(1, ctbh.getIdLapTop());
			ps.setInt(2, ctbh.getSoLuongLaptop());
			ps.setInt(3, ctbh.getGiaLaptop());
			ps.setInt(4, ctbh.getIdPK());
			ps.setInt(5, ctbh.getSoLuongPhuKien());
			ps.setInt(6, ctbh.getGiaPhuKien());
			ps.setInt(7, ctbh.getTongtien());
			ps.setInt(8, ctbh.getIdBH());
			
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean updateCTBH(ChitietBanHang ctbh) {
		boolean sucess = true;
		try {
			String sql = "update ctbanhang set idlaptop=?, soluonglaptop=?,gialaptop=?,"
					+ "idPkien=?, soluongpk=?, giaphukien=?, tongtien=?, idbh=? where idctbh=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);

			ps.setInt(1, ctbh.getIdLapTop());
			ps.setInt(2, ctbh.getSoLuongLaptop());
			ps.setInt(3, ctbh.getGiaLaptop());
			ps.setInt(4, ctbh.getIdPK());
			ps.setInt(5, ctbh.getSoLuongPhuKien());
			ps.setInt(6, ctbh.getGiaPhuKien());
			ps.setInt(7, ctbh.getTongtien());
			ps.setInt(8, ctbh.getIdBH());
			ps.setInt(9, ctbh.getIdCTBH());
			
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static boolean deleteCTBH(int idctbh) {
		boolean sucess = true;
		try {
			String sql = "delete from  ctbanhang  where idctbh=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idctbh);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}
	
	public static boolean deleteCTBHByIDBH(int idbh) {
		boolean sucess = true;
		try {
			String sql = "delete from  ctbanhang  where idbh=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setInt(1, idbh);
			ps.execute();
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		return sucess;
	}

	public static void main(String[] args) {

		
	}
}
