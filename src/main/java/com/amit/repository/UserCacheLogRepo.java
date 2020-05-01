package com.amit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.model.UserCacheLog;
import com.amit.model.User;

public interface UserCacheLogRepo extends JpaRepository<UserCacheLog<String, User>, Long>{
	
	List<UserCacheLog<String, User>> findAllByCacheLogIdGreaterThan(long cacheLogId);
	
}