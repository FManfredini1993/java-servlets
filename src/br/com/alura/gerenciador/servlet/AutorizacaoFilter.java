package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutorizacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String paramAcao = request.getParameter("acao");
		boolean usuarioNaoEstaLogado = (((HttpServletRequest) request).getSession().getAttribute("usuarioLogado") == null);
		boolean acaoProtegida = !paramAcao.equals("Login") || paramAcao.equals("LoginForm");		
		
		if (usuarioNaoEstaLogado && acaoProtegida) {
			((HttpServletResponse) response).sendRedirect("entrada?acao=LoginForm");			
			return;
		}		
	}
}
