package com.example.exe2.service.impl;

import com.example.exe2.model.Song;
import com.example.exe2.repository.ISongRepository;
import com.example.exe2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void add(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public void edit(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Optional<Song> findById(int id) {
        return iSongRepository.findById(id);
    }
}
