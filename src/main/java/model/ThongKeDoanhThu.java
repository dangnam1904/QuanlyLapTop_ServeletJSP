package model;

public class ThongKeDoanhThu {
	private String tenNguoiMua, sdtNguoiMua, dChi, ghiChu, ngayBan ;
	private int tongTien;
	@Override
	public String toString() {
		return "ThongKeDoanhThu [tenNguoiMua=" + tenNguoiMua + ", sdtNguoiMua=" + sdtNguoiMua + ", dChi=" + dChi
				+ ", ghiChu=" + ghiChu + ", ngayBan=" + ngayBan + ",  tongTien=" + tongTien + "]";
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
	public String getdChi() {
		return dChi;
	}
	public void setdChi(String dChi) {
		this.dChi = dChi;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getNgayBan() {
		return ngayBan;
	}
	public void setNgayBan(String ngayBan) {
		this.ngayBan = ngayBan;
	}

	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public ThongKeDoanhThu(String tenNguoiMua, String sdtNguoiMua, String dChi, String ghiChu, String ngayBan,
			int tongTien) {
		
		this.tenNguoiMua = tenNguoiMua;
		this.sdtNguoiMua = sdtNguoiMua;
		this.dChi = dChi;
		this.ghiChu = ghiChu;
		this.ngayBan = ngayBan;
		
		this.tongTien = tongTien;
	}
	public ThongKeDoanhThu() {
		
	}
	

}
