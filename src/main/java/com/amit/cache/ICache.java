package com.amit.cache;

import java.util.List;

public interface ICache<K, V>{
	
	@Deprecated
    void add(K key, V value, long periodInMillis);
    void add(K key, V value);
    void remove(K key);
    V get(K key);
    void clear();
    long size();
	List<V> getAll();

}