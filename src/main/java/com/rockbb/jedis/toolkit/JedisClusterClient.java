package com.rockbb.jedis.toolkit;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.SetParams;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisClusterClient implements JedisGenericClient {
    private JedisCluster cluster;

    public JedisClusterClient(JedisCluster cluster) {
        this.cluster = cluster;
    }

    @Override
    public Object eval(String script, int keyCount, String... params) {
        return cluster.eval(script, keyCount, params);
    }

    @Override
    public List<String> blpop(int timeout, String key) {
        return cluster.blpop(timeout, key);
    }

    @Override
    public List<String> blpop(int timeout, String... keys) {
        return cluster.blpop(timeout, keys);
    }

    @Override
    public List<byte[]> blpop(int timeout, byte[]... keys) {
        return cluster.blpop(timeout, keys);
    }

    @Override
    public List<String> brpop(int timeout, String key) {
        return cluster.brpop(timeout, key);
    }

    @Override
    public List<String> brpop(int timeout, String... keys) {
        return cluster.brpop(timeout, keys);
    }

    @Override
    public List<byte[]> brpop(int timeout, byte[]... keys) {
        return cluster.brpop(timeout, keys);
    }

    @Override
    public Long del(String key) {
        return cluster.del(key);
    }

    @Override
    public Long del(String... keys) {
        return cluster.del(keys);
    }

    @Override
    public Long exists(String... keys) {
        return cluster.exists(keys);
    }

    @Override
    public Boolean exists(String key) {
        return cluster.exists(key);
    }

    @Override
    public Long expire(byte[] key, int seconds) {
        return cluster.expire(key, seconds);
    }

    @Override
    public String get(String key) {
        return cluster.get(key);
    }

    @Override
    public byte[] get(byte[] key) {
        return cluster.get(key);
    }

    @Override
    public Long hdel(String key, String... fields) {
        return cluster.hdel(key, fields);
    }

    @Override
    public byte[] hget(byte[] key, byte[] field) {
        return cluster.hget(key, field);
    }

    @Override
    public Map<byte[], byte[]> hgetAll(byte[] key) {
        return cluster.hgetAll(key);
    }

    @Override
    public Long hset(byte[] key, byte[] field, byte[] value) {
        return cluster.hset(key, field, value);
    }

    @Override
    public Long llen(String key) {
        return cluster.llen(key);
    }

    @Override
    public Long lpush(String key, String... strings) {
        return cluster.lpush(key, strings);
    }

    @Override
    public Long pttl(String key) {
        return cluster.pttl(key);
    }

    @Override
    public Long rpush(String key, String... strings) {
        return cluster.rpush(key, strings);
    }

    @Override
    public String set(String key, String value) {
        return cluster.set(key, value);
    }

    @Override
    public String set(byte[] key, byte[] value) {
        return cluster.set(key, value);
    }

    @Override
    public String set(String key, String value, SetParams params) {
        return cluster.set(key, value, params);
    }

    @Override
    public String set(byte[] key, byte[] value, SetParams params) {
        return cluster.set(key, value, params);
    }

    @Override
    public Long sadd(String key, String... members) {
        return cluster.sadd(key, members);
    }

    @Override
    public Set<String> smembers(String key) {
        return cluster.smembers(key);
    }

    @Override
    public Boolean sismember(String key, String member) {
        return cluster.sismember(key, member);
    }

    @Override
    public String spop(String key) {
        return cluster.spop(key);
    }

    @Override
    public Long srem(String key, String... members) {
        return cluster.srem(key, members);
    }

    @Override
    public Long ttl(String key) {
        return cluster.ttl(key);
    }

    @Override
    public Long ttl(byte[] key) {
        return cluster.ttl(key);
    }
}
