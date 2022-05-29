package com.atguigu.admin;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	UserMapper userMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisConnectionFactory redisConnectionFactory;

	@Test
	void contextLoads() {
//		Object o = jdbcTemplate.queryForObject("select * from student");
//		jdbcTemplate.queryForList("select * from student");
		Long aLong = jdbcTemplate.queryForObject("select count(*) from student", Long.class);
		log.info("记录总数：{}",aLong);

		log.info("数据类型：{}",dataSource.getClass());
	}

	@Test
	public void testUserMapper(){
		User user = userMapper.selectById(1L);
		log.info("用户信息：{}",user);
	}

	@Test
	public void testRedis(){
		ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
		operations.set("hello","world");
		String hello = operations.get("hello");
		System.out.println("hello = " + hello);
		System.out.println(redisConnectionFactory.getClass());
	}

}
