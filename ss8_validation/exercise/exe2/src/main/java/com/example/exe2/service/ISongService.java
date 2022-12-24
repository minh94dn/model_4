package com.example.exe2.service;

import com.example.exe2.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();

    void add(Song song);

    void edit(Song song);

    Optional<Song> findById(int id);
}
