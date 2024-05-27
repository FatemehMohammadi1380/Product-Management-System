package edu.webclass.restapi.Product.Management.System.repository;


import edu.webclass.restapi.Product.Management.System.models.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    // بررسی وجود ایمیل در پایگاه داده
    boolean existsByEmail(String email);

    Optional<User> findByName(String name);

    // پیدا کردن کاربر با استفاده از ایمیل
    User findByEmail(String email);

    //Optional<User> findByEmail(String email);


}
