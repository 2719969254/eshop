package com.shop.web.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.domain.Goods;
import com.shop.domain.ShoppingCart;
import com.shop.service.HGCartSer;
import com.shop.service.HGService;
import com.shop.service.impl.HGCartSerImpl;
import com.shop.service.impl.HGServiceImpl;

public class shoppingCartCon extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����Service���л�ȡ������Ϣ�ķ���
		HGService service = new HGServiceImpl();
		HGCartSer cartSer = new HGCartSerImpl();
		
		String code = request.getParameter("goodsCode");
		//Goods goods = (Goods)request.getAttribute("goods");
		Goods goods = service.selectGoodsByCodeSer(code);
		if(goods !=null){
			//����ȡ����Ʒ��ӵ����ﳵ��
			ShoppingCart shoppingCart = cartSer.addGoods(goods);
			HttpSession session = request.getSession();//����������Ϊsession
			//����ȡ��������ӵ���������
			session.setAttribute("shoppingCart", shoppingCart);
			
			//���������е�������ҳ�����չʾ
			request.getRequestDispatcher("/WEB-INF/jsps/shoppingCart.jsp").forward(request, response);
		}else{
			//�д��������ʾ
			request.setAttribute("message", "��Ϣ������,��δ¼��");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
		
		/*//�ж�code�Ƿ�Ϊ0��Ϊ0����תshoppingCart.jsp����
		if(code.equals("0")){
			//���������е�������ҳ�����չʾ
			request.getRequestDispatcher("/WEB-INF/jsps/shoppingCart.jsp").forward(request, response);
		}else{
			//�д��������ʾ
			request.setAttribute("message", "��Ϣ������,��δ¼��");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}*/
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
