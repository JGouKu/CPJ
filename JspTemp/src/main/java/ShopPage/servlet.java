package ShopPage;

import java.io.IOException;
import Servlet.shop;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet")
public class servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String num=request.getParameter("num");
		shop Shop=new shop(name,price,num);
		request.setAttribute("Shop",Shop);
		request.getRequestDispatcher("Show.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		this.doGet(request,response);
	}
	public void destroy() {
	}

}
