package com.amit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CacheOffset<K, V> implements Serializable{
	
	private static final long serialVersionUID = -4077134568329697940L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cache_offset_id")
	private long cacheOffsetId;
	
	@Column(unique = true)
	private String instanceId;
	
	@Column(name = "cache_log_id", nullable = true)
	private long cacheLogId;
	
	@ManyToOne(targetEntity = UserCacheLog.class, optional = true)
	@JoinColumn(name = "cache_log_id", insertable = false, updatable = false)
	private UserCacheLog<K, V> cacheLog;
	
	

}
