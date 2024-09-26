package com.example.apirestsongifyup.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.apirestsongifyup.persistence.dao.IMusicDao;
import com.example.apirestsongifyup.persistence.entity.Music;
import com.example.apirestsongifyup.persistence.repository.MusicRepository;

@Component
public class MusicDaoImpl implements IMusicDao{
	
    @Autowired
	private MusicRepository musicRepository;
	
	@Override
	public Optional<Music> findbyId(Long id) {
		return musicRepository.findById(id);
	}

	@Override
	public List<Music> findAll() {
		return (List<Music>) musicRepository.findAll();
	}

	@Override
	public void save(Music music) {
		musicRepository.save(music);
		
	}

	@Override
	public void deleateById(Long id) {
		musicRepository.deleteById(id);
		
	}

}
