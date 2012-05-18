package br.com.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;

import br.com.config.HibernateUtil;
import br.com.dao.LoginDAO;
import br.com.tables.Usuario;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

	private String	usuario;
	private String	senha;

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String verificaLogin() {

		if (this.usuario.equalsIgnoreCase("Rafael") && this.senha.equalsIgnoreCase("123")) {
			System.out.println("Logar");
			return "logar";

		} else {
			System.out.println("fail");
			return "fail";
		}
	}

	public String logar() {
		
		try{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Usuario amigo = (Usuario)session.load(Usuario.class,1l);
		System.out.println(amigo.getLogin());
		//session.getTransaction().commit();
		
		LoginDAO dao = new LoginDAO();   
	    dao.retrieve("1");  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "logar";
	}

}
