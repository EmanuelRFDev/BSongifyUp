package com.example.apirestsongifyup.persistence.dao;

import java.util.List;
import java.util.Optional;

import com.example.apirestsongifyup.persistence.entity.Music;


public interface IMusicDao {
	
	Optional <Music> findbyId(Long id);
	
	List<Music> findAll();
	
	void save(Music music);
	
	void deleateById(Long id);

}
