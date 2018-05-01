package util;

import redis.clients.jedis.Jedis;


public class JEDIS {
	public static Jedis connection() {
		Jedis jedis = new Jedis("localhost",6379);
		return jedis;
	}
	public void close(Jedis jedis) {
		jedis.save();
		jedis.close();
	}


}
