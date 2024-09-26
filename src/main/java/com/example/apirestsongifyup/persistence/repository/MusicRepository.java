package com.example.apirestsongifyup.persistence.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.apirestsongifyup.persistence.entity.Music;




public interface MusicRepository extends CrudRepository<Music,Long>{
	
}
