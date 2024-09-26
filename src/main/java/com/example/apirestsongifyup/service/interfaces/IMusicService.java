package com.example.apirestsongifyup.service.interfaces;


import java.util.List;
import java.util.Optional;

import com.example.apirestsongifyup.persistence.entity.Music;

public interface IMusicService {
	
	
	Optional <Music> findbyId(Long id);
	
	List<Music> findAll();
	
	void save(Music music);
	
	void deleateById(Long id);
	
}
