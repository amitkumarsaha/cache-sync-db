package com.amit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.amit.model.CacheOffset;
import com.amit.model.User;
import com.amit.repository.UserCacheLogRepo;
import com.amit.repository.UserCacheOffsetRepo;

@Service
public class ProbingService {
	
	@Autowired
	private UserCacheLogRepo userCacheLogRepo;
	
	@Autowired
	private UserCacheOffsetRepo userCacheOfsetRepo;
	
	@Autowired
	private InstanceRegistrationService insatanceMgr;
	
    @Scheduled(fixedRate = 10000L)
    public void probeChanges(){
    	CacheOffset<String, User> cacheOffsetUser =userCacheOfsetRepo.findByInstanceId(insatanceMgr.getInstanceId());
    	if(null!=cacheOffsetUser)
    		userCacheLogRepo.findAllByCacheLogIdGreaterThan(cacheOffsetUser.getCacheLog().getCacheLogId());
    }

}
