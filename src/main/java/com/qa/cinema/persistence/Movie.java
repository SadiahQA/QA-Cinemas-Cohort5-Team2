package com.qa.cinema.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Alex Mercer
 * @version 0.1.1
 */
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMovie;
	private String title;
	private String genre;
	private String posterURL;
	private String duration;
	private String releaseDate;
	private String certification;
	private String description;
	
	@ManyToMany
    @JoinTable(name="Actor_has_Movie",
        joinColumns=
            @JoinColumn(name="Movie_idMovie"),
        inverseJoinColumns=
            @JoinColumn(name="Actor_idActor")
        )
	private List<Actor> actors;

	public Movie() {
	}

	public Movie(String title, String genre, String posterURL, String duration, String releaseDate,
			String certification, String description, ArrayList<Actor> actors) {
		this.title = title;
		this.genre = genre;
		this.posterURL = posterURL;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.certification = certification;
		this.description = description;
		this.actors = actors;
	}



	public Long getId() {
		return idMovie;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPosterURL() {
		return posterURL;
	}

	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Actor> getActors() {
		return actors;
	}

	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}
	
}
