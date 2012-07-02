package br.com.managedBean;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.cadastro.CadastroUsuarioAction;
import br.com.config.HibernateUtil;
import br.com.dao.LoginDAO;
import br.com.tables.Usuario;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

	private String	usuario;
	private String	senha;
	private Usuario usuarioDTO;
	
	public LoginBean(){
		usuarioDTO = new Usuario();
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
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
		
		session.beginTransaction();
		
		//Usuario amigo = (Usuario)session.load(Usuario.class,1l);
		//System.out.println(amigo.getLogin());
		//session.getTransaction().commit();
		
		//LoginDAO dao = new LoginDAO();   
		// dao.retrieve(1L);  
		// dao.getLogin(usuarioDTO);
		/*
		sCadastroUsuarioAction cadastro = new CadastroUsuarioAction();
    	
    	Usuario usuario = new Usuario();
    	usuario.setLogin("marcleonio");
    	usuario.setSenha("123456");
    	usuario.setAtivoInativo(true);
    	usuario.setDataNascimento(new Date());
    	usuario.setCpf("11111111111");
		cadastro.setUsuario(usuario);
		
    	cadastro.cadastrar();*/
		
        Criteria b = session.createCriteria(Usuario.class);
        b.add( Restrictions.eq( "login",  usuarioDTO.getLogin()) );
        b.add( Restrictions.eq( "senha",  usuarioDTO.getSenha()) );
        List<Usuario> objetos = b.list(); 
        if(objetos.size()>0){
        	Usuario u = objetos.get(0);
        	System.out.println(u.getLogin());
        }else{
        	throw new Exception();
        }
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}finally{
			session.close();  
		}
		
		return "logar";
	}
	
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

	public Usuario getUsuarioDTO() {
		if(usuarioDTO == null){
			usuarioDTO = new Usuario();
		}
		return usuarioDTO;
	}

	public void setUsuarioDTO(Usuario usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

}
