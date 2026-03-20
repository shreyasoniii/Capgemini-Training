package com.music.streaming.platform.controller;

import com.music.streaming.platform.dto.ArtistRequest;
import com.music.streaming.platform.model.Artist;
import com.music.streaming.platform.repository.ArtistRepository;
import com.music.streaming.platform.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/music/platform/v1/artists")
public class ArtistController {
   private  ArtistService as;

    @PostMapping("")
    public ResponseEntity<Artist> createArtist(@RequestBody ArtistRequest artist){
        return ResponseEntity.status(HttpStatus.CREATED).body(as.createArtist(artist));
    }
    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists(){
        return ResponseEntity.status(HttpStatus.OK).body(as.getAllArtists());
    }
    @GetMapping("/music/platform/v1/artists/{artistId}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long artistId) {

        Artist artist = as.getArtistById(artistId);

        return ResponseEntity.ok(artist);
    }
    @PostMapping
    public ResponseEntity<Artist> updateArtist(@RequestBody Long artistId, ArtistRequest artistRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(as.updateArtist(artistId,artistRequest));

    }
    @DeleteMapping("/delete/{artistId}")
    public ResponseEntity<Artist> deleteArtist(Long artistId) {
        as.deleteArtist(artistId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
