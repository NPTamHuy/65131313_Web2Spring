package thigk2.nguyenphuctamhuy.ontap2.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thigk2.nguyenphuctamhuy.ontap2.models.SanPham;

@Repository
public interface SanPhamRepos extends JpaRepository<SanPham, Integer> {
}