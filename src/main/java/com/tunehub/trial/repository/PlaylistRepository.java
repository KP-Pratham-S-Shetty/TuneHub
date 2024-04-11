package com.tunehub.trial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tunehub.trial.entity.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

}
