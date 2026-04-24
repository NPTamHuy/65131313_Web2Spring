package thigk2.nguyenphuctamhuy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.nguyenphuctamhuy.models.User;
import thigk2.nguyenphuctamhuy.repos.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User verifyLogin(String tenDangNhap, String matKhau) {
        User user = userRepository.findByTenDangNhap(tenDangNhap);
        if (user != null && user.getMatKhau().equals(matKhau)) {
            return user;
        }
        return null;
    }
}