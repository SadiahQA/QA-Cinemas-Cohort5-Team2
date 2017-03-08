package com.qa.cinema.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

/**
 * 
 * @author Tary Andrews
 * @version 0.1.2
 *
 */

@ApplicationScoped
@Alternative
public class MapActorService implements ActorService {

	@Override
	public String getActorsFromMovie(String idMovie) {
		// TODO Auto-generated method stub
		return null;
	}




}
