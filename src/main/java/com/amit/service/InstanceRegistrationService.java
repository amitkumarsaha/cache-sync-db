package com.amit.service;

import java.util.UUID;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
public class InstanceRegistrationService{

	@Getter
	public String instanceId;
	
//	private CacheOffset<String, User> cacheOffset;
//	
//	@Autowired
//	private UserCacheOffsetRepo userCacheOffsetRepo;

	@EventListener
    public void handleContextRefreshed(ContextRefreshedEvent contextRefreshed) {
        UUID uuid = UUID.randomUUID();
        this.instanceId = uuid.toString();
        
//        cacheOffset.setInstanceId(instanceId);
//        cacheOffset.set
//        userCacheOffsetRepo.save(entity)
    }
}
