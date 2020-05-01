package com.amit.cache;

import java.lang.ref.SoftReference;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Cache<K, V> implements Delayed {
    
	private final K key;
    private final SoftReference<V> reference;
    private final long expiryTime;

    public Cache(K key, SoftReference<V> reference, long expiryTime) {
        this.key = key;
        this.reference = reference;
        this.expiryTime = expiryTime;
    }

    public K getKey() {
        return key;
    }

    public SoftReference<V> getReference() {
        return reference;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(expiryTime, ((Cache<?, ?>) o).expiryTime);
    }
}
