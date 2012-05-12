package br.com.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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

}
