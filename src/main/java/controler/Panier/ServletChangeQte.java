package controler.Panier;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/30
 */

import dao.DaoProduit;
import metier.Produit;
import metier.Promotion;
import service.ServicePanier;
import service.ServiceProduit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/ServletChangeQte")
public class ServletChangeQte extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recuperer des session
        HttpSession session=req.getSession();
        String email=(String) session.getAttribute("email");
        //Recuperer le quantite de produit et le code de produit
        Long qte=Long.valueOf(req.getParameter("qte")) ;
        Integer idp=Integer.valueOf(req.getParameter("idp")) ;
        //mise a jour la base de donnees
        new ServicePanier().changeQte(email,qte,idp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
