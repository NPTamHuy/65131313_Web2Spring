package thigk2.nguyenphuctamhuy.models;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "loaitintuc")
public class LoaiTinTuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loai")
    private Integer idLoai;

    @Column(name = "ten_the_loai", nullable = false, length = 100)
    private String tenTheLoai;

    @JsonIgnore
    @OneToMany(mappedBy = "loaiTinTuc", cascade = CascadeType.ALL)
    private List<TinTuc> danhSachTinTuc;

    public LoaiTinTuc() {}

    public LoaiTinTuc(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

	public Integer getIdLoai() {
		return idLoai;
	}

	public void setIdLoai(Integer idLoai) {
		this.idLoai = idLoai;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public List<TinTuc> getDanhSachTinTuc() {
		return danhSachTinTuc;
	}

	public void setDanhSachTinTuc(List<TinTuc> danhSachTinTuc) {
		this.danhSachTinTuc = danhSachTinTuc;
	}
    
}
