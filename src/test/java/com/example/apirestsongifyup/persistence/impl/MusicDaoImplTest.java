package com.example.apirestsongifyup.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.apirestsongifyup.DataProvider;
import com.example.apirestsongifyup.persistence.entity.Music;

import com.example.apirestsongifyup.persistence.repository.MusicRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MusicDaoImplTest {
	
	 @Mock
	 private MusicRepository musicRepository;

	    @InjectMocks
	    private MusicDaoImpl musicDao;

	    @Test
	    void testFindAll() {
	        // When
	        when(musicRepository.findAll()).thenReturn(DataProvider.musicListMock());
	        List<Music> result = musicDao.findAll();

	        // Then
	        assertNotNull(result);
	        assertFalse(result.isEmpty());
	        assertEquals("Amour Plastique", result.get(0).getSong());
	        assertEquals("Matthieu Reynaud", result.get(0).getArtist());
	        verify(musicRepository).findAll();
	    }

	    @Test
	    void testFindById() {
	        // Given
	        Long id = 1L;

	        // When
	        when(musicRepository.findById(id)).thenReturn(Optional.of(DataProvider.musicMock()));
	        Optional<Music> music = musicDao.findbyId(id);

	        // Then
	        assertTrue(music.isPresent());
	        assertEquals("Amour Plastique", music.get().getSong());
	        assertEquals("Matthieu Reynaud", music.get().getArtist());
	        verify(musicRepository).findById(id);
	    }

	    @Test
	    void testSave() {
	        // Given
	        Music music = DataProvider.newMusicMock();

	        // When
	        musicDao.save(music);

	        // Then
	        ArgumentCaptor<Music> musicArgumentCaptor = ArgumentCaptor.forClass(Music.class);
	        verify(musicRepository).save(musicArgumentCaptor.capture());
	        assertEquals("You'll Never Walk Alone", musicArgumentCaptor.getValue().getSong());
	        assertEquals("Gerry & The Pacemakers", musicArgumentCaptor.getValue().getArtist());
	    }

	    @Test
	    void testDeleteById() {
	        // Given
	        Long id = 1L;

	        // When
	        musicDao.deleateById(id);

	        // Then
	        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
	        verify(musicRepository).deleteById(longArgumentCaptor.capture());
	        assertEquals(1L, longArgumentCaptor.getValue());
	    }

}
