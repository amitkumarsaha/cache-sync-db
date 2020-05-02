package com.amit.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.amit.model.CacheOffset;
import com.amit.model.User;
import com.amit.repository.UserCacheOffsetRepo;

import lombok.Getter;

@Service
public class InstanceRegistrationService{

	@Getter
	public String instanceId;
	
	private CacheOffset<String, User> cacheOffset;
	
	@Autowired
	private UserCacheOffsetRepo userCacheOffsetRepo;

	@EventListener
    public void handleContextRefreshed(ContextRefreshedEvent contextRefreshed) {
        UUID uuid = UUID.randomUUID();
        this.instanceId = uuid.toString();
        
        cacheOffset = new CacheOffset<>();
        cacheOffset.setInstanceId(instanceId);
        userCacheOffsetRepo.save(cacheOffset);
    }
}
