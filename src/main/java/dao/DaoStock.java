package dao;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import Outil.HibernateConn;
import metier.Commande;
import metier.Entrepot;
import metier.Ligneachat;
import metier.Produit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashMap;

public class DaoStock {
    public void ajouterCommande(String idCdeachat,String dateCdeAchat,String dateCdeArrive,String etatCdeAchat,String idMagasin){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Entrepot en =new  Entrepot();
        en.setIdCdeAchat(idCdeachat);
        en.setEtatCdeAchat(idCdeachat);
        en.setDateCdeAchat(dateCdeAchat);
        en.setDateCdeArrive(dateCdeArrive);
        en.setEtatCdeAchat(etatCdeAchat);
        en.setIdMagasin(idMagasin);
        try{
            session.save(en);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPreference ajoute");
            System.out.println("----------------------------");

        }
        transaction.commit();
        session.close();
    }

    public void addLigneAchat(String idCdeAchat,Integer codeProduit,Long qteAchat,Long qteReste){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Ligneachat La = new Ligneachat();
        La.setIdCdeAchat(idCdeAchat);
        La.setIdProduit(codeProduit);
        La.setQteAchat(qteAchat);
        La.setQteReste(qteReste);
        try{
            session.save(La);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPreference ajouterLigneAchat");
            System.out.println("----------------------------");

        }
        transaction.commit();
        session.close();
    }


        public ArrayList<Ligneachat> achatproduitdeja (Integer idcat,String idachat,Integer codeproduit) {
            Session session = HibernateConn.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();

            ArrayList<Ligneachat> listachatpr = null;

            String sql = "Select la.*,e.idCdeAchat\n" +
                    "from ligneachat la ,entrepot e, produit p,rayon r,rayon r2\n" +
                    "where e.idCdeAchat=la.idCdeAchat\n" +
                    "and r.numcate=p.categorie \n" +
                    "and r.idparant = r2.numcate\n" +
                    "and p.codeProduit=la.idProduit\n" +
                    "and str_to_date(dateCdearrive,'%d/%m/%Y') <date_format(curdate(),'%Y-%m-%d')\n" +
                    "and r2.numcate=?\n" +
                    "and e.idCdeAchat=?\n" +
                    "and p.codeProduit=?";
            try {
                listachatpr = (ArrayList<Ligneachat>) session.createSQLQuery(sql).addEntity(Ligneachat.class).setParameter(1, idcat).setParameter(2,idachat).setParameter(3,codeproduit).list();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("----------------");
                System.out.println("Daostockdeja");
                System.out.println("----------------");
            }

            t.commit();
            session.close();
            return listachatpr;
        }


        public ArrayList<Ligneachat> ligneachatsProduit(Integer produitId){
            Session session = HibernateConn.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            String  sql="Select la.*\n" +
                    "from ligneachat la ,entrepot e, produit p,rayon r\n" +
                    "where e.idCdeAchat=la.idCdeAchat\n" +
                    "and r.numcate=p.categorie \n" +
                    "and p.codeProduit=la.idProduit\n" +
                    "and str_to_date(dateCdearrive,'%d/%m/%Y') <date_format(curdate(),'%Y-%m-%d')\n" +
                    "and p.codeProduit=?\n" +
                    "order by str_to_date(dateCdearrive,'%d/%m/%Y') desc\n" +
                    "limit 1";
            ArrayList<Ligneachat> l=null;
            try{
        l = (ArrayList<Ligneachat>) session.createSQLQuery(sql).addEntity(Ligneachat.class).setParameter(1, produitId).list();
            }catch (Exception e){
                System.out.println("----------------");
                System.out.println("Daostockdeja");
                System.out.println("----------------");
            }
            t.commit();
            session.close();
           return l;
        }

    public ArrayList<Ligneachat> ligneachatsfuture(Integer produitId){
        Session session = HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        String  sql="\tSelect la.* from ligneachat la ,entrepot e, produit p,rayon r,rayon r2 \n" +
                "\t\twhere e.idCdeAchat=la.idCdeAchat\n" +
                "\t\t and r.numcate=p.categorie \n" +
                "\t\t and r.idparant = r2.numcate \n" +
                "\t\t and p.codeProduit=la.idProduit \n" +
                "\t\t and e.idCdeAchat=la.idCdeAchat\n" +
                "\t\t and str_to_date(dateCdearrive,'%d/%m/%Y') \n" +
                "\t\t between date_format(curdate(),'%Y-%m-%d')\n" +
                "\t\t and DATE_SUB(CURDATE(), INTERVAL -15 DAY) \n" +
                "\t\t and p.codeproduit=?\n" +
                "\t\t ";
        ArrayList<Ligneachat> l=null;
        try{
            l = (ArrayList<Ligneachat>) session.createSQLQuery(sql).addEntity(Ligneachat.class).setParameter(1, produitId).list();
        }catch (Exception e){
            System.out.println("----------------");
            System.out.println("Daostockdeja");
            System.out.println("----------------");
        }
        t.commit();
        session.close();
        return l;
    }

        public ArrayList<HashMap<Ligneachat, Entrepot>> listCommLigne(ArrayList<Ligneachat> list){
            ArrayList<HashMap<Ligneachat, Entrepot>> l=new ArrayList<>();
            Session session = HibernateConn.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            for (Ligneachat ligne:list
                 ) {
                String idCoo=ligne.getIdCdeAchat();
                Entrepot e=session.get(Entrepot.class,idCoo);
                HashMap<Ligneachat, Entrepot> h=new HashMap<>();
                h.put(ligne,e);
                l.add(h);
            }
            t.commit();
            session.close();
            return  l;
        }


    public ArrayList<Entrepot> achatdejaDate(Integer codeproduit) {
        Session session = HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();

        ArrayList<Entrepot> listEp = null;
        String sql = "select e.* \n" +
                "from entrepot e , ligneachat la,produit p\n" +
                " where e.idCdeAchat =la.idCdeAchat \n" +
                " and p.codeProduit=la.idProduit\n" +
                " and P.codeproduit=?";
        try {
            listEp = (ArrayList<Entrepot>) session.createSQLQuery(sql).addEntity(Entrepot.class).setParameter(1,codeproduit).list();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------");
            System.out.println("entrepot");
            System.out.println("----------------");
        }
        t.commit();
        session.close();
        return listEp;
    }

    public ArrayList<Entrepot> Toutlistachat() {
        Session session = HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        ArrayList<Entrepot> toutacha = null;
        String sql = "select entrepot.* from entrepot";
        try{
            toutacha=(ArrayList<Entrepot>) session.createSQLQuery(sql).addEntity(Entrepot.class).list();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("----------------------");
            System.out.println("DaoRayon listeEntrepot");
            System.out.println("----------------------");
        }
        t.commit();
        session.close();
        return toutacha;

    }

    public ArrayList<Ligneachat> ligneachatsProduitVerifier(Integer produitId,String dateRetrait){
        Session session = HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        String  sql="Select la.* " +
                "from ligneachat la ,entrepot e, produit p " +
                "where e.idCdeAchat=la.idCdeAchat " +
                "and p.codeProduit=la.idProduit " +
                "and str_to_date(dateCdearrive,'%d/%m/%Y') <str_to_date(?,'%d/%m/%Y') " +
                "and p.codeProduit=? " +
                "order by str_to_date(dateCdearrive,'%d/%m/%Y') asc";
        ArrayList<Ligneachat> l=null;
        try{
            l = (ArrayList<Ligneachat>) session.createSQLQuery(sql).addEntity(Ligneachat.class).setParameter(1,dateRetrait ).setParameter(2,produitId).list();
        }catch (Exception e){
            System.out.println("----------------");
            System.out.println("Daostockdeja");
            System.out.println("----------------");
        }
        t.commit();
        session.close();
        return l;
    }

    public void updateLigneAchat(String idCde,Integer idProduit,long qte){
        Session session = HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        String sql="update ligneachat set qteReste=? where idCdeAchat=? and idProduit=?";
        try{
            session.createSQLQuery(sql).setParameter(1,qte).setParameter(2,idCde).setParameter(3,idProduit).executeUpdate();
        }catch (Exception e){
            System.out.println("----------------");
            System.out.println("Daostock updateLigneAchat");
            System.out.println("----------------");
        }
        t.commit();
        session.close();
    }
}
