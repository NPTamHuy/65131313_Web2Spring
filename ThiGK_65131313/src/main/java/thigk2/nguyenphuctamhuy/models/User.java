package thigk2.nguyenphuctamhuy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "nguoidung")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "ten_dang_nhap", unique = true, nullable = false, length = 50)
    private String tenDangNhap;

    @Column(name = "mat_khau", nullable = false)
    private String matKhau;

    @Column(name = "ho_ten")
    private String hoTen;

    public User() {}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
}
