package library.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import library.BO.LibBo;
import library.BO.Reader_BO;
import library.BO.ViewAll;


public class Lib_dao {
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			String url="jdbc:mysql://localhost:3306/eLib";
			String username="root";
			String password="shruti11";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);	
		}
		catch(Exception e)
		{
			
		}
		return con;
	}
	public static int signup(LibBo l)
	{
		int status=0;
		try
		{
			Connection con=Lib_dao.getConnection();
			String sql="insert into signup(name,email,phone,password) values (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, l.getName());
			ps.setString(2, l.getEmail());
			ps.setString(3, l.getPhone());
			ps.setString(4, l.getPassword());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}	
	
	public static Boolean userlogin(String email,String pass)
	{
		boolean status=false;
		
		try {
			Connection con=Lib_dao.getConnection();
			String sql="select * from signup where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int adduser(Reader_BO u)
	{
		int status=0;
		try
		{
			Connection con=Lib_dao.getConnection();
			String query="insert into adddetails(name,degree,phone,DOI,DOR,bookname) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, u.getName());
			ps.setString(2, u.getDegree());
			ps.setString(3, u.getPhone());
			ps.setString(4, u.getDoi());
			ps.setString(5, u.getDor());
			ps.setString(6, u.getBookname());
			
			
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static List getalldetails()
	{
		
		List<Reader_BO> l=new ArrayList<Reader_BO>();
		try
		{
			Connection con=Lib_dao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from adddetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Reader_BO eb=new Reader_BO();
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setDegree(rs.getString(3));
				eb.setPhone(rs.getString(4));
				eb.setDoi(rs.getString(5));
				eb.setDor(rs.getString(6));
				eb.setBookname(rs.getString(7));
				l.add(eb);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return l;
		
	}
	
	public static Reader_BO grtUserById(int id)
	{
		Reader_BO eb=new Reader_BO();
		try
		{
			Connection con=Lib_dao.getConnection();
			String query="select * from adddetails where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setDegree(rs.getString(3));
				eb.setPhone(rs.getString(4));
				eb.setDoi(rs.getString(5));
				eb.setDor(rs.getString(6));
				eb.setBookname(rs.getString(7));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		return eb;
		
	}
	
public static int updateController(Reader_BO eb)
{
	int status=0;
	try
	{
		Connection con=Lib_dao.getConnection();
		String query="update adddetails set name=?,degree=?,phone=?,DOI=?,DOR=?,bookname=? where id=?";
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setString(1, eb.getName());
		ps.setString(2, eb.getDegree());
		ps.setString(3, eb.getPhone());
		ps.setString(4, eb.getDoi());
		ps.setString(5, eb.getDor());
		ps.setString(6, eb.getBookname());
		ps.setInt(7, eb.getId()); 
		
		status=ps.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	return status;
	
}

public static int delete(int id) {
	
	int status=0;
	  try {
	
		  Connection con=Lib_dao.getConnection();
		  String query="Delete from adddetails where id=?";
		  PreparedStatement ps=con.prepareStatement(query);
		  ps.setInt(1, id);
		  status=ps.executeUpdate();
		  
	} catch (Exception e) {
	
		   System.out.println(e);
	}
	
	return status;
	
}

	
}


