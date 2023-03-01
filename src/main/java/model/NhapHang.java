package model;

import java.util.Date;

public class NhapHang {
	private int idNhapHang;
	private String tenNguoiGui,sdt, diaChi;
	private Date ngayNhap,ngaySua,ngayTao;
	private String ghiChu;
	
	public int getIdNhapHang() {
		return idNhapHang;
	}
	public void setIdNhapHang(int idNhapHang) {
		this.idNhapHang = idNhapHang;
	}
	public String getTenNguoiGui() {
		return tenNguoiGui;
	}
	public void setTenNguoiGui(String tenNguoiGui) {
		this.tenNguoiGui = tenNguoiGui;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public Date getNgaySua() {
		return ngaySua;
	}
	public void setNgaySua(Date ngaySua) {
		this.ngaySua = ngaySua;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
	this.ngayTao = ngayTao;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	@Override
	public String toString() {
		return "NhapHang [idNhapHang=" + idNhapHang + ", tenNguoiGui=" + tenNguoiGui + ", sdt=" + sdt + ", diaChi="
				+ diaChi + ", ngayNhap=" + ngayNhap + ", ngaySua=" + ngaySua + ", NgayTao=" + ngayTao + ", ghiChu="
				+ ghiChu + "]";
	}
	public NhapHang(int idNhapHang, String tenNguoiGui, String sdt,String diaChi ,Date ngayNhap, Date ngaySua, Date ngayTao,
			String ghiChu) {

		this.idNhapHang = idNhapHang;
		this.tenNguoiGui = tenNguoiGui;
		this.sdt = sdt;
		this.ngayNhap = ngayNhap;
		this.ngaySua = ngaySua;
		this.ngayTao = ngayTao;
		this.ghiChu = ghiChu;
		this.diaChi= diaChi;
	}
	public NhapHang() {
		
	}
	public NhapHang(String tenNguoiGui, String sdt,String diaChi, Date ngayNhap, Date ngaySua, Date ngayTao, String ghiChu) {
		
		this.tenNguoiGui = tenNguoiGui;
		this.sdt = sdt;
		this.ngayNhap = ngayNhap;
		this.ngaySua = ngaySua;
		this.ngayTao = ngayTao;
		this.ghiChu = ghiChu;
		this.diaChi= diaChi;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	

}
