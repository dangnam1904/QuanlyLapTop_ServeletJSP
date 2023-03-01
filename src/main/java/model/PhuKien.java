package model;

import java.util.Date;

public class PhuKien {
	private int idPhuKien;
	private String tenPK;
	private int soLuong, giaBan,giaNhap;
	private Date ngayTao, ngaySua;
	private String anh;
	public int getIdPhuKien() {
		return idPhuKien;
	}
	public void setIdPhuKien(int idPhuKien) {
		this.idPhuKien = idPhuKien;
	}
	public String getTenPK() {
		return tenPK;
	}
	public void setTenPK(String tenPK) {
		this.tenPK = tenPK;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	public int getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(int giaNhap) {
		this.giaNhap = giaNhap;
	}
	
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public Date getNgaySua() {
		return ngaySua;
	}
	public void setNgaySua(Date ngaySua) {
		this.ngaySua = ngaySua;
	}
	@Override
	public String toString() {
		return "PhuKien [idPhuKien=" + idPhuKien + ", tenPK=" + tenPK + ", soLuong=" + soLuong + ", giaBan=" + giaBan
				+ ", giaNhap=" + giaNhap + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", anh=" + anh + "]";
	}
	
	public PhuKien(int idPhuKien, String tenPK, int soLuong, int giaBan, int giaNhap, Date ngayTao, Date ngaySua,
			String anh) {
		
		this.idPhuKien = idPhuKien;
		this.tenPK = tenPK;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.giaNhap = giaNhap;
		this.ngayTao = ngayTao;
		this.ngaySua = ngaySua;
		this.anh = anh;
	}
	public PhuKien(String tenPK, int soLuong, int giaBan, int giaNhap, Date ngayTao, Date ngaySua, String anh) {
		
		this.tenPK = tenPK;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.giaNhap = giaNhap;
		this.ngayTao = ngayTao;
		this.ngaySua = ngaySua;
		this.anh = anh;
	}
	public PhuKien() {
		
	}
	
}
