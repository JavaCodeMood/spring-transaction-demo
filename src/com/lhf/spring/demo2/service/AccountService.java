package com.lhf.spring.demo2.service;

/**
 * 转账案例的业务层接口
 * @author lhf
 *
 */
public interface AccountService {
	
	/**
	 * 转账接口
	 * @param out  转出账户
	 * @param in   转入账号
	 * @param money  转账金额
	 */
	public void transfer(String out, String in, Double money);

}
