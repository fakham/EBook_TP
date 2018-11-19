package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBCart_Livre {
	
	public static int insert(Cart_Livre cart_livre) {
		Connection con = DBUtil.dbConnect("ventes_ebook", "root", "");
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "INSERT INTO clients(nom, prenom, email, password) " +
						"VALUES (?, ?, ?, ?)";
		
		String query2 = "INSERT INTO carts(client) " +
						"VALUES (?)";
		
		String query3 = "INSERT INTO carts_livres(cart, livre) " +
						"VALUES (?, ?)";
		
		try {
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cart_livre.getCart().getClient().getNom());
			ps.setString(2, cart_livre.getCart().getClient().getPrenom());
			ps.setString(3, cart_livre.getCart().getClient().getEmail());
			ps.setString(4, cart_livre.getCart().getClient().getPassword());
			
			ps.executeUpdate();
			
			int client_id = 1;
			
			rs = ps.getGeneratedKeys();
			while(rs.next()) {
				client_id = rs.getInt(1);
			}
			
			DBUtil.closePreparedStatement(ps);
			
			ps = con.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, client_id);
			
			ps.executeUpdate();
			
			int cart_id = 1;
			
			DBUtil.closeResultSet(rs);
			rs = ps.getGeneratedKeys();
			while(rs.next()) {
				cart_id = rs.getInt(1);
			}
			
			DBUtil.closePreparedStatement(ps);
			
			for (Livre l : cart_livre.getLivres()) {
				
				ps = con.prepareStatement(query3);
				ps.setInt(1, cart_id);
				ps.setInt(2, l.getId());
				
				ps.executeUpdate();
				
				DBUtil.closePreparedStatement(ps);
				
			}
			
			return 1;
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
		}
	}
	
}
