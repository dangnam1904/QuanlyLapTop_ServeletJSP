package model;

public class ChitietBanHang {

	private int idCTBH, idLapTop, soLuongLaptop, giaLaptop;
	private int idPK, soLuongPhuKien, giaPhuKien;
	private int tongtien, idBH;

	public int getGiaLaptop() {
		return giaLaptop;
	}

	public void setGiaLaptop(int giaLaptop) {
		this.giaLaptop = giaLaptop;
	}

	public int getGiaPhuKien() {
		return giaPhuKien;
	}

	public void setGiaPhuKien(int giaPhuKien) {
		this.giaPhuKien = giaPhuKien;
	}

	public int getIdCTBH() {
		return idCTBH;
	}

	public void setIdCTBH(int idCTBH) {
		this.idCTBH = idCTBH;
	}

	public int getIdLapTop() {
		return idLapTop;
	}

	public void setIdLapTop(int idLapTop) {
		this.idLapTop = idLapTop;
	}

	public int getSoLuongLaptop() {
		return soLuongLaptop;
	}

	public void setSoLuongLaptop(int soLuongLaptop) {
		this.soLuongLaptop = soLuongLaptop;
	}

	public int getIdPK() {
		return idPK;
	}

	public void setIdPK(int idPK) {
		this.idPK = idPK;
	}

	public int getSoLuongPhuKien() {
		return soLuongPhuKien;
	}

	public void setSoLuongPhuKien(int soLuongPhuKien) {
		this.soLuongPhuKien = soLuongPhuKien;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	public int getIdBH() {
		return idBH;
	}

	public void setIdBH(int idBH) {
		this.idBH = idBH;
	}

	@Override
	public String toString() {
		return "ChitietBanHang [idCTBH=" + idCTBH + ", idLapTop=" + idLapTop + ", soLuongLaptop=" + soLuongLaptop
				+ ", giaLaptop=" + giaLaptop + ", idPK=" + idPK + ", soLuongPhuKien=" + soLuongPhuKien + ", giaPhuKien="
				+ giaPhuKien + ", tongtien=" + tongtien + ", idBH=" + idBH + "]";
	}

	public ChitietBanHang(int idCTBH, int idLapTop, int soLuongLaptop, int giaLaptop, int idPK, int soLuongPhuKien,
			int giaPhuKien, int tongtien, int idBH) {

		this.idCTBH = idCTBH;
		this.idLapTop = idLapTop;
		this.soLuongLaptop = soLuongLaptop;
		this.giaLaptop = giaLaptop;

		this.idPK = idPK;
		this.soLuongPhuKien = soLuongPhuKien;
		this.giaPhuKien = giaPhuKien;

		this.tongtien = tongtien;
		this.idBH = idBH;
	}

	public ChitietBanHang(int idLapTop, int soLuongLaptop, int giaLaptop, int idPK, int soLuongPhuKien, int giaPhuKien,
			int tongtien, int idBH) {

		this.idLapTop = idLapTop;
		this.soLuongLaptop = soLuongLaptop;
		this.giaLaptop = giaLaptop;

		this.idPK = idPK;
		this.soLuongPhuKien = soLuongPhuKien;
		this.giaPhuKien = giaPhuKien;

		this.tongtien = tongtien;
		this.idBH = idBH;
	}

	public ChitietBanHang() {

	}

}
