package com.project.TimeSheet.TimeProject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.TimeSheet.TimeProject.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Boolean existsByEmail(String email);
	Optional<User> findByEmail(String email);

	long count();

	@Query(value = "SELECT count(users.id) FROM users, user_roles, roles where users.id = user_roles.user_id and roles.id = 1 and user_roles.role_id = roles.id"
	, nativeQuery = true
	)
	public Long countConsultant();

	@Query(value = "SELECT count(users.id) FROM users, user_roles, roles where users.id = user_roles.user_id and roles.id = 3 and user_roles.role_id = roles.id"
	, nativeQuery = true
	)
	public Long countClients();

}
