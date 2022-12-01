package com.niit.service;

import com.niit.domain.Track;

import java.util.List;
import java.util.Optional;

public interface ITrackService {
    Track saveTrack(Track track);

    List<Track> fetchAllTracks();

    Optional<Track> fetchById(int trackId);

    boolean deleteTrack(int trackId);

    List<Track> fetchByTrackArtist(String trackArtist);
}
