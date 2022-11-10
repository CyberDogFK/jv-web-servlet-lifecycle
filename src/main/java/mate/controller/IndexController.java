package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mate.dao.MyCoolResource;

import java.io.IOException;
import java.time.LocalDateTime;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myResource.write(LocalDateTime.now().toString());
        req.getRequestDispatcher("WEB-INF/views/index.jsp").include(req, resp);
        System.out.println("GET");
    }

    @Override
    public void destroy() {
        System.out.println("Destroyed");
        super.destroy();
        myResource.close();
    }
}
