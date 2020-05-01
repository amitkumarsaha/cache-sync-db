package com.amit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.model.CacheOffset;
import com.amit.model.User;

public interface UserCacheOffsetRepo extends JpaRepository<CacheOffset<String, User>, Long>{
	
	CacheOffset<String, User> findByInstanceId(String instanceId);
	
}
