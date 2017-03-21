package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MovieTest {
	
	List<Actor> actorlist = Arrays.asList(
			new Actor("FirstName","LastName","Gender","DOB"),
			new Actor("FirstName2","LastName2","Gender2","DOB2")
			);
	Movie movie1 = new Movie("Title","Genre","URL", "Duration",new Date(2017, 12, 12),"Cert","description", actorlist);
	
	@Test
	public void testGetId(){
		assertNull(movie1.getId());
	}
	
	@Test
	public void testGetTitle(){
		assertTrue(movie1.getTitle().equals("Title"));
	}
	
	@Test
	public void testSetTitle() {
		Movie testmovie = new Movie();
		testmovie.setTitle("Test");
		assertTrue(testmovie.getTitle().equals("Test"));
	}
	
	@Test
	public void testGetGenre(){
		assertTrue(movie1.getGenre().equals("Genre"));
	}
	
	@Test
	public void testSetGenre() {
		Movie testmovie = new Movie();
		testmovie.setGenre("Test");
		assertTrue(testmovie.getGenre().equals("Test"));
	}
	
	@Test
	public void testGetPosterURL(){
		assertTrue(movie1.getPosterURL().equals("URL"));
	}
	
	@Test
	public void testSetPosterURL() {
		Movie testmovie = new Movie();
		testmovie.setPosterURL("Test");
		assertTrue(testmovie.getPosterURL().equals("Test"));
	}
	
	@Test
	public void testGetDuration(){
		assertTrue(movie1.getDuration().equals("Duration"));
	}
	
	@Test
	public void testSetDuration() {
		Movie testmovie = new Movie();
		testmovie.setDuration("Test");
		assertTrue(testmovie.getDuration().equals("Test"));
	}
	
	@Test
	public void testGetReleaseDate(){
		assertTrue(movie1.getReleaseDate().equals(new Date(2017, 12, 12)));
	}
	
	@Test
	public void testSetReleaseDate() {
		Movie testmovie = new Movie();
		testmovie.setReleaseDate(new Date(2017, 01, 01));
		assertTrue(testmovie.getReleaseDate().equals(new Date(2017, 01, 01)));
	}
}
