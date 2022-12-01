package com.niit.service;

import com.niit.domain.Track;
import com.niit.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService implements ITrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public List<Track> fetchAllTracks() {
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public Optional<Track> fetchById(int trackId) {
        return trackRepository.findById(trackId);
    }

    @Override
    public boolean deleteTrack(int trackId) {
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Track> fetchByTrackArtist(String trackArtist) {
        return trackRepository.findByTrackArtist(trackArtist);
    }
}
