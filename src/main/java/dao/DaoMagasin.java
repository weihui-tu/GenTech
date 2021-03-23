package dao;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/23
 */

import Outil.HibernateConn;
import metier.Magasin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DaoMagasin {
    /*
     * @param
     * @return java.util.ArrayList<metier.Magasin>
     * @author TANG
     * @exception Exception
     * @date 2021/3/23 11:41
     * @description trouves tous les magasin
     */
    public ArrayList<Magasin> listeMagasin(){

        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();

        String sql="select m.* from magasin m";
        ArrayList<Magasin> m=null;
        try {
            m=(ArrayList<Magasin>) session.createSQLQuery(sql).addEntity(Magasin.class).list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoMagasinnot liste magasin not ok");
            System.out.println("----------------------------");
        }
        t.commit();
        return m;
    }
}
