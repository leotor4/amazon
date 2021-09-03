package servlet;

import dao.AutorDAO;
import factory.ConnectionFactory;
import model.Autor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/autores")
public class AutorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            AutorDAO autorDAO = new AutorDAO(new ConnectionFactory().getConexao());
            req.setAttribute("autores", autorDAO.listaAutores());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("WEB-INF/pages/autores.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        LocalDate dataDeNascimento = LocalDate.parse(req.getParameter("data"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String miniCurriculo = req.getParameter("minicurriculo");

        Autor autor = new Autor(nome, email, dataDeNascimento, miniCurriculo);

        AutorDAO autorDAO = null;
        try {
            autorDAO = new AutorDAO(new ConnectionFactory().getConexao());
            autorDAO.cadastraAutor(autor);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        resp.sendRedirect("autores");
    }
}
