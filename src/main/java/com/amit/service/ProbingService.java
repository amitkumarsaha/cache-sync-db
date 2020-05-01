package com.amit.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.amit.cache.ICache;
import com.amit.model.CacheOffset;
import com.amit.model.User;
import com.amit.model.UserCacheLog;
import com.amit.repository.UserCacheLogRepo;
import com.amit.repository.UserCacheOffsetRepo;

@Service
public class ProbingService {
	
	@Autowired
    private ICache<String, User> cache;
	
	@Autowired
	private UserCacheLogRepo userCacheLogRepo;
	
	@Autowired
	private UserCacheOffsetRepo userCacheOffsetRepo;
	
	@Autowired
	private InstanceRegistrationService insatanceMgr;
	
    @Scheduled(fixedRate = 10000L)
    public void probeChanges(){
    	List<UserCacheLog<String, User>> userCacheLogs = null;
    	CacheOffset<String, User> cacheOffsetUser =userCacheOffsetRepo.findByInstanceId(insatanceMgr.getInstanceId());
    	if(null!=cacheOffsetUser) {
    		if(null != cacheOffsetUser.getCacheLog()) {
	    		userCacheLogs = userCacheLogRepo.findAllByCacheLogIdGreaterThan(cacheOffsetUser.getCacheLog().getCacheLogId());
    		}
    		else {
    			userCacheLogs = userCacheLogRepo.findAll();
    			UserCacheLog<String, User> cacheLog = userCacheLogs.stream()
//    					.map(userCacheLog -> userCacheLog.getCacheLogId())
    					.max(Comparator.comparingLong(UserCacheLog::getCacheLogId)).get();
    			cacheOffsetUser.setCacheLog(cacheLog);
    		}
    		userCacheLogs.stream().map(userCacheLog -> userCacheLog.getUser()).filter(user -> null!=user.getUserId())
    		.forEach(user -> cache.add(Long.toString(user.getUserId()), user));
    	}
    	
    	cache.getAll().forEach(cache -> {
    		System.out.println(cache.getUserId() + ", " + cache.getUserName() + ", " + cache.getRole());
    	});
    }

}
