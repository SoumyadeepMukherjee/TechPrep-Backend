package com.examportal.examserver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.examserver.entity.UserScores;

@Repository
public interface UserScoreRepository extends JpaRepository<UserScores,Integer> {

}
