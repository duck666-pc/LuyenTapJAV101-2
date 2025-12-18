package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.XeMay;
import repository.XeMayRepository;

import java.io.IOException;

@WebServlet("/yourmodel/update")
public class UpdateServlet extends HttpServlet {
    private final XeMayRepository repository = new XeMayRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer id = Integer.valueOf(req.getParameter("id"));
            String ma = String.valueOf(req.getParameter("ma"));
            XeMay obj = repository.getById(id);

            if (obj != null) {
                req.setAttribute("item", obj);
                req.getRequestDispatcher("/WEB-INF/views/update-yourmodel.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/yourmodel");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/yourmodel");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            XeMay obj = new XeMay();
            obj.setId(Integer.valueOf(req.getParameter("id")));
            obj.getMa(String.valueOf(req.getParameter("ma")));

            repository.update(obj);
            resp.sendRedirect(req.getContextPath() + "/yourmodel");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/yourmodel");
        }
    }
}


