import Outil.HibernateConn;
import dao.DaoBasic;
import dao.DaoClient;
import dao.DaoClientCommande;
import dao.DaoMagasin;
import metier.Client;
import metier.Commande;
import metier.Lignecommande;
import metier.Magasin;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UnitTest {
    @Test
    public void test(){
        //test
//        DaoMagasin m=new DaoMagasin();
//        for (Magasin mm:m.listeMagasin()
//             ) {
//            System.out.println(mm);
//        }

        //test
        Client client=new DaoClient().unClient("bugubugu@gamil.com");
        System.out.println(client);


        //test
//        DaoClientCommande daoClientCommande=new DaoClientCommande();
//
//        ArrayList<Commande> liste=daoClientCommande.listeCommandeClient("bugubugu@gmail.com");
//        for (Commande l:liste
//             ) {
//            System.out.println(l);
//        }
//        Session session= HibernateConn.getSessionFactory().getCurrentSession();
//        Transaction transaction=session.beginTransaction();
//
//        String sql="select l.* from commande c,lignecommande l where l.idCdeCli=c.idCdeCli and c.idCdeCli=? ";
//
//
//
//        List<Lignecommande> list=session.createSQLQuery(sql).addEntity(Lignecommande.class).setParameter(1,"affd2356").list();
//        for (Lignecommande l:list
//             ) {
//            System.out.println(l);
//        }
        //add un magasin test
//        Magasin magasin=new Magasin();
//        magasin.setIdMagasin("2");
//        session.save(magasin);
        //transaction.commit();
    }
}
