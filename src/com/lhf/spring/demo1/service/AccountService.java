package com.lhf.spring.demo1.service;

/**
 * ת�˰�����ҵ���ӿ�
 * @author lhf
 *
 */
public interface AccountService {
	
	/**
	 * ת�˽ӿ�
	 * @param out  ת���˻�
	 * @param in   ת���˺�
	 * @param money  ת�˽��
	 */
	public void transfer(String out, String in, Double money);

}
