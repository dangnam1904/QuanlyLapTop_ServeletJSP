package model;

public class ThongKeNhapHang {
	private String tenNguoiGui, sdtNguoiGui,diaChi,ghiChu,ngayNhap ;
	private int tongTien;
	@Override
	public String toString() {
		return "ThongKeNhapHang [tenNguoiGui=" + tenNguoiGui + ", sdtNguoiGui=" + sdtNguoiGui + ", diaChi=" + diaChi
				+ ", ghiChu=" + ghiChu + ", ngayNhap=" + ngayNhap + ", TongTien=" + tongTien + "]";
	}
	public ThongKeNhapHang(String tenNguoiGui, String sdtNguoiGui, String diaChi, String ghiChu, String ngayNhap,
			int tongTien) {
		
		this.tenNguoiGui = tenNguoiGui;
		this.sdtNguoiGui = sdtNguoiGui;
		this.diaChi = diaChi;
		this.ghiChu = ghiChu;
		this.ngayNhap = ngayNhap;
		this.tongTien = tongTien;
	}
	public String getTenNguoiGui() {
		return tenNguoiGui;
	}
	public void setTenNguoiGui(String tenNguoiGui) {
		this.tenNguoiGui = tenNguoiGui;
	}
	public String getSdtNguoiGui() {
		return sdtNguoiGui;
	}
	public void setSdtNguoiGui(String sdtNguoiGui) {
		this.sdtNguoiGui = sdtNguoiGui;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public ThongKeNhapHang() {
		super();
	}
	

}
