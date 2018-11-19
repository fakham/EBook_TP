package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBLivre {
	
	public static ArrayList<Livre> getAll() {
		ArrayList<Livre> livres = new ArrayList<>();
		
		Connection con = DBUtil.dbConnect("ventes_ebook", "root", "");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM livres";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				livres.add(new Livre(rs.getInt("id"), rs.getString("description"), rs.getDouble("prix"), rs.getInt("qtte")));
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeResultSet(rs);
		}
		
		return livres;
	}
	
	public static Livre getById(int id) {
		Livre livre = null;
		
		Connection con = DBUtil.dbConnect("ventes_ebook", "root", "");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM livres where id=?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				livre = new Livre(rs.getInt("id"), rs.getString("description"), rs.getDouble("prix"), rs.getInt("qtte"));
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeResultSet(rs);
		}
		
		return livre;
	}
	
}
