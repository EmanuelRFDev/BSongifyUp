package com.example.apirestsongifyup.presentation.dto;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MusicDtoTest {

    @Test
    void testNoArgsConstructor() {
        // When
        MusicDto musicDto = new MusicDto();

        // Then
        assertNull(musicDto.getId());
        assertNull(musicDto.getSong());
        assertNull(musicDto.getArtist());
        assertNull(musicDto.getGender());
    }

    @Test
    void testAllArgsConstructor() {
        // Given
        Long id = 1L;
        String song = "Amour Plastique";
        String artist = "Matthieu Reynaud";
        String gender = "Pop";

        // When
        MusicDto musicDto = new MusicDto(id, song, artist, gender);

        // Then
        assertNotNull(musicDto);
        assertEquals(id, musicDto.getId());
        assertEquals(song, musicDto.getSong());
        assertEquals(artist, musicDto.getArtist());
        assertEquals(gender, musicDto.getGender());
    }
    
    @Test
    void testGettersySetters() {
        // Given
        MusicDto musicDto = new MusicDto();
        
        // When
        musicDto.setId(1L);
        musicDto.setSong("Amour Plastiques");
        musicDto.setArtist("Matthieu Reynauds");
        musicDto.setGender("Pops");
        
        // Then
        assertEquals(1L, musicDto.getId());
        assertEquals("Amour Plastiques", musicDto.getSong());
        assertEquals("Matthieu Reynauds", musicDto.getArtist());
        assertEquals("Pops", musicDto.getGender());
    }

    @Test
    void testBuilder() {
        // Given
        Long id = 1L;
        String song = "Amour Plastique";
        String artist = "Matthieu Reynaud";
        String gender = "Pop";
        

        // When
        MusicDto musicDto = MusicDto.builder()
                .id(id)
                .song(song)
                .artist(artist)
                .gender(gender)
                .build();

        // Then
        assertNotNull(musicDto);
        assertEquals(id, musicDto.getId());
        assertEquals(song, musicDto.getSong());
        assertEquals(artist, musicDto.getArtist());
        assertEquals(gender, musicDto.getGender());
    }
    
}

