package library.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.BO.LibBo;
import library.Dao.Lib_dao;

/**
 * Servlet implementation class Login_Controller
 */
@WebServlet("/Login_Controller")
public class Login_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Login_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");	
		PrintWriter pw=res.getWriter();
		String email=req.getParameter("username");
		String pass=req.getParameter("password");
		
		if(Lib_dao.userlogin(email,pass))
		{
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.forward(req,res);
		}
		else
		{
			pw.print("Username Or passwordwrong!");
			RequestDispatcher rd=req.getRequestDispatcher("SighnupController");
			rd.include(req,res);
			
		}
		
		
	}

}
