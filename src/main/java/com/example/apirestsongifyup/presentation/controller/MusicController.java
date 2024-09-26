package com.example.apirestsongifyup.presentation.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirestsongifyup.persistence.entity.Music;
import com.example.apirestsongifyup.presentation.dto.MusicDto;
import com.example.apirestsongifyup.service.interfaces.IMusicService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


//restcontroler y rwquest (api/music/
@RestController
@RequestMapping("/api/music")

@Tag(name = "Music", description = "Controller for Music")
public class MusicController {
	
	@Autowired 
	private IMusicService musicService;
	
	@Operation(
	        summary = "Find Music by ID",
	        description = "Retrieve music using the ID.",
	        tags = {"Music"},
	        parameters = @Parameter(
	                name = "id",
	                description = "ID of the music to retrieve",
	                required = true,
	                in = ParameterIn.PATH,
	                schema = @Schema(type = "integer")
	        ),
	        responses = {
	                @ApiResponse(
	                        responseCode = "200",
	                        description = "Music found",
	                        content = @Content(
	                                mediaType = "application/json",
	                                schema = @Schema(implementation = MusicDto.class)
	                        )
	                ),
	                @ApiResponse(
	                        responseCode = "404",
	                        description = "Music not found"
	                )
	        }
	)
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Music> musicOptional = musicService.findbyId(id);
		
		//validar si esta preente 
		if(musicOptional.isPresent()) {
			Music music = musicOptional.get();
			// Tedios conversion music a music dto pero mejr practica, libreria hace esto strum mapear automatico evitando forma manual 
			// convirtiendo dto 
			MusicDto musicDto = MusicDto.builder()
					// extraer atributos entity y setear dto
					.id(music.getId())
					.song(music.getSong())
					.artist(music.getArtist())
					.gender(music.getGender())
					.build();
				// repsonseentity ok y enviar dto se lo encuentra
				return ResponseEntity.ok(musicDto); 
			}
		// Si no lo encuentra *proque build
			return ResponseEntity.notFound().build();
		}
	
	@Operation(
	        summary = "Find All Music",
	        description = "Retrieve a list of all music.",
	        tags = {"Music"},
	        
	        responses = {
	        		@ApiResponse(
	                        responseCode = "200",
	                        description = "Music deleted successfully",
	                        content = @Content
	                ),
	                @ApiResponse(
	                        responseCode = "400",
	                        description = "Invalid ID supplied",
	                        content = @Content(
	                        		mediaType = "application/json"
	                        )
	                        
	                )     
	                
	        }
	)
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll(){
		
		List<MusicDto> musicList = musicService.findAll()
			.stream() // no importar si aun no se termina 
			.map(music -> MusicDto.builder() // Problemas nombara igyakq ue mi clase 
					.id(music.getId())
					.song(music.getSong())
					.artist(music.getArtist())
					.gender(music.getGender())
					.build())
			.toList(); 
			return ResponseEntity.ok(musicList); // y enviar el musiclist 
	}
	
	@Operation(
	        summary = "Save Music",
	        description = "Add a new music.",
	        tags = {"Music"},
	        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
	                description = "Music data to be saved",
	                required = true,
	                content = @Content(
	                        mediaType = "application/json",
	                        schema = @Schema(implementation = MusicDto.class)
	                )
	        ),
	        responses = {
	                @ApiResponse(
	                        responseCode = "201",
	                        description = "Music record created"
	                ),
	                @ApiResponse(
	                        responseCode = "400",
	                        description = "Invalid input"
	                )
	        }
	)
	
	@PostMapping("/save") // importar metotdos
	public ResponseEntity<?> save(@RequestBody MusicDto musicDto) throws URISyntaxException{
		
		if(musicDto.getSong().isBlank()) {
			return ResponseEntity.badRequest().build();
		}
		
		musicService.save(Music.builder()
					.song(musicDto.getSong())
					.artist(musicDto.getArtist())
					.gender(musicDto.getGender())
					.build()); //solao amndar nmbre id automatco y lista productos o inetresa
		return ResponseEntity.created(new URI("/api/music/save")).build();
	}
	
	@Operation(
	        summary = "Update Music",
	        description = "Update an existing music record.",
	        tags = {"Music"},
	        parameters = @Parameter(
	                name = "id",
	                description = "ID of the music to update",
	                required = true,
	                in = ParameterIn.PATH,
	                schema = @Schema(type = "integer")
	        ),
	        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
	                description = "Updated music data",
	                required = true,
	                content = @Content(
	                        mediaType = "application/json",
	                        schema = @Schema(implementation = MusicDto.class)
	                )
	        ),
	        responses = {
	                @ApiResponse(
	                        responseCode = "200",
	                        description = "Music record updated"
	                ),
	                @ApiResponse(
	                        responseCode = "404",
	                        description = "Music not found"
	                )
	        }
	)
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateMusic(@PathVariable Long id, @RequestBody MusicDto musicDto) {
			
		Optional<Music> musicOptional = musicService.findbyId(id);
		
		if(musicOptional.isPresent()){
			Music music = musicOptional.get();
			music.setSong(musicDto.getSong());
			music.setArtist(musicDto.getArtist());
			music.setGender(musicDto.getGender());
			musicService.save(music);
			return ResponseEntity.ok().body("Registro Actualizado");
		}
		return ResponseEntity.notFound().build();
	}
	
	@Operation(
	        summary = "Delete Music by ID",
	        description = "Remove a music record using its ID.",
	        tags = {"Music"},
	        parameters = @Parameter(
	                name = "id",
	                description = "ID of the music to delete",
	                required = true,
	                in= ParameterIn.PATH,
	                schema=@Schema(type="integer")
	        ),
	        responses = {
	                @ApiResponse(
	                        responseCode = "200",
	                        description = "Music deleted successfully",
	                        content = @Content
	                ),
	                @ApiResponse(
	                        responseCode = "400",
	                        description = "Invalid ID supplied",
	                        content = @Content
	                )
	        }
	)
		
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
			
		if(id != null) {
			musicService.deleateById(id);
			return ResponseEntity.ok().body("Registro Eliminado");
		}
		return ResponseEntity.badRequest().build();
	}
}
