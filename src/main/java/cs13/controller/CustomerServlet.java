package controller;

import bean.Customer;
import bean.Product;
import repository.CustomerRepositoryImlp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    CustomerRepositoryImlp customerRepositoryImlp = new CustomerRepositoryImlp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                showList(request,response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "showById":
                showById(request,response);
            case "Delete":
                    doRemove(request,response);
            default:
                showList(request,response);
        }
    }

    private void doRemove(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("showById"));
        List<Customer> customerList = customerRepositoryImlp.findId(id);
        request.setAttribute("customerList",customerList);
        try {
            request.getRequestDispatcher("listCustomer.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerRepositoryImlp.findAll();
        request.setAttribute("customerList",customerList);
        try {
            request.getRequestDispatcher("listCustomer.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
