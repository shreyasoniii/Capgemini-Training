package com.music.streaming.platform.controller;

import com.music.streaming.platform.dto.PlayListRequest;
import com.music.streaming.platform.model.PlayList;
import com.music.streaming.platform.service.PlayListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music/platform/v1/playlists")
public class PlayListController {
    private static PlayListService service;
    @PostMapping
    public ResponseEntity<PlayList> createPlayList(@RequestBody PlayListRequest playListRequest){
        return ResponseEntity.ok(service.createPlayList(playListRequest));
    }
    @GetMapping("/{playListId}")
    public ResponseEntity<PlayList> getPlayListById(@PathVariable Long playListId){
        return ResponseEntity.ok(service.getPlayListById(playListId));
    }
    @DeleteMapping("/{deleteListId}")
    public ResponseEntity<PlayList> deletePlayList(Long playListId){
        service.deletePlayList(playListId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
