package pers.example.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pers.example.mapper.UserMapper;
import pers.example.service.UserService;
import pers.example.util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-common.xml"})
public class UserTest {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private UserService service;
	
	@Test
	public void test() {
		System.out.println(mapper);
		System.out.println(service);
		Pager pager = new Pager();
		pager = service.search(pager);
		System.out.println(pager.getDatas());
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-common.xml");
		UserMapper mapper = (UserMapper) applicationContext.getBean("userMapper");
		System.out.println(mapper);
	}
}
