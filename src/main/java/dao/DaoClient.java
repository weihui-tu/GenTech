package dao;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/23
 */

import Outil.HibernateConn;
import metier.Client;
import metier.Commande;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DaoClient {
    /*
     * @param [emailClient]
     * @return metier.Client
     * @author TANG
     * @date 2021/3/23 11:31
     * @exception Exception
     * @description trouver un client selon email
     */
    public Client unClient(String emailClient){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
       Transaction t= session.beginTransaction();
        Client c=null;
        try {
            c=session.get(Client.class,emailClient);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoClient unclient not ok");
            System.out.println("----------------------------");
        }
        t.commit();
        session.close();
        return c;
    }



    public ArrayList<Client> listClient(){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        String sql = "select client.* from client";
        ArrayList<Client> list = null;
        try{
            list=(ArrayList<Client>) session.createSQLQuery(sql).addEntity(Client.class).list();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("----------------------");
            System.out.println("DaoClient listeClient");
            System.out.println("----------------------");
        }
        t.commit();
        session.close();
        return list;
    }
    public void updateClient(String email, String idMagasin){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Client client=(Client)session.get(Client.class,email);
        client.setIdMagasin(idMagasin);
        session.update(client);
        session.getTransaction().commit();
        session.close();
    }

    public void updateScoreCli(String emailClient,int score){
            Session session= HibernateConn.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            String sql="update client set score=? where emailClient=?";
            try{
                session.createSQLQuery(sql).setParameter(1,score).setParameter(2,emailClient).executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("----------------------");
                System.out.println("DaoRayon listeClient");
                System.out.println("----------------------");
            }
            t.commit();
            session.close();
        }

}
