package ro.uaic.info.pa.app;

import com.github.javafaker.Faker;
import ro.uaic.info.pa.entity.Album;
import ro.uaic.info.pa.entity.Artist;
import ro.uaic.info.pa.repo.AlbumRepository;
import ro.uaic.info.pa.repo.ArtistRepository;
import ro.uaic.info.pa.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Random;

/**
 * Main class that tests the main Compulsory functionalities
 */
public class AlbumManager {

    private final static EntityManagerFactory factory = PersistenceUtil.getInstance().getFactory();
    private final static EntityManager manager = factory.createEntityManager();

    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rand = new Random();

        // Example testing each method in ArtistRepository
        ArtistRepository artistRepo = new ArtistRepository();
        Artist artist = new Artist(faker.artist().name(), faker.country().name());
        artistRepo.create(artist);
        System.out.println(artistRepo.findById(17L));
        System.out.println(artistRepo.findByName("Rothko"));

        // Example testing each method in AlbumRepository
        AlbumRepository albumRepo = new AlbumRepository();
        albumRepo.create(new Album(faker.funnyName().name(), artist, rand.nextInt(70) + 1951));
        System.out.println(albumRepo.findById(17L));
        System.out.println(albumRepo.findByName("I. M. Boring"));
        System.out.println(albumRepo.findByArtist(artist));

        manager.close();
        factory.close();
    }
}
