package com.example.apirestsongifyup.presentation.controller;

import com.example.apirestsongifyup.DataProvider;
import com.example.apirestsongifyup.persistence.entity.Music;
import com.example.apirestsongifyup.presentation.dto.MusicDto;
import com.example.apirestsongifyup.service.interfaces.IMusicService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MusicControllerTest {

    @Mock
    private IMusicService musicService;

    @InjectMocks
    private MusicController musicController;

    @Test
    void testFindById() {
        // Given
        Long id = 1L;
        Music music = DataProvider.musicMock();

        // When
        when(musicService.findbyId(id)).thenReturn(Optional.of(music));
        ResponseEntity<?> response = musicController.findById(id);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof MusicDto);
        MusicDto musicDto = (MusicDto) response.getBody();
        assertEquals(music.getId(), musicDto.getId());
        assertEquals(music.getSong(), musicDto.getSong());
        verify(musicService).findbyId(id);
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        Long id = 1L;

        // When
        when(musicService.findbyId(id)).thenReturn(Optional.empty());
        ResponseEntity<?> response = musicController.findById(id);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(musicService).findbyId(id);
    }

    @Test
    void testFindAll() {
        // Given
        List<Music> musicList = DataProvider.musicListMock();
        
        // When
        when(musicService.findAll()).thenReturn(musicList);
        ResponseEntity<?> response = musicController.findAll();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verificación del cuerpo
        Object body = response.getBody();
        assertNotNull(body);
        assertTrue(body instanceof List<?>);

        // Cast seguro
        @SuppressWarnings("unchecked") // Suprimir advertencia de casting
        List<MusicDto> resultList = (List<MusicDto>) body;

        assertEquals(musicList.size(), resultList.size());
        verify(musicService).findAll();
    }

    @Test
    void testSave() throws Exception {
        // Given
        MusicDto musicDto = DataProvider.newMusicDtoMock();

        // When
        ResponseEntity<?> response = musicController.save(musicDto);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        
        ArgumentCaptor<Music> musicArgumentCaptor = ArgumentCaptor.forClass(Music.class);
        verify(musicService).save(musicArgumentCaptor.capture());
        
        assertEquals(musicDto.getSong(), musicArgumentCaptor.getValue().getSong());
    }
    
    @Test
    void testSaveWithBlankSong() throws Exception {
        // Given
        MusicDto musicDto = new MusicDto(null, "", "Artist", "Pop"); // Song está en blanco

        // When
        ResponseEntity<?> response = musicController.save(musicDto);

        // Then
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(musicService, never()).save(any()); // Verifica que save no se llamó
    }

    @Test
    void testUpdateMusic() {
        // Given
        Long id = 1L;
        Music existingMusic = DataProvider.musicMock();
        
        MusicDto updatedMusicDto = new MusicDto(id, "Updated Song", "Updated Artist", "Updated Genre");

        // When
        when(musicService.findbyId(id)).thenReturn(Optional.of(existingMusic));
        
        ResponseEntity<?> response = musicController.updateMusic(id, updatedMusicDto);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        verify(musicService).save(existingMusic);
        
        assertEquals(updatedMusicDto.getSong(), existingMusic.getSong());
    }

    @Test
    void testUpdateMusicNotFound() {
        // Given
        Long id = 1L;
        
        MusicDto updatedMusicDto = new MusicDto(id, "Updated Song", "Updated Artist", "Updated Genre");

        // When
        when(musicService.findbyId(id)).thenReturn(Optional.empty());
        
        ResponseEntity<?> response = musicController.updateMusic(id, updatedMusicDto);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testDeleteById() {
      // Given
      Long id = 1L;

      // When
      ResponseEntity<?> response = musicController.deleteById(id);

      // Then
      assertEquals(HttpStatus.OK, response.getStatusCode());
      verify(musicService).deleateById(id);
  }

    @Test
    void testDeleteByIdBadRequest() {
      // Given
      Long id = null;

      // When
      ResponseEntity<?> response = musicController.deleteById(id);

      // Then
      assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }
}