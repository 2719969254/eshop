package com.shop.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ���ﳵ��װ��
 * 1,List<Goods>  �������ﳵ�����е���Ʒ
 * 2��double totalPrice ���ﳵ����Ʒ�ܼ�ֵ
 * 3��int cartSize ���ﳵ����Ʒ����
 * 4��boolean deleteGoods(String goodsCode)ɾ����Ʒ
 * 5,�޸���Ʒ�������������Ӻͼ���
 * 6,��չ��ﳵdeleteAll
 * @author csh
 *
 */
public class ShoppingCart {
	private Map<String,Goods> map = new HashMap<String,Goods>();
	private double totalPrice=0;
	private int cartSize=0;
	
	/**
	 * ���㹺�ﳵ����Ʒ�����ͼ۸�����
	
	{
		if(map.size()>0){
			List<Goods> list = (List<Goods>)map.values();
		
			for (Goods goods : list) {
				cartSize +=goods.getGoodsNum();
			}
			
			for (Goods goods2 : list) {
				totalPrice +=goods2.getGoodsPrice()*goods2.getGoodsNum();
			}
		}
		
	} 
	*/
	
	/**
	 * ����ģ�ͣ�����ʽ
	 * 
	 */
	private static ShoppingCart shoppingCart = new ShoppingCart();
	
	private ShoppingCart(){}
	
	public static ShoppingCart getShoppingCart(){
		return shoppingCart;
	}
	/**
	 * �����ܼ�ֵ
	 */
	public double totalPrice(){
		Collection<Goods> values = map.values();
		double num2=0;
		for (Goods goods2 : values) {
			num2 +=goods2.getGoodsPrice()*goods2.getGoodsNum();
		}
		return num2;
	}
	/**
	 * ����������Ʒ����
	 */
	public int cartSize(){
		 Collection<Goods> values = map.values();
			int num =0;
			for (Goods goods : values) {
				num +=goods.getGoodsNum();
			}
			return num;
	}
	
	public Map<String, Goods> getMap() {
		return map;
	}

	public void setMap(Map<String, Goods> map) {
		this.map = map;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCartSize() {
		return cartSize;
	}

	public void setCartSize(int cartSize) {
		this.cartSize = cartSize;
	}
	
	
}
