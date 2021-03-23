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
}