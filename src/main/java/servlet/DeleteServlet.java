package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.XeMayRepository;

import java.io.IOException;

@WebServlet("/motor-management/delete")
public class DeleteServlet extends HttpServlet {
    private final XeMayRepository repository = new XeMayRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        try {
            Integer id = Integer.valueOf(idStr);
            XeMayRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/groups");
    }
}

