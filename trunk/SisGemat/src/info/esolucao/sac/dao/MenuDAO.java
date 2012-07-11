package info.esolucao.sac.dao;

import info.esolucao.sac.beans.Menu;
import info.esolucao.sac.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BENIGNO
 */
public class MenuDAO {

	Connection con;
	String sql;

	public boolean verificaSubMenu(Menu menu) {
		sql = "select count(*) as total from tab_menus where tab_menus_id=?";
		con = ConnectionFactory.getConnection();
		int t = 0;
		try {
			PreparedStatement pstm;
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, menu.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				t = rs.getInt("total");
			}
		} catch (SQLException ex) {
			Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (t > 0);
	}

	public List<Menu> buscaPorMenu(Menu menu) {
		List<Menu> listaMenu = new ArrayList<Menu>();
		sql = "select * from tab_menus where tab_menus_id=?";
		con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, menu.getId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Menu m = new Menu();
				m.setId(rs.getInt("id"));
				m.setDescricao(rs.getString("descricao"));
				m.setIcone(rs.getString("icone"));
				m.setViewId(rs.getString("viewId"));
				Menu subMenu = new Menu();
				subMenu = buscaPorId(rs.getInt("tab_menus_id"));
				m.setMenu(subMenu);
				listaMenu.add(m);
			}
			con.close();
		} catch (SQLException ex) {
			Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaMenu;
	}

	public Menu buscaPorId(int id) {
		sql = "select * from tab_menus where id=?";
		con = ConnectionFactory.getConnection();
		Menu menu = new Menu();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				menu.setId(rs.getInt("id"));
				menu.setDescricao(rs.getString("descricao"));
				menu.setIcone(rs.getString("icone"));
				menu.setViewId(rs.getString("viewId"));
				Menu subMenu = new Menu();
				subMenu = buscaPorId(rs.getInt("tab_menus_id"));
				menu.setMenu(subMenu);
			}
			con.close();
		} catch (SQLException ex) {
			Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return menu;
	}

	public List<Menu> listaTodos() {
		List<Menu> listaMenu = new ArrayList<Menu>();
		sql = "select * from tab_menus";
		con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getInt("id"));
				menu.setDescricao(rs.getString("descricao"));
				menu.setIcone(rs.getString("icone"));
				menu.setViewId(rs.getString("viewId"));
				Menu subMenu = new Menu();
				subMenu = buscaPorId(rs.getInt("tab_menus_id"));
				menu.setMenu(subMenu);
				listaMenu.add(menu);
			}
			con.close();
		} catch (SQLException ex) {
			Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaMenu;
	}
}