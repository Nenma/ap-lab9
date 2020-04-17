package ro.uaic.info.pa.dao;

import ro.uaic.info.pa.entity.Album;
import ro.uaic.info.pa.entity.Artist;

import java.util.List;

public interface AlbumDAO {

    void create(Album album);
    Album findById(Long id);
    List<Album> findByName(String name);
    List<Album> findByArtist(Artist artist);

}
