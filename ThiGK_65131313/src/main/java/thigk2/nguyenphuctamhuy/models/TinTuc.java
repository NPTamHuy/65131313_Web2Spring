package thigk2.nguyenphuctamhuy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tintuc")
public class TinTuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tin")
    private Integer idTin;

    @Column(name = "tieu_de", nullable = false, length = 255)
    private String tieuDe;

    @Column(name = "tom_tat", columnDefinition = "TEXT")
    private String tomTat;

    @Column(name = "noi_dung_chi_tiet", columnDefinition = "LONGTEXT")
    private String noiDungChiTiet;

    @ManyToOne
    @JoinColumn(name = "id_loai", referencedColumnName = "id_loai")
    private LoaiTinTuc loaiTinTuc;

    public TinTuc() {}

    public TinTuc(String tieuDe, String tomTat, String noiDungChiTiet, LoaiTinTuc loaiTinTuc) {
        this.tieuDe = tieuDe;
        this.tomTat = tomTat;
        this.noiDungChiTiet = noiDungChiTiet;
        this.loaiTinTuc = loaiTinTuc;
    }

	public Integer getIdTin() {
		return idTin;
	}

	public void setIdTin(Integer idTin) {
		this.idTin = idTin;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getTomTat() {
		return tomTat;
	}

	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}

	public String getNoiDungChiTiet() {
		return noiDungChiTiet;
	}

	public void setNoiDungChiTiet(String noiDungChiTiet) {
		this.noiDungChiTiet = noiDungChiTiet;
	}

	public LoaiTinTuc getLoaiTinTuc() {
		return loaiTinTuc;
	}

	public void setLoaiTinTuc(LoaiTinTuc loaiTinTuc) {
		this.loaiTinTuc = loaiTinTuc;
	}
    
}