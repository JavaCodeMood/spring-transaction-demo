package com.lhf.spring.demo1.dao;

/**
 * ת�˰�����DAO��ӿ�
 * @author lhf
 *
 */
public interface AccountDao {
	
	/**
	 * ת��
	 * @param out  ת���˺�
	 * @param money  ת�����
	 */
	public void outMoney(String out, Double money);
	
	/**
	 * ת��
	 * @param in  ת���˻�
	 * @param money ת����
	 */
	public void inMoney(String in, Double money);

}
