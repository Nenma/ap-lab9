package ro.uaic.info.pa.dao;

import ro.uaic.info.pa.entity.Artist;

import java.util.List;

public interface ArtistDAO {

    void create(Artist artist);
    Artist findById(Long id);
    List<Artist> findByName(String name);

}
