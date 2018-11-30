package com.lhf.spring.demo1.dao;

/**
 * 转账案例的DAO层接口
 * @author lhf
 *
 */
public interface AccountDao {
	
	/**
	 * 转出
	 * @param out  转出账号
	 * @param money  转出金额
	 */
	public void outMoney(String out, Double money);
	
	/**
	 * 转入
	 * @param in  转入账户
	 * @param money 转入金额
	 */
	public void inMoney(String in, Double money);

}
