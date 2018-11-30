package com.lhf.spring.demo4;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring的声明式事务管理的方式三：基于注解的事务管理方式
 * @author lhf
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class TransactionTest {

	/**
	 * 一定要注入代理类:因为代理类进行增强的操作
	 */
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void demo1(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}
