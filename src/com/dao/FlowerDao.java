package com.dao;

import java.util.List;

import com.pojo.Flower;

public interface FlowerDao {
	/**
	 * ��ѯȫ��
	 * @return
	 */
	List<Flower> selAll();
	
	/**
	 * ����
	 * @param flower
	 * @return
	 */
	int insFlower(Flower flower);
}
