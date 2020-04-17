package ro.uaic.info.pa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Singleton class responsible with creating a static instance of an
 * EntityManagerFactory
 */
public class PersistenceUtil {

    private final String PERSISTENCE_UNIT_NAME = "MusicAlbumsPU";
    private final EntityManagerFactory factory;
    private static PersistenceUtil instance;

    private PersistenceUtil() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static PersistenceUtil getInstance() {
        if (instance == null) {
            instance = new PersistenceUtil();
        }
        return instance;
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

}
