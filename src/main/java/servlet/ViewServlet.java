package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.XeMay;
import repository.XeMayRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(value = {"/groups", "/motor-management/groups"})
public class ViewServlet extends HttpServlet {
    private final XeMayRepository repository = new XeMayRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<XeMay> list = repository.getAll();
            req.setAttribute("XeMay", list);
            req.getRequestDispatcher("WEB-INF/views/listXeMay.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
