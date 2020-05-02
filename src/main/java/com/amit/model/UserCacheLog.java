package com.amit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	private Long cacheLogId;
	
	@Column(name = "user_id", insertable = false, updatable = false, nullable = false)
	private Long userId;
	
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(targetEntity = CacheOffset.class)
	@JoinColumn(name = "cache_offset_id", insertable = false, updatable = false)
	private List<CacheOffset<K, V>> cacheOffset;
	
}
