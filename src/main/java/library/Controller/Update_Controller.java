package library.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.BO.Reader_BO;
import library.Dao.Lib_dao;

/**
 * Servlet implementation class Update_Controller
 */
@WebServlet("/Update_Controller")
public class Update_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			String degree=req.getParameter("degree");
			String phone=req.getParameter("phone");
			String doi=req.getParameter("DOI");
			String dor=req.getParameter("DOR");
			String bookname=req.getParameter("bookname");
			
			Reader_BO eb=new Reader_BO();
			eb.setId(id);
			eb.setName(name);
			eb.setDegree(degree);
			eb.setPhone(phone);
			eb.setDoi(doi);
			eb.setDor(dor);
			eb.setBookname(bookname);
			
			
			int status=Lib_dao.updateController(eb);
			if(status>0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("ViewAllController");
				rd.forward(req, res);
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("EditServlet");
				rd.include(req, res);
			}
	}

}
