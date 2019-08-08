# Jedis-lock

Jedis-lock is easy to use and simple implementation of distributed lock using Redis database and Jedis driver.

Because the [master branch](https://github.com/abelaska/jedis-lock) is no longer updated, this fork will add following features:

* Use LUA scripts instead of `SETNX` for better atomicity
* ReentrantLock support
* JedisCluster support

## How to use it?

To use it just:

```java
JedisPoolConfig config = new JedisPoolConfig();
JedisPool pool = new JedisPool(config, host, port, 2000, password, database, clientName, false);
JedisLock lock = new JedisLock(pool, "foobar");
```
or
```java
Set<HostAndPort> hostAndPortsSet = new HashSet<HostAndPort>();
hostAndPortsSet.add(new HostAndPort("192.168.1.2", 6379));
hostAndPortsSet.add(new HostAndPort("192.168.1.3", 6379));

JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
jedisPoolConfig.setTestOnBorrow(true);
JedisCluster cluster = new JedisCluster(hostAndPortsSet, jedisPoolConfig);
JedisLock lock = new JedisLock(cluster, "foobar");
```
then
```java
lock.acquire();
try {
  // do some stuff
}
finally {
  lock.release();
}
```
That's it.

## Into production

Please read [Distributed lock with Redis](https://redis.io/topics/distlock) before using it in production. Jedis-lock is
good for single redis server and cluster without replica. Usually redis is very stable in most of the cases, it can run
smoothly for months even years without a problem.
But if you are going to use it in some serious conditions, like a heavily loaded master-slave redis cluster,
it may have the problem of safety violation(Mutual exclusion. At any given moment, only one client can hold a lock).
You should use Redisson which has implemented the Redlock algorithm.


## Disclaimer

This software is provided "as is", without warranty of any kind, express or implied, including but not limited to the
warranties of merchantability, fitness for a particular purpose and noninfringement. In no event shall the authors or
copyright holders be liable for any claim, damages or other liability, whether in an action of contract, tort or
otherwise, arising from, out of or in connection with the software or the use or other dealings in the software.

## License

The Apache Software License, Version 2.0
