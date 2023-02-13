package library.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.BO.Reader_BO;
import library.Dao.Lib_dao;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		 
	      String id=request.getParameter("id");
	      pw.println("<link rel='stylesheet' href='css/edit.css'></link>");
	      int eid= Integer.parseInt(id);
	    
	      Reader_BO eb=Lib_dao.grtUserById(eid);
	      //pw.print("body{background-image:url(");
	      
	    pw.print("<a href='home.html'>Back</a>");
		pw.print("<form  action='Update_Controller' method='get'> ");
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<style>");
		pw.print("body {");
		pw.print("   background-image: url('https://img.freepik.com/premium-photo/book-stack-library-room-blurred-bookshelf-background_42691-514.jpg?w=900');");
		pw.print("   background-size: cover;");
		pw.print("   background-repeat: no-repeat;");
		pw.print("}");
		pw.print("input[type='text'], input[type='phone'], input[type='date'], input[type='bookname'] {");
		pw.print("  padding: 0.5em;");
		pw.print("font-size:1em;");
		pw.print("    box-sizing: border-box");
		pw.print("background-color:pink");
		pw.print("}");
		pw.print("form {");
		pw.print("  display: flex;");
		pw.print(" justify-content: center;");
		pw.print("  align-items: center;");
		pw.print(" height: 100vh;");
		pw.print(" }");
		pw.print("input[type=\"submit\"] {");
		pw.print("padding: 0.5em 1em;");
		pw.print("background-color: green;");
		pw.print("color: white;");
		pw.print("button:center");
		pw.print("border: inline;");
		pw.print(" border-radius: 4px;");
		pw.print("cursor: pointer;");
		pw.print("input, textarea { ");
		pw.print("text-align: center;");
		pw.print("width: 30%;");
		pw.print(" padding: 10px;");
		pw.print(" font-size: 14px;");
		pw.print(" border: 1px solid #ddd;");
		pw.print(" box-sizing: border-box;");
		pw.print(" }");
		
		
		pw.print("td {");
		pw.print("border: 1px solid black;");
		pw.print("  overflow: hidden;");
		pw.print(" width: 200px;");
		pw.print("}");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<table>");
		pw.print("<tr><td></td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Degree: </td> <td><input type='text' name='degree' value='"+eb.getDegree()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>DOI : </td> <td><input type='text' name='DOI' value='"+eb.getDoi()+"'/></td></tr>");
	   	pw.print("<tr><td>DOR: </td> <td><input type='text' name='DOR' value='"+eb.getDor()+"'/></td></tr>");
	   	pw.print("<tr><td>Book name: </td> <td><input type='text' name='bookname' value='"+eb.getBookname()+"'/></td></tr>");
	    pw.print("<tr><td><input type='submit' value='Update '/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
		pw.print("</div>");
	}

}
