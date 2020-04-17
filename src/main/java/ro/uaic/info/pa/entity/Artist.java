package ro.uaic.info.pa.entity;

import javax.persistence.*;

/**
 * Class that represents a real-life artist and is also a representation
 * of a tuple of the 'artists' table of the database
 */
@Entity
@Table(name = "artists")
@NamedQuery(name = "artistFindByName", query = "SELECT ar FROM Artist ar WHERE ar.name = :paramName")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    public Artist() {}

    public Artist(String name, String country) {
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
