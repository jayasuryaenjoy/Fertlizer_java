import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class preordertable
 */
@WebServlet("/preordertable")
public class preordertable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public preordertable() {
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
		PrintWriter pw = response.getWriter();
		String pname = null;
		String pnum = null;
		String h = null;
		int k = 0;
		// String s1 = (String) request.getAttribute("s");
		HttpSession hs = request.getSession();
		String s1 = (String) hs.getAttribute("Mail");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://jayasuryadb.cjl2qhroglw3.ap-south-1.rds.amazonaws.com:3306/farmer", "admin", "Jayasurya123");
			/*
			 * PreparedStatement pse =
			 * con.prepareStatement("select MailId from Login where lid = ?"); pse.setInt(1,
			 * 1); ResultSet rs1 = pse.executeQuery(); while (rs1.next()) { h =
			 * rs1.getString(1); //System.out.println(h); }
			 */
			PreparedStatement pse1 = con.prepareStatement("select rid from registration where MailId = ? ");
			pse1.setString(1, s1);
			ResultSet rs2 = pse1.executeQuery();
			if (rs2.next()) {
				k = rs2.getInt(1);
				//System.out.println(k);
			}
			PreparedStatement ps = con
					.prepareStatement("select products,Total,shopname from orders where Uid=? order by ID desc");
			ps.setInt(1, k);
			ResultSet rs = ps.executeQuery();
			boolean hasNext = rs.next();
//			System.out.println(hasNext);
			if (hasNext) {
				pw.println("<!DOCTYPE html>\r\n" + "<hreeeeuuatml lang=\"en\">\r\n" + "<head>\r\n"
						+ " <meta charset=\"UTF-8\">\r\n"
						+ " <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
						+ " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ " <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
						+ " integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n"
						+ " <title>sample</title>\r\n" + " <style>\r\n" + " body{\r\n"
						+ " background-color: rgb(42, 161, 165);\r\n" + " }\r\n" + " .topnav {\r\n"
						+ " overflow: hidden;\r\n" + " background-color: #333;\r\n" + " }\r\n" + " \r\n"
						+ " .topnav a {\r\n" + " float: left;\r\n" + " color: #f2f2f2;\r\n" + " text-align: center;\r\n"
						+ " padding: 14px 16px;\r\n" + " text-decoration: none;\r\n" + " font-size: 17px;\r\n"
						+ " }\r\n" + " \r\n" + " .topnav a:hover {\r\n" + " background-color: #ddd;\r\n"
						+ " color: black;\r\n" + " }\r\n" + " \r\n" + " .topnav a.active {\r\n"
						+ " background-color: steelblue;\r\n" + " color: white;\r\n" + " }\r\n" + " .center{\r\n"
						+ " max-width:100%;\r\n" + " margin:auto;\r\n" + " margin-top: 5%;\r\n" + " padding: 5px;\r\n"
						+ " background-color: white;\r\n" + " border-radius: 30px;\r\n" + " text-align:center;\r\n"
						+ "}\r\n" + " table, th, td {\r\n" + " border:0px dashed gray;\r\n"
						+ " border-collapse: collapse;\r\n" + " background-color: white;\r\n"
						+ " border-radius: 30px;\r\n" + " padding: 5px;\r\n" + " }\r\n" + " form{\r\n"
						+ " text-align: center;\r\n" + " }\r\n" + " </style>\r\n" + "</head>\r\n"
						+ "<body style=\"height: 100%; background: url(images/agri.png) no-repeat center fixed; -webkit-background-size: cover; background-size: cover;\">\r\n"
						+ " <div class=\"topnav\">\r\n" + " <a class=\"\" href=\"index.html\">Home</a>\r\n"
						+ " <a href=\"ContactUs.html\">Contact Us</a> \r\n"
						+ " <a href=\"AboutUs.html\">About Us</a>\r\n" + " <li style=\"float:right\"><a href=\"AfterLogin.html\">Back</a></li>\r\n"
						+ " <li style=\"float:right\"><a href=\"index.html\">Logout</a></li>\r\n" + " \r\n" + " \r\n"
						+ " </div>\r\n" + " <form action=\"\">\r\n" + " <table class=\"center\">\r\n" + " <tr>\r\n"
						+ " <th>Item</th>\r\n" + " <th>Quantity</th>\r\n" + "<th>Shops</th>");

				while (hasNext) {
					String i = rs.getString(1);
					int j = rs.getInt(2);
					String x = rs.getString(3);
					String value = i;
					
					value = value.substring(1, value.length() - 1); // remove curly brackets
					
					String[] keyValuePairs = value.split(","); // split the string to creat key-value pairs
					System.out.println(keyValuePairs.toString());
					Map map = new HashMap();
					
					for (String pair : keyValuePairs) // iterate over the pairs
					{
						System.out.println(pair);
						String[] entry = pair.split("="); // split the pairs to get key and value
						map.put(entry[0].trim(), entry[1].trim()); 
						System.out.println(entry.toString());// add them to the hashmap and trim whitespaces
					}
					Set set = map.entrySet();// Converting to Set so that we can traverse
					Iterator itr = set.iterator();
					while (itr.hasNext()) {
						// Converting to Map.Entry so that we can get key and value separately
						Map.Entry entry = (Map.Entry) itr.next();
						 System.out.println(entry.getKey() + " " + entry.getValue());
						pname = (String) entry.getKey();
						pnum = (String) entry.getValue();
						pw.println("<tr>\r\n" + " <td>" + pname + "</td>\r\n" + " <td>" + pnum + "</td>\r\n" + " <td>"
								+ x + "</td>");
					}
					pw.println(
							"<tr> <td rowspan =\"2\"><p>Total:</p></td>\r\n" + " <td><p>" + j + "</p></td></tr>\r\n");
					break;
				}
			} else {
				pw.println("<html>\r\n" + "<head>\r\n" + "<style>\r\n" + ".center{\r\n" + "max-width:500px;\r\n"
						+ "margin:auto;\r\n" + "margin-top: 15%;\r\n" + "padding: 5px;\r\n" + "border-radius: 15px;\r\n"
						+ "}\r\n" + ".topnav {\r\n" + "overflow: hidden;\r\n" + "background-color: #333;\r\n" + "}\r\n"
						+ "\r\n" + "\r\n" + "\r\n" + ".topnav a {\r\n" + "float: left;\r\n" + "color: #f2f2f2;\r\n"
						+ "text-align: center;\r\n" + "padding: 14px 16px;\r\n" + "text-decoration: none;\r\n"
						+ "font-size: 17px;\r\n" + "}\r\n" + "\r\n" + "\r\n" + "\r\n" + ".topnav a:hover {\r\n"
						+ "background-color: #ddd;\r\n" + "color: black;\r\n" + "}\r\n" + "\r\n" + "\r\n" + "\r\n"
						+ ".topnav a.active {\r\n" + "background-color: steelblue;\r\n" + "color: white;\r\n" + "}\r\n"
						+ ".topnav-right{\r\n" + "float:right;\r\n" + "}" 
						+"body{margin:0px;}"
						+ "</style>\r\n" + "</head>\r\n"
						+ "<body bgcolor=\"#bfff80\">\r\n" + "<div class=\"topnav\">\r\n"
						+ "<a href=\"index.html\">Home</a>\r\n" + "\r\n"
						+ "<a href=\"ContactUs.html\">Contact Us</a>\r\n" + "<a href=\"AboutUs.html\">About Us</a>\r\n"
						+ "<div class=\"topnav-right\">\r\n" 
						+ " <li style=\"float:right\"><a href=\"AfterLogin.html\">Back</a></li>\r\n"
						+ "<a href=\"index.html\">Logout</a>\r\n"
						+ "</div>\r\n" + "\r\n" + "\r\n" + "\r\n" + "</div>"
						+ " <h1 style=\"color:#cc0099\" class=\"center\">You have No previuos Orders</h1>\r\n"
						+ "</body>\r\n" + "</html>");
			}
		} catch (Exception e) {
			System.out.println(e);
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
