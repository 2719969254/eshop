package com.shop.service;

import java.util.List;

import com.shop.domain.Goods;
import com.shop.domain.ShoppingCart;

public interface HGCartSer {
	
	
	/**
	 * �򹺳��������Ʒ
	 * @param list
	 */
	public abstract ShoppingCart addGoods(Goods goods);
	
	/**
	 * ɾ�����ﳵ����Ʒ
	 * @param list
	 */
	public abstract boolean deleteGoods(String goodsCode);
}
