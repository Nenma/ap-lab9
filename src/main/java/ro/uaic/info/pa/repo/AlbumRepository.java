package ro.uaic.info.pa.repo;

import ro.uaic.info.pa.dao.AlbumDAO;
import ro.uaic.info.pa.entity.Album;
import ro.uaic.info.pa.entity.Artist;
import ro.uaic.info.pa.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Repository class that handles communication with the 'albums' table of the database
 */
public class AlbumRepository implements AlbumDAO {

    private final EntityManagerFactory factory = PersistenceUtil.getInstance().getFactory();
    private final EntityManager manager = factory.createEntityManager();

    public AlbumRepository() {}

    @Override
    public void create(Album album) {
        manager.getTransaction().begin();
        manager.persist(album);
        manager.getTransaction().commit();
    }

    @Override
    public Album findById(Long id) {
        manager.getTransaction().begin();
        Album album = manager.find(Album.class, id);
        manager.getTransaction().commit();
        return album;
    }

    @Override
    public List<Album> findByName(String name) {
        manager.getTransaction().begin();
        List<Album> albums = manager.createNamedQuery("albumFindByName").setParameter("paramName", name).getResultList();
        manager.getTransaction().commit();
        return albums;
    }

    @Override
    public List<Album> findByArtist(Artist artist) {
        manager.getTransaction().begin();
        List<Album> albums = manager.createNamedQuery("findByArtist").setParameter("paramArtistId", artist.getId()).getResultList();
        manager.getTransaction().commit();
        return albums;
    }
}
