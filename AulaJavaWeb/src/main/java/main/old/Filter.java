package main.old;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/filter/*")
public class Filter implements javax.servlet.Filter {

	private Usuario usuario;

	private Usuario getUsuario() throws IOException {

		ClassLoader loader = getClass().getClassLoader();

		InputStream in = loader.getResourceAsStream("login.properties");

		Properties prop = new Properties();
		prop.load(in);

		usuario = new Usuario();
		usuario.setNome(prop.getProperty("nome"));
		usuario.setSenha(prop.getProperty("senha"));

		return usuario;

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Usuario userForm = new Usuario();
		userForm.setNome(request.getParameter("nome"));
		userForm.setSenha(request.getParameter("senha"));

		((HttpServletRequest) request).getSession().setAttribute("session", userForm.getNome());
		if (!getUsuario().equals(userForm)) {
			((HttpServletResponse) response).sendRedirect("/AulaJavaWeb/index.html");
		} else {
			String destino = ((HttpServletRequest) request).getRequestURI().replace("/filter", "");
			((HttpServletResponse) response).sendRedirect(destino);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
