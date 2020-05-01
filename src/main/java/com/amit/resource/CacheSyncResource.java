package com.amit.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.model.User;
import com.amit.service.CacheSyncService;


@RestController
public class CacheSyncResource {
	
	@Autowired
	private CacheSyncService cacheSyncService;
	
	@PostMapping(path = "/cache-sync", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addCache(@RequestBody @Valid User user) {
		return cacheSyncService.addCache(user);
	}
	
	@GetMapping(path = "/cache-sync", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getCache() {
		return cacheSyncService.getCache();
	}

}
