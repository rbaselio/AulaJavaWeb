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
public class AdicionaProduto extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter whiter = response.getWriter();

		String nome = request.getParameter("nome");
		Integer codigo = Integer.parseInt(request.getParameter("codigo"));

		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data"));
		} catch (ParseException e) {
			e.printStackTrace(whiter);
			e.printStackTrace();
		}

		BigDecimal valor = null;
		try {
			String val = request.getParameter("valor").replace(".", "").replace(",", ".");
			valor = new BigDecimal(val);
		} catch (NumberFormatException e) {
			e.printStackTrace(whiter);
			e.printStackTrace();
		}

		whiter.append("<html>");
		whiter.append("<body>");
		whiter.append("Nome: " + nome + "<br>");
		whiter.append("Código: " + codigo + "<br>");
		whiter.append("Data: " + SimpleDateFormat.getDateInstance().format(data) + "<br>");
		whiter.append("Valor: " + NumberFormat.getCurrencyInstance().format(valor) + "<br>");
		whiter.append("</body>");
		whiter.append("</html>");

		whiter.println();

	}

}
