package com.lms.common.repository;

import com.lms.common.model.User;
import com.lms.common.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRespository extends JpaRepository<UserRole, Long> {
}
