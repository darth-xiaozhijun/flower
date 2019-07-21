package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Flower;
import com.service.FlowerService;
import com.service.impl.FlowerServiceImpl;
/**
 * tomcat 7以上
 * web 3.0以上
 * @author Administrator
 *
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowerService flowerService =new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String production = req.getParameter("production");
		Flower flower = new Flower();
		flower.setName(name);
		flower.setPrice(Double.parseDouble(price));
		flower.setProduction(production);
		int index = flowerService.add(flower);
		if(index>0)
			//防止表单重复提交
			res.sendRedirect("show");
//			req.getRequestDispatcher("show").forward(req, res);
		else
//			req.getRequestDispatcher("add.jsp").forward(req, res);
			res.sendRedirect("add.jsp");
		
	}
}
