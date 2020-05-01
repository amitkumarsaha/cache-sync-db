package com.amit.cache;

import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class InMemoryCache<K, V> implements ICache<K, V>  {
	
    private final ConcurrentHashMap<K, SoftReference<V>> cache = new ConcurrentHashMap<>();
    private final DelayQueue<Cache<K, V>> cleaningUpQueue = new DelayQueue<>();

    public InMemoryCache() {
        Thread cleanerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                	Cache<K, V> delayedCacheObject = cleaningUpQueue.take();
                    cache.remove(delayedCacheObject.getKey(), delayedCacheObject.getReference());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        cleanerThread.setDaemon(true);
        cleanerThread.start();
    }

    @Override
    public void add(K key, V value, long periodInMillis) {
        if (key == null) {
            return;
        }
        if (value == null) {
            cache.remove(key);
        } else {
            long expiryTime = System.currentTimeMillis() + periodInMillis;
            SoftReference<V> reference = new SoftReference<>(value);
            cache.put(key, reference);
            cleaningUpQueue.put(new Cache<K, V>(key, reference, expiryTime));
        }
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }

    @Override
    public V get(K key) {
        return Optional.ofNullable(cache.get(key)).map(SoftReference::get).orElse(null);
    }
    
    @Override
    public List<V> getAll() {
    	
    	return  cache.entrySet().stream()
					.map(Entry::getValue)
					.map(SoftReference::get)
					.collect(Collectors.toList());
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public long size() {
        return cache.size();
    }

}
