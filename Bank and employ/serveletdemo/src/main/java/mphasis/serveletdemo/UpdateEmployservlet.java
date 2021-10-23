package mphasis.serveletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEmployservlet
 */
public class UpdateEmployservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = ConnectionHelper.getConnection();
		String cmd = "Update Employ set Name=?, Gender=?, Dept=?, Desig=?, Basic=? "
				+ " Where Empno=?";
		PrintWriter out = response.getWriter();
		try {
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setString(1,request.getParameter("name"));
			pst.setString(2, request.getParameter("gender"));
			pst.setString(3, request.getParameter("dept"));
			pst.setString(4, request.getParameter("desig"));
			pst.setDouble(5, Double.parseDouble(request.getParameter("basic")));
			pst.setInt(6, Integer.parseInt(request.getParameter("empno")));
			pst.executeUpdate();
			out.println("*** Record Inserted ***");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
