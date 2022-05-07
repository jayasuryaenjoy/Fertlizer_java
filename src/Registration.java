import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String Name = request.getParameter("Name");
		String Password = request.getParameter("Password");
		String ConfirmPassword = request.getParameter("ConfirmPassword");
		String MailId = request.getParameter("MailId");
		
		String MobileNo = request.getParameter("MobileNo");
		String Address = request.getParameter("Address");
		RequestDispatcher dispatcher = null;
		HttpSession hs = request.getSession();
		hs.setAttribute("regMail", MailId);
		

		// pw.println("Name" + Name);
		// pw.println("Password" + Password);
		// pw.println("ConfirmPassword" + ConfirmPassword);
		// pw.println("MailId" + MailId);
		// pw.println("MobileNo" + MobileNo);
		// pw.println("Address" + Address);

		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Connection con = DriverManager.getConnection("jdbc:mysql://jayasuryadb.cjl2qhroglw3.ap-south-1.rds.amazonaws.com:3306/farmer", "admin", "Jayasurya123");

			PreparedStatement stmt = con.prepareStatement("select MailId,MobileNo from registration where MobileNo=? and MailId=?");
			stmt.setString(1, MobileNo);
			stmt.setString(2, MailId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				dispatcher = request.getRequestDispatcher("AlreadyUser.html");
				dispatcher.forward(request, response);
			} else {

				PreparedStatement ps = con.prepareStatement(
						"insert into registration(Name,Password,ConfirmPassword,MailId,MobileNo,Address) values(?,?,?,?,?,?)");
				ps.setString(1, Name);
				ps.setString(2, Password);
				ps.setString(3, ConfirmPassword);
				ps.setString(4, MailId);
				ps.setString(5, MobileNo);
				ps.setString(6, Address);

				int i = ps.executeUpdate();
				if (i > 0) {

					dispatcher = request.getRequestDispatcher("Shops.html");
					dispatcher.forward(request, response);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
