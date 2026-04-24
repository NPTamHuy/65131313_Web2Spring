package thigk2.nguyenphuctamhuy.ontap3.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thigk2.nguyenphuctamhuy.ontap3.models.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
}