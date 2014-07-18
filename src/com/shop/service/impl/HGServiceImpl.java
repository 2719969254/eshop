package com.shop.service.impl;

import java.util.List;

import com.shop.dao.HGDao;
import com.shop.dao.impl.HGDaoImpl;
import com.shop.domain.Goods;
import com.shop.service.HGService;

public class HGServiceImpl implements HGService{
	//����Dao��ķ���
	HGDao hgDao = new HGDaoImpl();
	
	public List<Goods> selectGoodsByTypeSer(int type) {
		
		return hgDao.selectGoodsByType(type);
	}

	public Goods selectGoodsByCodeSer(String goodsCode) {
		return hgDao.selectGoodsByCode(goodsCode);
	}

}
