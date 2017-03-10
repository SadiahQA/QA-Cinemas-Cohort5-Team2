package com.qa.cinema.service;

import com.qa.cinema.persistence.Movie;

/**		
 * @author Sadiah Ahmed		
 * @version 0.0.2		
 * @since 08/03/2017		
 *		
 */

public interface ShowingService {
	
	String getAllShowingsForMovie(String idMovie);
}
