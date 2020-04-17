package ro.uaic.info.pa.entity;

import javax.persistence.*;

/**
 * Class that represents an artist's album and is also a representation
 * of a tuple of the 'albums' table of the database
 */
@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "albumFindByName", query = "SELECT al FROM Album al WHERE al.name = :paramName"),
        @NamedQuery(name = "findByArtist", query = "SELECT al FROM Album al WHERE al.artist = :paramArtistId")
})
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

    @Column(name = "release_year")
    private int releaseYear;

    public Album() {}

    public Album(String name, Artist artist, int releaseYear) {
        this.name = name;
        this.artist = artist;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist=" + artist +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
