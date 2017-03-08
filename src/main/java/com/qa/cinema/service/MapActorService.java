package com.qa.cinema.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

/**
 * 
 * @author Tary Andrews
 * @version 0.1.3
 *
 */

@ApplicationScoped
@Alternative
public class MapActorService implements ActorService {

	@Override
	public String getActor(String idActor) {
		// TODO Auto-generated method stub
		return null;
	}




}
