package com.qa.cinema.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import com.qa.cinema.persistence.Movie;

/**		
 * @author Sadiah Ahmed		
 * @version 0.0.1		
 * @since 08/03/2017		
 *		
 */

@ApplicationScoped
@Alternative
public class MapShowingService implements ShowingService {
	
	@Override
	public String getAllShowingsForMovie(Movie movie) {
		return null;
	}
}
