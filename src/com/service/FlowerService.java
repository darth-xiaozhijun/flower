package com.service;

import java.util.List;

import com.pojo.Flower;

public interface FlowerService {
	/**
	 * ��ʾ���л�����Ϣ
	 * @return
	 */
	List<Flower> show();
	
	/**
	 * ����
	 * @param flower
	 * @return
	 */
	int add(Flower flower);
}
