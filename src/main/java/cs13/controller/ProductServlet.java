package controller;

import bean.Product;
import repository.ProductRepositoryImlp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    ProductRepositoryImlp productRepositoryImlp = new ProductRepositoryImlp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                showList(request,response);
                break;
        }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "Add":
                doAdd(request,response);
                break;
            case "showById":
                showById(request, response);
                break;
            case "Edit":
                doEdit(request,response);
                break;
            case "Delete":
                doRemove(request,response);
            default:
                showList(request,response);
                break;
        }
    }

    private void doRemove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete")) ;
        productRepositoryImlp.remove(id);
        try {
            request.getRequestDispatcher("/ProductServlet?action=null").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idUpdate")) ;
        String name = request.getParameter("nameUpdate");
        Double price = Double.parseDouble(request.getParameter("priceUpdate")) ;
        int amount = Integer.parseInt(request.getParameter("amountUpdate"));
        Product product = new Product(id,name,price,amount);
        productRepositoryImlp.edit(product);
        try {
            request.getRequestDispatcher("/ProductServlet?action=null").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idAdd")) ;
        String name = request.getParameter("nameAdd");
        Double price = Double.parseDouble(request.getParameter("priceAdd")) ;
        int amount = Integer.parseInt(request.getParameter("amountAdd"));

        Product product = new Product(id,name,price,amount);
        productRepositoryImlp.add(product);
        try {
            request.getRequestDispatcher("/ProductServlet?action=null").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("showById"));
        List<Product> product = productRepositoryImlp.findId(id);
        request.setAttribute("productList",product);
        try {
            request.getRequestDispatcher("listProduct.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productRepositoryImlp.findAll();
        request.setAttribute("productList",productList);
        try {
            request.getRequestDispatcher("listProduct.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


}
