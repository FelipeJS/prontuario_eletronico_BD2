package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private final EntityManagerFactory factory;

    private static JPAUtil instace;

    private JPAUtil() {
        this.factory = Persistence.createEntityManagerFactory("prontuario_eletronicoPU");
    }

    public static synchronized JPAUtil getInstance() {
        if (instace == null) {
            instace = new JPAUtil();
        }
        return instace;
    }
    
    public EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
    
    public void close(){
        factory.close();
    }
}
