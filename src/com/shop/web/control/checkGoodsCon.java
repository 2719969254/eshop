package com.shop.web.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.domain.Goods;
import com.shop.service.HGService;
import com.shop.service.impl.HGServiceImpl;

public class checkGoodsCon extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����Service���л�ȡ������Ϣ�ķ���
		HGService service = new HGServiceImpl();
		
		//��ȡҳ�洫�ݵ�ҳ��
		String code = (String)request.getParameter("goodsCode");
		Goods sgd = service.selectGoodsByCodeSer(code);
		if(sgd !=null){
			//����ȡ��������ӵ���������
			request.setAttribute("sgd", sgd);
			
			//���������е�������ҳ�����չʾ
			request.getRequestDispatcher("/WEB-INF/jsps/check.jsp").forward(request, response);
		}else{
			//�д��������ʾ
			request.setAttribute("message", "��Ϣ������,��δ¼��");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
