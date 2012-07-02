package br.com.cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

import br.com.config.Conexao;
import br.com.config.HibernateUtil;
import br.com.tables.Usuario;

@ManagedBean(name = "cadastroUsuarioAction")
public class CadastroUsuarioAction {

	private Usuario usuarioDTO;
	
	public CadastroUsuarioAction(){
		usuarioDTO = new Usuario();
	}

	public String load(){
		return "load.fwd";
	}

	public String cadastrar(){
		try{

			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			if(usuarioDTO.getAtivoInativo() == null)
				usuarioDTO.setAtivoInativo(true);
			if(usuarioDTO.getDataNascimento() == null)
				usuarioDTO.setDataNascimento(new Date());
			if(usuarioDTO.getCpf()==null)
				usuarioDTO.setCpf("00000000000");
			session.save(usuarioDTO);

			session.getTransaction().commit();

		}catch(Exception e){
			e.printStackTrace();
			return "erroCadastrar.fwd";
		}

		return "cadastrar.fwd";
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
