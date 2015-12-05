package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adiciona")
public class AdicionaProduto extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter whiter = response.getWriter();
		
		
		
		
		String nome = request.getParameter("nome");
		
		Integer codigo = Integer.parseInt(request.getParameter("codigo"));
		
		
		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data"));
		} catch (ParseException e) {
			whiter.println(e.getMessage());
			e.printStackTrace();
		}
		
		BigDecimal valor = new BigDecimal(request.getParameter("valor"));
		
		whiter.append("<html>");
		whiter.append("<body>");
		whiter.append("Nome: " + nome + "<br>");
		whiter.append("Código: " + codigo + "<br>");
		whiter.append("Data: " + new SimpleDateFormat("dd/MM/yyyy").format(data) + "<br>");
		whiter.append("Valor: " + NumberFormat.getCurrencyInstance().format(valor) + "<br>");
		whiter.append("Valor: " + request.getParameter("valor") + "<br>");
		whiter.append("</body>");
		whiter.append("</html>");
		
		whiter.append("</html>");
		
		
				
		
		
		whiter.println();
		
		
		
		
		
	}
	

}
