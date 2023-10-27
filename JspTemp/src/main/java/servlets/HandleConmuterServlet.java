package servlets;

import java.io.IOException;;
import beans.ComputerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HandleConmuterServlet
 */
@WebServlet("/HandleConmuterServlet")
public class HandleConmuterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		 		public HandleConmuterServlet() {
				super();
				// TODO Auto-generated constructor stub
		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float first=Float.parseFloat(request.getParameter("First"));
		float second=Float.parseFloat(request.getParameter("Second"));
		char ch=request.getParameter("Ch").charAt(0);
		ComputerBean computerbean = new ComputerBean(first,second,ch);
		computerbean.cacuResult();

		request.setAttribute("ComputerBean", computerbean);
		request.getRequestDispatcher("showResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
