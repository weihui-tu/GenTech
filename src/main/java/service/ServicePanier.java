package service;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/28
 */

import dao.DaoMagasin;
import dao.DaoPanier;
import dao.DaoProduit;
import dao.DaoPromotion;
import metier.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ServicePanier {
    private DaoPanier daoPanier=new DaoPanier();

    public void ajouer(String email,Integer idP){daoPanier.ajouer(email,idP);}

    public void supPanier(String email, Integer idProduit) {
        daoPanier.supprimerPanier(email, idProduit);
    }


    public Magasin unMagasin(String idMagasin){
        return new DaoMagasin().unMagasin(idMagasin);
    }

    /*
     * @param
     * @return java.util.HashMap<metier.Produit,metier.Promotion>
     * @author TANG
     * @date 2021/3/30 9:01
     * @description les prouit en promo
     */
    public HashMap<Produit, Promotion> produitPrixPromo(){
        ArrayList<Produit> tousLesProduitPromo=new DaoProduit().listProduitEnPromo();
        ArrayList<Promotion> tousLesPromo=new DaoPromotion().listPromotion();
        ArrayList<Enpromo> tousLesEnPromo=new DaoPromotion().listEnPromo();
        HashMap<Produit,Promotion> res=new HashMap<>();
        HashMap<Produit,Enpromo> pouEnPromo=new HashMap<>();

        for(Enpromo e:tousLesEnPromo){
            for(Produit p:tousLesProduitPromo){
                if(p.getCodeProduit()==e.getCodeProduit()){
                    pouEnPromo.put(p,e);
                }
            }
        }
        for (Produit produit:pouEnPromo.keySet()){
            for (Promotion p:tousLesPromo){
                if (pouEnPromo.get(produit).getIdPromo().equals(p.getIdPromo())){
                    res.put(produit,p);
                }
            }
        }

        return res;
    }

    /*
     * @param emailClient
     * @return java.util.HashMap<metier.Produit,java.lang.Integer>
     * @author TANG
     * @date 2021/3/30 9:01
     * @description list de produit dun client
     */
    public HashMap<Produit,Integer> listPanierUnClient (String emailClient){
        ArrayList<Panier> tousLesProduitDansPainer=daoPanier.listPanierUnClient(emailClient);
        HashMap<Produit,Integer> res=new HashMap<>();
        for(Panier p:tousLesProduitDansPainer){
            Produit produit=new DaoProduit().rechercheUnProduit(p.getCodeProduit());
            res.put(produit,p.getQuantite().intValue());
        }
        return res;
    }


    public  void changeQte(String emailClient,Long qte,Integer codeProd){
        this.daoPanier.modifierQtePanier(emailClient,qte,codeProd);
    }

}