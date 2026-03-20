package com.music.streaming.platform.controller;

import com.music.streaming.platform.dto.TrackRequest;
import com.music.streaming.platform.model.Track;
import com.music.streaming.platform.service.TrackService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music/platform/v1/tracks")
public class TrackController {

    private final TrackService ts;

    public TrackController(TrackService ts) {
        this.ts=ts;
    }


    @PostMapping
    public ResponseEntity<Track> createTrack(@RequestBody TrackRequest request) {
        return ResponseEntity.ok(ts.createTrack(request));
    }


    @GetMapping
    public ResponseEntity<List<Track>> getAllTracks() {
        return ResponseEntity.ok(ts.getAllTracks());
    }


    @GetMapping("/{trackId}")
    public ResponseEntity<Track> getTrackById(@PathVariable Long trackId) {
        return ResponseEntity.ok(ts.getTrackById(trackId));
    }


    @PutMapping("/{trackId}")
    public ResponseEntity<Track> updateTrack( @PathVariable Long trackId, @RequestBody TrackRequest request) {
        return ResponseEntity.ok(ts.updateTrack(trackId, request));
    }


    @DeleteMapping("/{trackId}")
    public ResponseEntity<Track> deleteTrack(@PathVariable Long trackId) {
        ts.deleteTrack(trackId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}