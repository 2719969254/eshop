package com.shop.service;

import java.util.List;

import com.shop.domain.Goods;

public interface HGService {
	/**
	 * ������Ʒ���Ͳ���������Ʒ
	 * @param type  ��Ʒ����
	 * @return
	 */
	public abstract List<Goods> selectGoodsByTypeSer(int type);
	
	/**
	 * ������Ʒ��Ų�����Ʒ
	 * @param goodsCode��Ʒ���
	 * @return
	 */
	public abstract Goods selectGoodsByCodeSer(String goodsCode);
}
