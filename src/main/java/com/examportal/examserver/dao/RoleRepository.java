package com.examportal.examserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.examserver.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
