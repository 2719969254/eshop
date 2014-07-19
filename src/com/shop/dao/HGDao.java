package com.shop.dao;

import java.util.List;

import com.shop.domain.Goods;

public interface HGDao {
	/**
	 * ������Ʒ����������Ʒ
	 * @param type
	 * @return
	 */
	public abstract List<Goods> selectGoodsByType(int type);
	
	/**
	 * ������Ʒ���������Ʒ
	 * @param goodsCode
	 * @return
	 */
	public abstract Goods selectGoodsByCode(String goodsCode);
	/**
	 * ģ����ѯ
	 * @param search
	 * @return
	 */
	
	public abstract List<Goods> selectGoods(String search);
}
