import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Productsmry
 */
@WebServlet("/ProductSummary2")
public class ProductSummary2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		String M = (String) hs.getAttribute("Mail");
		String N = (String) hs.getAttribute("regMail");
		// String Mid = (String) request.getAttribute("s");
//		System.out.println("Summary reg "+N);
		int uid = 0;
	
		String Mid = null;
		String sname = "Serole Fertilizers";
		PrintWriter pw = response.getWriter();
		String p1 = request.getParameter("p1");
		String p2 = request.getParameter("p2");
		String p3 = request.getParameter("p3");
		String p4 = request.getParameter("p4");
		String p5 = request.getParameter("p5");
		String p6 = request.getParameter("p6");
		String p7 = request.getParameter("p7");
		String p8 = request.getParameter("p8");
		String p9 = request.getParameter("p9");
		String p10 = request.getParameter("p10");
		String p11 = request.getParameter("p11");
		String p12 = request.getParameter("p12");
		String p13 = request.getParameter("p13");
		String p14= request.getParameter("p14");
		String p15 = request.getParameter("p15");
		String p16 = request.getParameter("p16");
		String p17 = request.getParameter("p17");
		String p18 = request.getParameter("p18");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://jayasuryadb.cjl2qhroglw3.ap-south-1.rds.amazonaws.com:3306/farmer", "admin", "Jayasurya123");
			
			PreparedStatement ps1 = con.prepareStatement("update items set noofitems=? where id='p1'");
			ps1.setString(1, p1);
			int a = ps1.executeUpdate();
			PreparedStatement ps2 = con.prepareStatement("update items set noofitems=? where id='p2'");
			ps2.setString(1, p2);
			int b = ps2.executeUpdate();
			PreparedStatement ps3 = con.prepareStatement("update items set noofitems=? where id='p3'");
			ps3.setString(1, p3);
			int c = ps3.executeUpdate();
			PreparedStatement ps4 = con.prepareStatement("update items set noofitems=? where id='p4'");
			ps4.setString(1, p4);
			int d = ps4.executeUpdate();
			PreparedStatement ps5 = con.prepareStatement("update items set noofitems=? where id='p5'");
			ps5.setString(1, p5);
			int e = ps5.executeUpdate();
			PreparedStatement ps6 = con.prepareStatement("update items set noofitems=? where id='p6'");
			ps6.setString(1, p6);
			int f = ps6.executeUpdate();
			PreparedStatement ps7 = con.prepareStatement("update items set noofitems=? where id='p7'");
			ps7.setString(1, p7);
			int g = ps7.executeUpdate();
			PreparedStatement ps8 = con.prepareStatement("update items set noofitems=? where id='p8'");
			ps8.setString(1, p8);
			int h = ps8.executeUpdate();
			PreparedStatement ps9 = con.prepareStatement("update items set noofitems=? where id='p9'");
			ps9.setString(1, p9);
			int i = ps9.executeUpdate();
			PreparedStatement ps10 = con.prepareStatement("update items set noofitems=? where id='p10'");
			ps10.setString(1, p10);
			int j = ps10.executeUpdate();
			PreparedStatement ps11 = con.prepareStatement("update items set noofitems=? where id='p11'");
			ps11.setString(1, p11);
			int k = ps11.executeUpdate();
			PreparedStatement ps12 = con.prepareStatement("update items set noofitems=? where id='p12'");
			ps12.setString(1, p12);
			int l = ps12.executeUpdate();
			PreparedStatement ps13 = con.prepareStatement("update items set noofitems=? where id='p13'");
			ps13.setString(1, p13);
			int m = ps13.executeUpdate();
			PreparedStatement ps14 = con.prepareStatement("update items set noofitems=? where id='p14'");
			ps14.setString(1, p14);
			int n = ps14.executeUpdate();
			PreparedStatement ps15 = con.prepareStatement("update items set noofitems=? where id='p15'");
			ps15.setString(1, p15);
			int o = ps15.executeUpdate();
			PreparedStatement ps16 = con.prepareStatement("update items set noofitems=? where id='p16'");
			ps16.setString(1, p16);
			int p = ps16.executeUpdate();
			PreparedStatement ps17 = con.prepareStatement("update items set noofitems=? where id='p17'");
			ps17.setString(1, p17);
			int q = ps17.executeUpdate();
			PreparedStatement ps18 = con.prepareStatement("update items set noofitems=? where id='p18'");
			ps18.setString(1, p18);
			int total = 0;
			Map map = new HashMap();
			String Map = null;
			PreparedStatement rps = con.prepareStatement(
					"select pname,cost,noofitems from productss inner join items on pid=id and items.noofitems!=0");
			ResultSet rs = rps.executeQuery();

			pw.println("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n" + " <meta charset=\"UTF-8\">\r\n"
					+ " <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ " <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
					+ " integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n"
					+ " <title>sample</title>\r\n" + " <style>\r\n" + " body{\r\n"
					+ " background-color: rgb(42, 161, 165);\r\n" + " }\r\n" + " .topnav {\r\n"
					+ " overflow: hidden;\r\n" + " background-color: #333;\r\n" + " }\r\n" + " \r\n"
					+ " .topnav a {\r\n" + " float: left;\r\n" + " color: #f2f2f2;\r\n" + " text-align: center;\r\n"
					+ " padding: 14px 16px;\r\n" + " text-decoration: none;\r\n" + " font-size: 17px;\r\n" + " }\r\n"
					+ " \r\n" + " .topnav a:hover {\r\n" + " background-color: #ddd;\r\n" + " color: black;\r\n"
					+ " }\r\n" + " \r\n" + " .topnav a.active {\r\n" + " background-color: steelblue;\r\n"
					+ " color: white;\r\n" + " }\r\n" + " .center{\r\n" + " max-width:100%;\r\n" + " margin:auto;\r\n"
					+ " margin-top: 5%;\r\n" + " padding: 5px;\r\n" + " background-color: white;\r\n"
					+ " border-radius: 30px;\r\n" + " text-align:center;\r\n" + "}\r\n" + " table, th, td {\r\n"
					+ " border:1px dashed gray;\r\n" + " border-collapse: collapse;\r\n"
					+ " background-color: white;\r\n" + " border-radius: 30px;\r\n" + " padding: 5px;\r\n" + " }\r\n"
					+ " form{\r\n" + " text-align: center;\r\n" + " }\r\n" + " </style>\r\n" + "</head>\r\n"
					+ "<body style=\"height: 100%; background: url(Images/Afterlogin.jpg) no-repeat center fixed; -webkit-background-size: cover; background-size: cover;\">\r\n"
					+ "<form action=\"Address.html\">" + " <div class=\"topnav\">\r\n"
					+ " <a  href=\"index.html\">Home</a>\r\n" 
					+ " <a href=\"ContactUs.html\">Contact Us</a> \r\n" + " <a href=\"AboutUs.html\">About Us</a>\r\n"
					+ " <li style=\"float:right\"><a href=\"shop2products.html\">Back</a></li>\r\n"
					+ " <li style=\"float:right\"><a href=\"index.html\">Logout</a></li>\r\n" + " \r\n" + " \r\n" + " </div>\r\n"
					+ " <form action=\"\">\r\n" + " <table class=\"center\">\r\n" + " <tr style=\"color:red\">\r\n" + " <th>Item</th>\r\n"
					+ " <th>Rate</th>\r\n" + " <th>Quantity</th>\r\n" + " <th>Net Quantity</th>\r\n" + " </tr>\r\n");
			while (rs.next()) {
				String dbpname = rs.getString(1);
				int dbprice = rs.getInt(2);
				int dbpitems = rs.getInt(3);
				int prod = dbprice * dbpitems;

				pw.println("<tr>\r\n" + " <td>" + dbpname + "</td>\r\n" + " <td>Rs" + dbprice + "</td>\r\n" + " <td>"
						+ dbpitems + "</td>\r\n" + " <td>\r\n" + "" + prod + "\r\n" + " </td>\r\n");

				map.put(dbpname, dbpitems);
				Map = map.toString();
				total = total + prod;
				continue;
			}
			pw.println("<tr><th>ShopName</th><td>" + sname + "</td>" + "\r\n" + " <th><p>Total:</p></th>\r\n"
					+ " <td><p>" + total + "</p></td>\r\n" + " </tr>\r\n" + " <tr>\r\n"
					+ " <td colspan =\"4\" style=\"padding: 5%;\" ><input type=\"submit\" value=\"Proceed\" style=\"width: 20%; color:red; font-weight:bold\" ></td>\r\n"
					+ " </tr>" + " </form>\r\n" + "</body>\r\n" + "</html>" + " </tr>\r\n" + " </table>\r\n");
			/*PreparedStatement sltmail = con.prepareStatement("select MailId from login where lid = ?");
			sltmail.setInt(1, lid);
			ResultSet rslogin = sltmail.executeQuery();
			if (rslogin.next()) {
				Mid = rslogin.getString(1);
			}*/
			if(M!=null) {
				PreparedStatement sltId = con.prepareStatement("select rid from registration where MailId = ?");
				
				sltId.setString(1, M);
				ResultSet rs1 = sltId.executeQuery();
				if (rs1.next()) {
					uid = rs1.getInt(1);
					//System.out.println(uid);
				}
			}if(N!=null) {
				PreparedStatement sltId1 = con.prepareStatement("select rid from registration where MailId = ?");
				
				sltId1.setString(1, N);
				ResultSet rs2 = sltId1.executeQuery();
				if (rs2.next()) {
					uid = rs2.getInt(1);
					//System.out.println(uid);
				}
			}
			PreparedStatement insord = con
					.prepareStatement("insert into orders (products,Total,Uid,shopname) values (?,?,?,?)");
			insord.setString(1, Map);
			insord.setInt(2, total);
			insord.setInt(3, uid);
			insord.setString(4, sname);
			insord.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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