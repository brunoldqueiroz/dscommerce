package com.devsuperior.dscommerce.repositories;

import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.projections.UserDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT u.email AS username, u.password, r.id AS roleId, r.authority" +
                    "FROM tb_user AS u " +
                    "INNER JOIN tb_user_role AS ur ON ur.user_id = u.id " +
                    "INNER JOIN tb_roles AS r ON r.id = ur.role_id " +
                    "WHERE u.email = :email"
    )
    List<UserDetailProjection> searchUserAndRolesByEmail(String email);
}
