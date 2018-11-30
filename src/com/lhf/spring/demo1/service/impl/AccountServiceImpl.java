package com.lhf.spring.demo1.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lhf.spring.demo1.dao.AccountDao;
import com.lhf.spring.demo1.service.AccountService;

/**
 * 转账实现类
 * @author lhf
 *
 */
public class AccountServiceImpl implements AccountService{
	
	//注入转账的Dao类
	private AccountDao accountDao;
	
	//注入事务管理的模板
	private TransactionTemplate transactionTemplate;


	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}



	/**
	 * 转账
	 */
	@Override
	public void transfer(final String out, final String in, final Double money) {
		//accountDao.outMoney(out, money);  //转出
		//accountDao.inMoney(in, money);  //转入
		
		//开启事务
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				accountDao.outMoney(out, money);
				//int i = 1/0;
				accountDao.inMoney(in, money);
			}

		});
	}

}
