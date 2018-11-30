package com.lhf.spring.demo1.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lhf.spring.demo1.dao.AccountDao;
import com.lhf.spring.demo1.service.AccountService;

/**
 * ת��ʵ����
 * @author lhf
 *
 */
public class AccountServiceImpl implements AccountService{
	
	//ע��ת�˵�Dao��
	private AccountDao accountDao;
	
	//ע����������ģ��
	private TransactionTemplate transactionTemplate;


	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}



	/**
	 * ת��
	 */
	@Override
	public void transfer(final String out, final String in, final Double money) {
		//accountDao.outMoney(out, money);  //ת��
		//accountDao.inMoney(in, money);  //ת��
		
		//��������
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
