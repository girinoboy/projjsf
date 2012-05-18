package br.com.cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

import br.com.config.Conexao;
import br.com.config.HibernateUtil;
import br.com.tables.Usuario;

@ManagedBean(name = "CadastroUsuarioAction")
public class CadastroUsuarioAction {

	private Usuario usuario;

	public String load(){
		return "load.fwd";
	}

	public String cadastrar(){
		try{

			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(usuario);

			session.getTransaction().commit();

		}catch(Exception e){
			e.printStackTrace();
		}

		return "cadastrar.fwd";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
