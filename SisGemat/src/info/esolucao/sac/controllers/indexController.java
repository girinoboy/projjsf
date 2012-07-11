package info.esolucao.sac.controllers;

import info.esolucao.sac.beans.Menu;
import info.esolucao.sac.dao.MenuDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

/**
 *
 * @author M.N.M
 */
@ManagedBean
@RequestScoped
public class indexController {

	private MenuModel menuModel;
	private MenuDAO menuDAO = new MenuDAO();

	public void geraMenu() {
		menuModel = new DefaultMenuModel();
		List<Menu> listaMenu = menuDAO.listaTodos(); // Substituir o listaTodos() pelos menus permitidos
		for (Menu menu : listaMenu) {
			if (menu.getMenu().getId() == 0) {
				Submenu submenu = new Submenu();
				submenu.setLabel(menu.getDescricao());
				for (Menu m : menuDAO.buscaPorMenu(menu)) {
					if (!menuDAO.verificaSubMenu(m)) {
						MenuItem mi = new MenuItem();
						mi.setValue(m.getDescricao());
						mi.setIcon("imagens/" + m.getIcone());
						submenu.getChildren().add(mi);
					} else {
						Submenu sm = new Submenu();
						sm.setLabel(m.getDescricao());
						sm = geraSubmenu(m);
						submenu.getChildren().add(sm);
					}
				}
				menuModel.addSubmenu(submenu);
			}
		}
	}

	public Submenu geraSubmenu(Menu menu) {
		Submenu submenu = new Submenu();
		submenu.setLabel(menu.getDescricao());
		for (Menu m : menuDAO.buscaPorMenu(menu)) {
			if (!menuDAO.verificaSubMenu(m)) {
				MenuItem mi = new MenuItem();
				mi.setValue(m.getDescricao());
				mi.setStyle("width:100px");
				submenu.getChildren().add(mi);
			} else {
				submenu.getChildren().add(geraSubmenu(m));
			}
		}
		return submenu;
	}

	public MenuModel getMenuModel() {
		return menuModel;

	}

	public indexController() {
		geraMenu();

	}
}