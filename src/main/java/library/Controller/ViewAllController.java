package library.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.BO.Reader_BO;
import library.BO.ViewAll;
import library.Dao.Lib_dao;

/**
 * Servlet implementation class ViewAllController
 */
@WebServlet("/ViewAllController")
public class ViewAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<style>");
		pw.print("table{border-collapse: collapse;width: 100%;}");
		pw.print("th,td{text-align: center;padding: 8px;}");
		pw.print("tr:nth-child(even){background-color: #FFFDD0;}");
		pw.print(".divsubmit {width: 50%;margin: 0 10px;padding: 10px 20px;font-size: 20px Trebuchet MS;font-weight: bolder;color: blue;margin-top: 20px;text-align: center;text-decoration: none}");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<a href='home.html'>Back</a>");
		pw.print("<table border='1px' width=100%>");
		pw.print("<tr><th>Id</th><th>Name</th><th>Degree</th><th>Phone</th><th>DOI</th><th>DOR</th><th>Book Name</th></tr>");
		pw.print("");
		List<Reader_BO> l=Lib_dao.getalldetails();
		
		for(Reader_BO eb:l)
		{
			pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getDegree()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getDoi()+"</td><td>"+eb.getDor()+"</td><td>"+eb.getBookname()+"</td><td>"+"<a href='EditServlet?id="+eb.getId()+"'> Edit </a></td> <td><a href='DeleteServlet?id="+eb.getId()+"'>Delete </a></td></tr>"); 
			
		}
		pw.print("</table>");
		
		
		
		
		
	}

}
