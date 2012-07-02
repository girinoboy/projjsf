package br.com.teste;


import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.cadastro.CadastroUsuarioAction;
import br.com.config.Conexao;
import br.com.managedBean.LoginBean;
import br.com.tables.Usuario;

public class SisGemat {
	
	public SisGemat(){
		
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	 
    @Test
    public void testAddition2() throws Exception {
    	Conexao con = new Conexao();
    	assertNotNull("Conexao valida", con.conectar());
	}
    
    @Test
    public void createUser() throws Exception {
    	CadastroUsuarioAction cadastro = new CadastroUsuarioAction();
    	
    	Usuario usuario = new Usuario();
    	usuario.setLogin("marcleonio");
    	usuario.setSenha("123456");
    	usuario.setAtivoInativo(true);
    	usuario.setDataNascimento(new Date());
    	usuario.setCpf("11111111111");
		cadastro.setUsuario(usuario);
		
    	assertNotNull("Cadastro valido", cadastro.cadastrar());
	}
    
    @Test
    public void verificaLogin() throws Exception {
    	
    	LoginBean login = new LoginBean();
    	Usuario usuario = new Usuario();
    	usuario.setLogin("marcleonio");
    	usuario.setSenha("123456");
    	login.setUsuarioDTO(usuario);
    	assertEquals("logar", login.logar());
    	
    }
    
}
