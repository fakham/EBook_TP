package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Cart;
import dao.Cart_Livre;
import dao.Client;
import dao.DBCart_Livre;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("fname") == null) {
			request.getRequestDispatcher("/checkout.jsp").forward(request, response);
		} else {
			
			String nom = request.getParameter("lname");
			String prenom = request.getParameter("fname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Client client = new Client(1, nom, prenom, email, password);
			Cart cart = new Cart(1, client);
			
			Cart_Livre cart_livre = (Cart_Livre)request.getSession().getAttribute("cart_livre");
			cart_livre.setCart(cart);
			
			
			DBCart_Livre.insert(cart_livre);
			
			request.getRequestDispatcher("/thanks.jsp").forward(request, response);
			
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
