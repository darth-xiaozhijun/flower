package com.service.impl;

import java.util.List;

import com.dao.FlowerDao;
import com.dao.impl.FlowerDaoImpl;
import com.pojo.Flower;
import com.service.FlowerService;

public class FlowerServiceImpl implements FlowerService {
	private FlowerDao flowerDao = new FlowerDaoImpl();
	@Override
	public List<Flower> show() {
		return flowerDao.selAll();
	}
	@Override
	public int add(Flower flower) {
		return flowerDao.insFlower(flower);
	}

}
