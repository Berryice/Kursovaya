package com.example.demo.Repositoryes;

import com.example.demo.Tables.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
