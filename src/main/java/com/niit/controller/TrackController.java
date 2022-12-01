package com.niit.controller;


import com.niit.domain.Track;
import com.niit.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    private ITrackService iTrackService;

    @Autowired
    public TrackController(ITrackService iTrackService) {
        this.iTrackService = iTrackService;
    }

    @PostMapping("/addTrack")
    public ResponseEntity<?> saveFunction(@RequestBody Track trackObj) {
        return new ResponseEntity<>(iTrackService.saveTrack(trackObj), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAllTracks")
    public ResponseEntity<?> fetchFunction() {
        return new ResponseEntity<>(iTrackService.fetchAllTracks(), HttpStatus.OK);
    }

    @GetMapping("/fetchTrackById/{trackId}")
    public ResponseEntity<?> fetchByIdFunction(@PathVariable int trackId) {
        return new ResponseEntity<>(iTrackService.fetchById(trackId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTrackById/{trackId}")
    public ResponseEntity<?> deleteFunction(@PathVariable int trackId) {
        iTrackService.deleteTrack(trackId);
        return new ResponseEntity<>(iTrackService, HttpStatus.OK);
    }

    @GetMapping("/fetchByTrackArtist/{trackArtist}")
    public ResponseEntity<?> fetchTrackArtistFunction(@PathVariable String trackArtist) {
        return new ResponseEntity<>(iTrackService.fetchByTrackArtist(trackArtist), HttpStatus.OK);
    }
}
