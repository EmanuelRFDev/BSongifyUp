package com.example.apirestsongifyup.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirestsongifyup.persistence.dao.IMusicDao;
import com.example.apirestsongifyup.persistence.entity.Music;
import com.example.apirestsongifyup.service.interfaces.IMusicService;

@Service
public class MusicServiceImpl implements IMusicService {
	
	@Autowired
	private IMusicDao musicDao;
	
	@Override
	public Optional<Music> findbyId(Long id) {
		return musicDao.findbyId(id);
	}

	@Override
	public List<Music> findAll() {
		return musicDao.findAll();
	}

	@Override
	public void save(Music music) {
		musicDao.save(music);
		
	}

	@Override
	public void deleateById(Long id) {
		musicDao.deleateById(id);
		
	}

}
