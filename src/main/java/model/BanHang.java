package model;

import java.util.Date;

public class BanHang {
	
	private int idBH;
	private String tenNguoiMua,sdtNguoiMua, diaChi;
	private Date ngayBan,NgaySua,ngayTao;
	private String ghiChu;
	@Override
	public String toString() {
		return "BanHang [idBH=" + idBH + ", tenNguoiMua=" + tenNguoiMua + ", sdtNguoiMua=" + sdtNguoiMua + ", diaChi="
				+ diaChi + ", ngayBan=" + ngayBan + ", NgaySua=" + NgaySua + ", ngayTao=" + ngayTao + ", ghiChu="
				+ ghiChu + "]";
	}
	public int getIdBH() {
		return idBH;
	}
	public void setIdBH(int idBH) {
		this.idBH = idBH;
	}
	public String getTenNguoiMua() {
		return tenNguoiMua;
	}
	public void setTenNguoiMua(String tenNguoiMua) {
		this.tenNguoiMua = tenNguoiMua;
	}
	public String getSdtNguoiMua() {
		return sdtNguoiMua;
	}
	public void setSdtNguoiMua(String sdtNguoiMua) {
		this.sdtNguoiMua = sdtNguoiMua;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgayBan() {
		return ngayBan;
	}
	public void setNgayBan(Date ngayBan) {
		this.ngayBan = ngayBan;
	}
	public Date getNgaySua() {
		return NgaySua;
	}
	public void setNgaySua(Date ngaySua) {
		NgaySua = ngaySua;
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
	public BanHang(int idBH, String tenNguoiMua, String sdtNguoiMua, String diaChi, Date ngayBan, Date ngaySua,
			Date ngayTao, String ghiChu) {
		
		this.idBH = idBH;
		this.tenNguoiMua = tenNguoiMua;
		this.sdtNguoiMua = sdtNguoiMua;
		this.diaChi = diaChi;
		this.ngayBan = ngayBan;
		NgaySua = ngaySua;
		this.ngayTao = ngayTao;
		this.ghiChu = ghiChu;
	}
	public BanHang() {
	
	}
	public BanHang(String tenNguoiMua, String sdtNguoiMua, String diaChi, Date ngayBan, Date ngaySua, Date ngayTao,
			String ghiChu) {
	
		this.tenNguoiMua = tenNguoiMua;
		this.sdtNguoiMua = sdtNguoiMua;
		this.diaChi = diaChi;
		this.ngayBan = ngayBan;
		NgaySua = ngaySua;
		this.ngayTao = ngayTao;
		this.ghiChu = ghiChu;
	}
	
	
	
}
