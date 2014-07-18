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

public class ShowPageCon extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����Service���л�ȡ������Ϣ�ķ���
		HGService service = new HGServiceImpl();
		
		//��ȡҳ�洫�ݵ�ҳ��
		String typeStr = (String)request.getParameter("type");
		int type = Integer.parseInt(typeStr);
		List<Goods> selectGoods = service.selectGoodsByTypeSer(type);
		if(selectGoods !=null && selectGoods.size()>0){
			//����ȡ��������ӵ���������
			request.setAttribute("selectGoods", selectGoods);
			
			//���������е�������ҳ�����չʾ
			request.getRequestDispatcher("/WEB-INF/jsps/show.jsp").forward(request, response);
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
