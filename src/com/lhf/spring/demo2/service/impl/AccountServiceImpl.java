package com.lhf.spring.demo2.service.impl;

import com.lhf.spring.demo2.dao.AccountDao;
import com.lhf.spring.demo2.service.AccountService;

/**
 * ת��ʵ����
 * @author lhf
 *
 */
public class AccountServiceImpl implements AccountService{
	
	//ע��ת�˵�Dao��
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	/**
	 * ת��
	 */
	@Override
	public void transfer(String out, String in, Double money) {
		accountDao.outMoney(out, money);  //ת��
		//int d = 10/0;
		accountDao.inMoney(in, money);  //ת��
		
	}

}
