package com.matheus.locadoraCarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.matheus.locadoraCarro.entity.User;

@Repository
public interface IUserRepository  extends JpaRepository<User, Long>{

	@Query(value = "select * from users  where username = :username", nativeQuery = true)
	User findByUsername(@Param("username") String username);
}
