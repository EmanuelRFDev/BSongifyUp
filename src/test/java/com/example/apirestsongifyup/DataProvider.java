package com.example.apirestsongifyup;

import java.util.List;

import com.example.apirestsongifyup.persistence.entity.Music;
import com.example.apirestsongifyup.presentation.dto.MusicDto;

public class DataProvider {

    public static List<Music> musicListMock() {
        return List.of(
                new Music(1L, "Amour Plastique", "Matthieu Reynaud", "Electropop",null,null,null),
                new Music(2L, "See You Again", "Wiz Khalifa", "Hip Hop",null,null,null),
                new Music(3L, "Blinding Lights", "The Weeknd","Synthwave",null,null,null)
                
        );
    }

    public static Music musicMock() {
        return new Music(4L, "Amour Plastique", "Matthieu Reynaud", "Electropop", null, null,null);
    }

    public static Music newMusicMock() {
        return new Music(4L, "You'll Never Walk Alone", "Gerry & The Pacemakers", "Pop", null, null,null);
    }
    
    public static MusicDto newMusicDtoMock() {
        return new MusicDto(4L, "You'll Never Walk Alone", "Gerry & The Pacemakers", "Pop");
    }
    
}
