package com.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.tag.common.xml.ForEachTag;
import org.junit.Test;

import com.shop.domain.Goods;
import com.shop.domain.ShoppingCart;
import com.shop.service.HGCartSer;

/**
 * �ṩ�������ɾ�Ĳ鷽��
 * @author csh
 *
 */
public class HGCartSerImpl implements HGCartSer {
	//��ʼ�����ﳵ
	ShoppingCart sc = ShoppingCart.getShoppingCart();
	//��ȡ���ﳵ��������Ʒ
	Map<String, Goods> map = sc.getMap();
	int cartSize=sc.getCartSize();
	double totalPrice = sc.getTotalPrice();

	public ShoppingCart addGoods(Goods goods) {
		//Map<String, Goods> map = sc.getMap();
		
		//�жϹ��ﳵ���Ƿ���ڴ���Ʒ
		if(null == map.get(goods.getGoodsCode())){
			//���������,������Ʒ��������Ϊ1
			goods.setGoodsNum(1);
			map.put(goods.getGoodsCode(), goods);
			//���޸ĺ��Map�ύ�����ﳵ
			sc.setMap(map);
		}else{
			//������������1
			int bfnum = map.get(goods.getGoodsCode()).getGoodsNum()+1;
			goods.setGoodsNum(bfnum);
			map.put(goods.getGoodsCode(), goods);
			sc.setMap(map);
		}
		
		//�������ܼ�ֵ������
		cartSize=sc.cartSize();
		totalPrice=sc.totalPrice();
		sc.setCartSize(cartSize);
		sc.setTotalPrice(totalPrice);
		return sc;
	}

	public boolean deleteGoods(String goodsCode) {
		//Map<String, Goods> map = sc.getMap();
		if(!goodsCode.equals("")){
			map.remove(goodsCode);
			sc.setMap(map);
			//�������ܼ�ֵ������
			cartSize=sc.cartSize();
			totalPrice=sc.totalPrice();
			sc.setCartSize(cartSize);
			sc.setTotalPrice(totalPrice);
			return true;
		}else{
			return false;
		}
		
	}

	
}
