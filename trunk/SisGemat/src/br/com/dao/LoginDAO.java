package br.com.dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import br.com.config.HibernateUtil;
import br.com.tables.Usuario;

public class LoginDAO {
	
	private SessionFactory factory;

	public LoginDAO() throws Exception{  
	       //factory = new Configuration().addClass(Usuario.class).buildSessionFactory();
	       factory =  (SessionFactory) HibernateUtil.getSessionFactory().getCurrentSession();
	   }       
	  
	   public void insert(Usuario amigo) throws Exception{  
	      Session session = factory.openSession();  
	      session.save(amigo);  
	      session.flush();  
	      session.close();  
	   }  
	      
	   public java.util.List getList(String condicao) throws Exception{  
	      Session session = factory.openSession();  
	      List usuarios = null;//session.find(condicao);  
	      session.flush();  
	      session.close();  
	      return usuarios;  
	   }  
	      
	   public Usuario retrieve(String pk) throws Exception{  
	      Session session = factory.openSession();  
	      Usuario amigo = (Usuario)session.load(Usuario.class, pk);  
	      session.flush();  
	      session.close();  
	      return amigo;  
	   }  
	      
	   public void delete(Usuario amigo) throws Exception{  
	      Session session = factory.openSession();  
	      session.delete(amigo);  
	      session.flush();  
	      session.close();  
	   }  

}
