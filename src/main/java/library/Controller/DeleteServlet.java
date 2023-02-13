package library.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.Dao.Lib_dao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//		res.getWriter().append("Served at: ").append(req.getContextPath());
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		int status=Lib_dao.delete(id);
		if(status>0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("ViewAllController");
			rd.forward(req, res);
		}
		else
		{
			pw.write("Record not deleted");
			RequestDispatcher rd=req.getRequestDispatcher("ViewAllController");
			rd.include(req, res);
		}
		
	}

}
