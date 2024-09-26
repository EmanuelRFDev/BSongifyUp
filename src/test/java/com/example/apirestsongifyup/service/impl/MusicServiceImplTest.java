package com.example.apirestsongifyup.service.impl;

import com.example.apirestsongifyup.DataProvider;
import com.example.apirestsongifyup.persistence.dao.IMusicDao;
import com.example.apirestsongifyup.persistence.entity.Music;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MusicServiceImplTest {

    @Mock
    private IMusicDao musicDao;

    @InjectMocks
    private MusicServiceImpl musicService;

    @Test
    void testFindAll() {
        // When
        when(musicDao.findAll()).thenReturn(DataProvider.musicListMock());
        List<Music> result = musicService.findAll();

        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals("Amour Plastique", result.get(0).getSong());
        assertEquals("Matthieu Reynaud", result.get(0).getArtist());
        verify(musicDao).findAll();
    }

    @Test
    void testFindById() {
        // Given
        Long id = 1L;

        // When
        when(musicDao.findbyId(id)).thenReturn(Optional.of(DataProvider.musicMock()));
        Optional<Music> music = musicService.findbyId(id);

        // Then
        assertTrue(music.isPresent());
        assertEquals("Amour Plastique", music.get().getSong());
        assertEquals("Matthieu Reynaud", music.get().getArtist());
        verify(musicDao).findbyId(id);
    }

    @Test
    void testSave() {
        // Given
        Music music = DataProvider.newMusicMock();

        // When
        musicService.save(music);

        // Then
        ArgumentCaptor<Music> musicArgumentCaptor = ArgumentCaptor.forClass(Music.class);
        verify(musicDao).save(musicArgumentCaptor.capture());
        assertEquals("You'll Never Walk Alone", musicArgumentCaptor.getValue().getSong());
        assertEquals("Gerry & The Pacemakers", musicArgumentCaptor.getValue().getArtist());
    }

    @Test
    void testDeleteById() {
        // Given
        Long id = 1L;

        // When
        musicService.deleateById(id);

        // Then
        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(musicDao).deleateById(longArgumentCaptor.capture());
        assertEquals(1L, longArgumentCaptor.getValue());
    }
}
