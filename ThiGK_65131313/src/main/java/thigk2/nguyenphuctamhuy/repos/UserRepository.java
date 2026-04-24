package thigk2.nguyenphuctamhuy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thigk2.nguyenphuctamhuy.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByTenDangNhap(String tenDangNhap);
}