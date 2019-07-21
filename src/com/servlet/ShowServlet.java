package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Flower;
import com.service.FlowerService;
import com.service.impl.FlowerServiceImpl;
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowerService flowerService =new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Flower> list = flowerService.show();
		req.setAttribute("list", list);
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}
