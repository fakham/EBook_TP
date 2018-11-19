package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Cart_Livre;
import dao.DBLivre;
import dao.Livre;

/**
 * Servlet implementation class CartItems
 */
@WebServlet("/Cart")
public class CartItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("id") != null) {
			
			int id = Integer.parseInt(request.getParameter("id").toString());
			
			if (request.getParameter("qtte") != null) {
				
				double qtte = Double.parseDouble(request.getParameter("qtte"));
				
				Cart_Livre cart_livre = (Cart_Livre)request.getSession().getAttribute("cart_livre");
				
				for (Livre l : cart_livre.getLivres())
					if (l.getId() == id)
						l.setQtte(qtte);
				

				request.getSession().setAttribute("cart_livre", cart_livre);
				
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
				
			} else {
				
				Cart_Livre cart_livre = null;
				
				if (request.getSession().getAttribute("cart_livre") != null) {
					
					cart_livre = (Cart_Livre)request.getSession().getAttribute("cart_livre");
					
				} else {
					
					cart_livre = new Cart_Livre();
				}
				
				boolean exists = false;
				
				for (Livre l : cart_livre.getLivres()) {
					if (l.getId() == id) {
						l.setQtte(l.getQtte() + 1);
						exists = true;
						break;
					}
				}
				
				if (!exists) {
					Livre livre = DBLivre.getById(id);
					livre.setQtte(1);
					cart_livre.getLivres().add(livre);
				}
				
				request.getSession().setAttribute("cart_livre", cart_livre);
				
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
			
		} else if (request.getParameter("remove") != null) {
			
			int id = Integer.parseInt(request.getParameter("remove").toString());
			
			Cart_Livre cart_livre = (Cart_Livre)request.getSession().getAttribute("cart_livre");
			
			for (int i = 0; i < cart_livre.getLivres().size(); i++) {
				
				if (cart_livre.getLivres().get(i).getId() == id) {
					cart_livre.getLivres().remove(i);
					break;
				}
				
			}
			
			request.getSession().setAttribute("cart_livre", cart_livre);
			
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
			
		} else {
			request.getRequestDispatcher("/livres.jsp").forward(request, response);
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
