package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserServiceImpl;
import model.User;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/Login")//my request name is login 
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//fetchig request form html
		String userName=request.getParameter("un");
		String password=request.getParameter("pw");
		
		UserServiceImpl service=new UserServiceImpl();
		User userobj=service.getLogin(userName, password);
		if(userobj!=null)
		{
			out.println("<h3><font color='blue'>Login Success</font></h3>");
		
			
			HttpSession session=request.getSession();
			session.setAttribute("userKey", userName);
			session.setAttribute("passKey", password);
			if(userobj.getUserType().equalsIgnoreCase("admin"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("admintask.jsp");
				rd.include(request, response);
			}else if(userobj.getUserType().equalsIgnoreCase("customer"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("customerTask.jsp");
				rd.include(request, response);
			}
			
		}
	}

}
