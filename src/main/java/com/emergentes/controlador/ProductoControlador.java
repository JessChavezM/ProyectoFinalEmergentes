
package com.emergentes.controlador;

import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
              try {
            Producto cli = new Producto();
            int id;
            ProductoDAO dao = new ProductoDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("producto", cli);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    cli = dao.getById(id);
                    request.setAttribute("producto", cli);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                                    
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ProductoControlador");
                    break;
                case "view":
                    List<Producto> lista = dao.getAll();
                    
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
    }
}
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
             int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String codigo = request.getParameter("codigo");
        String descripcion = request.getParameter("descripcion");
      
        String img = request.getParameter("img");
        
        Producto cli = new Producto();

        cli.setId(id);
        cli.setNombre(nombre);
         cli.setCodigo(codigo);
        cli.setDescripcion(descripcion);
     
         cli.setImg(img);

        ProductoDAO dao = new ProductoDAOimpl();
        if (id == 0) {
            try {
                dao.insert(cli);
            } catch (Exception ex) {
                System.out.println("Error al insert" + ex.getMessage());
            }
        } else {
            try {
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Error al insert" + ex.getMessage());
            }
        }
        response.sendRedirect("ProductoControlador");
    }

    
    
    
    
}
