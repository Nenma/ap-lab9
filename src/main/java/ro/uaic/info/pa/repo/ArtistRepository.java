package ro.uaic.info.pa.repo;

import ro.uaic.info.pa.dao.ArtistDAO;
import ro.uaic.info.pa.entity.Artist;
import ro.uaic.info.pa.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Repository class that handles communication with the 'artists' table of the database
 */
public class ArtistRepository implements ArtistDAO {

    private final EntityManagerFactory factory = PersistenceUtil.getInstance().getFactory();
    private final EntityManager manager = factory.createEntityManager();

    public ArtistRepository() {}

    @Override
    public void create(Artist artist) {
        manager.getTransaction().begin();
        manager.persist(artist);
        manager.getTransaction().commit();
    }

    @Override
    public Artist findById(Long id) {
        manager.getTransaction().begin();
        Artist artist = manager.find(Artist.class, id);
        manager.getTransaction().commit();
        return artist;
    }

    @Override
    public List<Artist> findByName(String name) {
        manager.getTransaction().begin();
        List<Artist> artists = manager.createNamedQuery("artistFindByName").setParameter("paramName", name).getResultList();
        manager.getTransaction().commit();
        return artists;
    }
}
