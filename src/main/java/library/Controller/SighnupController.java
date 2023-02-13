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

@WebServlet("/SighnupController")
public class SighnupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SighnupController() {
        super();
        
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String pwd=req.getParameter("pass");
		
		pw.print(name+" "+email+" "+phone+" "+pwd);
		
		LibBo l=new LibBo();
		l.setName(name);
		l.setEmail(email);
		l.setPhone(phone);
		l.setPassword(pwd);
		
		int status=Lib_dao.signup(l);
		if(status>0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.forward(req, res);
			
		}
		else
		{
			pw.print("Something went wrong");
		}
	}
	
		
		
	}


