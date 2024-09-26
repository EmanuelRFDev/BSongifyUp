package com.example.apirestsongifyup.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Entity
@Table(name = "musica")
public class Music {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column ( name="cancion")
	private String song;
	
	@Column ( name="artista")
	private String artist;
	
	@Column ( name="genero")
	private String gender;
	
	//Relacion uno a unpo 
	@OneToOne(targetEntity = Album.class, fetch = FetchType.LAZY, mappedBy= "music", orphanRemoval = true)
	@JsonIgnore
	private Album album;
	
    // Relación OneToMany con Nominaciones
    @OneToMany(targetEntity = Nomination.class, fetch = FetchType.LAZY, mappedBy= "music", orphanRemoval = true)
    @JsonIgnore
    private List<Nomination> nominaciones;

    // Relación ManyToMany con Éxitos
    @ManyToMany(targetEntity = Hit.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "musica_exitos", joinColumns = @JoinColumn(name = "id_musica"), inverseJoinColumns = @JoinColumn(name = "id_exitos"))
    @JsonIgnore
    private List<Hit> hits;
}

