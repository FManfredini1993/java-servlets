package br.com.alura.gerenciador.acoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		return "forward:formLogin.jsp";
	}		
}