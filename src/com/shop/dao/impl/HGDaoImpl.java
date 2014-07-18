package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.shop.dao.HGDao;
import com.shop.domain.Goods;
import com.shop.utils.JDBCTools;

public class HGDaoImpl implements HGDao{

	public List<Goods> selectGoodsByType(int type) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods goods = null;
		List<Goods> list = new ArrayList<Goods>();
		try {
			//��ȡ����
			conn = JDBCTools.getConn();
			//����SQL���
			String sql = "select goodsCode,goodsName,goodsNum,goodsType,goodsPrice from goods where goodsType=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs=pstmt.executeQuery();
			
			//�ж��Ƿ������ͬ�û������û���������ȡ���û���Ϣ
			while(rs.next()){
				goods = new Goods();//���ڽ�����ͬ�û������û���Ϣ
				goods.setGoodsCode(rs.getString("goodsCode"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setGoodsNum(rs.getInt("goodsNum"));
				goods.setGoodsType(rs.getInt("goodsType"));
				goods.setGoodsPrice(rs.getDouble("goodsPrice"));
				
				list.add(goods);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			JDBCTools.close(rs, pstmt, conn);
		}

		return list;
	}

	public Goods selectGoodsByCode(String goodsCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods goods = null;
		try {
			//��ȡ����
			conn = JDBCTools.getConn();
			//����SQL���
			String sql = "select * from goods where goodsCode=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, goodsCode);
			rs=pstmt.executeQuery();
			
			//�ж��Ƿ������ͬ�û������û���������ȡ���û���Ϣ
			while(rs.next()){
				goods = new Goods();//���ڽ�����ͬ�û������û���Ϣ
				goods.setGoodsId(rs.getString("goodsId"));
				goods.setGoodsCode(rs.getString("goodsCode"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setGoodsNum(rs.getInt("goodsNum"));
				goods.setGoodsStatus(rs.getString("goodsStatus"));
				goods.setGoodsType(rs.getInt("goodsType"));
				goods.setGoodsDescription(rs.getString("goodsDescription"));
				goods.setGoodsPrice(rs.getDouble("goodsPrice"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			JDBCTools.close(rs, pstmt, conn);
		}
		return goods;
	}

}
