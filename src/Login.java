import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		/*
		 * GetValues gv = new GetValues(request.getParameter("MailId"));
		 * gv.setMail(request.getParameter("MailId"));
		 */
		// PrintWriter out = response.getWriter();
		String Password = request.getParameter("Password");
		String MailId = request.getParameter("MailId");

		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("Afterlogin");
		 * rd.forward(request,response);
		 */
		HttpSession hs = request.getSession();
		hs.setAttribute("Mail", MailId);

		RequestDispatcher dispatcher = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://jayasuryadb.cjl2qhroglw3.ap-south-1.rds.amazonaws.com:3306/farmer", "admin", "Jayasurya123");
			PreparedStatement pst = con.prepareStatement("select * from registration where MailId=? and Password=?");
			pst.setString(1, MailId);
			pst.setString(2, Password);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
//				PreparedStatement pst1 = con.prepareStatement("update login  set MailId=?,Password=? where lid=1");
//				pst1.setString(1, MailId);
//				pst1.setString(2, Password);
//				int k = pst1.executeUpdate();
				PrintWriter pw = response.getWriter();
				pw.println("<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n" + "<link\r\n"
						+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"\r\n"
						+ "	rel=\"stylesheet\"\r\n"
						+ "	integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"\r\n"
						+ "	crossorigin=\"anonymous\">\r\n" + "<style>\r\n" + ".topnav {\r\n"
						+ "	overflow: hidden;\r\n" + "	background-color: #333;\r\n" + "}\r\n" + "\r\n"
						+ ".topnav a {\r\n" + "	float: left;\r\n" + "	color: #f2f2f2;\r\n"
						+ "	text-align: center;\r\n" + "	padding: 14px 16px;\r\n" + "	text-decoration: none;\r\n"
						+ "	font-size: 17px;\r\n" + "}\r\n" + "\r\n" + ".topnav a:hover {\r\n"
						+ "	background-color: #ddd;\r\n" + "	color: black;\r\n" + "}\r\n" + "\r\n"
						+ ".topnav a.active {\r\n" + "	background-color: steelblue;\r\n" + "	color: white;\r\n"
						+ "}\r\n" + "</style>\r\n" + "<title>After login</title>\r\n" + "</head>\r\n"
						+ "<body style=\"background-color: #bbff99\">\r\n" + "	<div class=\"topnav\">\r\n"
						+ "		<a href=\"index.html\">Home</a> \r\n"
						+ "		<a href=\"ContactUs.html\">Contact Us</a> <a href=\"AboutUs.html\">About Us</a>\r\n"
						+ "		\r\n"
						+ "		<li style=\"float: right\"><a href=\"index.html\">Logout</a></li>\r\n" + "\r\n" + "\r\n" + "\r\n"
						+ "\r\n" + "	</div>\r\n" + "	<form action=\"preordertable\">\r\n" + "		<center>\r\n"
						+ "			<img src=\"Images/Afterlogin.jpg\" height=\"250\" width=\"500\"\r\n"
						+ "				style=\"margin-top: 3%\"></img>\r\n" + "			<table>\r\n"
						+ "				<tr>\r\n" + "					<td><input type=\"submit\"\r\n"
						+ "						style=\"background-color: #ffccf2; width: 200px; height: 65px; margin-top: 10%; font-size: 15px\"\r\n"
						+ "						value=\"Previous Order Details\"></td>\r\n" + "				</tr>\r\n"
						+ "				<tr>\r\n" + "					<td><input type=\"button\"\r\n"
						+ "						style=\"background-color: #ffccf2; width: 200px; height: 65px; margin-top: 10%; font-size: 15px\"\r\n"
						+ "						onclick=\"location.href='Shops.html'\" value=\"Shop Now\"></td>\r\n"
						+ "			</table>\r\n" + "		</center>\r\n" + "		</script>\r\n" + "	</form>\r\n"
						+ "</body>\r\n" + "</html>");

			} else {

				dispatcher = request.getRequestDispatcher("index1.html");
				dispatcher.forward(request, response);

			}

		} catch (Exception e) {
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
