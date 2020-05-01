package com.amit.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.cache.ICache;
import com.amit.model.UserCacheLog;
import com.amit.model.User;
import com.amit.repository.UserCacheLogRepo;
import com.amit.repository.UserRepository;

@Service
public class CacheSyncService{
	
	@Autowired
    private ICache<String, User> cache;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserCacheLogRepo userCacheLogRepo;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public User addCache(User user) {
		user = userRepository.save(user);
		cache.add(Long.toString(user.getUserId()), user, 5000L);
		
		
		UserCacheLog<String, User> cacheLog = new UserCacheLog<>();
		cacheLog.setUser(user);
		userCacheLogRepo.save(cacheLog);
		
		System.out.println(cache.getAll());
		return user;
	}

	public List<User> getCache() {
		List<User> users = cache.getAll();
		if(users.isEmpty())
			users = userRepository.findAll();
		return users;
	}

}
