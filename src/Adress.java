
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Adress1
 */
@WebServlet("/Adress")
public class Adress extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adress() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//      response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        String name = request.getParameter("name");
        String H_no=request.getParameter("H_no");
        String street=request.getParameter("street");
        String city=request.getParameter("city");
        String state=request.getParameter("state");
        int pincode=Integer.parseInt(request.getParameter("pincode"));
        //int phoneno=Integer.parseInt(request.getParameter("phoneno"));
        String phoneno=request.getParameter("MobileNo");
      //  System.out.println(phoneno);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://jayasuryadb.cjl2qhroglw3.ap-south-1.rds.amazonaws.com:3306/farmer", "admin", "Jayasurya123");
            PreparedStatement pst = con.prepareStatement("insert into address (name,H_no,street,city,state,pincode,phoneno) values(?,?,?,?,?,?,?)");
            pst.setString(1,name);
            pst.setString(2, H_no);
            pst.setString(3, street);
            pst.setString(4,city);
            pst.setString(5, state);
            pst.setInt(6, pincode);
            pst.setString(7, phoneno);
           // pst.setString(7, phoneno);
            int k =pst.executeUpdate();     
            if(k>0) {
            	RequestDispatcher dispatcher = null;
            	dispatcher=request.getRequestDispatcher("Message.html");
				dispatcher.forward(request, response);
            }
        }catch(Exception e) {
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