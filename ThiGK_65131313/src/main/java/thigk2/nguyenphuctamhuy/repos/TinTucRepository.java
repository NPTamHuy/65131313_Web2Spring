package thigk2.nguyenphuctamhuy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thigk2.nguyenphuctamhuy.models.TinTuc;
import java.util.List;

@Repository
public interface TinTucRepository extends JpaRepository<TinTuc, Integer> {
    List<TinTuc> findByLoaiTinTuc_IdLoai(Integer idLoai);
}