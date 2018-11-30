package com.lhf.spring.demo2.service.impl;

import com.lhf.spring.demo2.dao.AccountDao;
import com.lhf.spring.demo2.service.AccountService;

/**
 * 转账实现类
 * @author lhf
 *
 */
public class AccountServiceImpl implements AccountService{
	
	//注入转账的Dao类
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	/**
	 * 转账
	 */
	@Override
	public void transfer(String out, String in, Double money) {
		accountDao.outMoney(out, money);  //转出
		//int d = 10/0;
		accountDao.inMoney(in, money);  //转入
		
	}

}
