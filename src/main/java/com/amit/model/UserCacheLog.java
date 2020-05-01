package com.amit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserCacheLog<K, V> implements Serializable{

	private static final long serialVersionUID = -6714128913570750643L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cache_log_id")
	private long cacheLogId;
	
	@Column(name = "user_id", insertable = false, updatable = false, nullable = false)
	private long userId;
	
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "cache_offset_id")
	private long cacheOffsetId;
	
	@OneToOne(targetEntity = CacheOffset.class, optional = true)
	@JoinColumn(name = "cache_offset_id", referencedColumnName = "cache_offset_id", insertable = false, updatable = false)
	private CacheOffset<K, V> cacheOffset;
	
}
