/**
 * 
 * @author Gabriel O'Donnell
 * This class exists to test our doubly linked list class with a 
 * user defined object. 
 */
public class Movie {
	private String title;
	private String director_name;
	private int release_year;
	
	
	//default constructor
	public Movie() {
		title = "";
		director_name = "";
		release_year = 0;
	}
	
	public Movie(String t, String dn, int ry) {
		title = t;
		director_name = dn;
		release_year = ry;
	}
	//copy constructor
	public Movie(Movie obj) {
		title= obj.getTitle();
		director_name = obj.getDirectorName();
		release_year = obj.getReleaseYear();
		
	}
	/**
	 * returns the title of the movie
	 * @return the movie title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * returns the director's name of the movie
	 * @return the director's name
	 */
	public String getDirectorName() {
		return director_name;
	}
	/**
	 * returns the release year of a movie
	 * @return the release year 
	 */
	public int getReleaseYear() {
		return release_year;
	}
	
	/**
	 * This function overrides the toString() function and
	 * allows the object to be printed into a string in a simple way.
	 */
	@Override
	public String toString() {
		return title +" By: " + director_name + " In-" + release_year;
		
	}
	
	/**
	 * This allows for comparisons between movie objects
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
            return false;
        }
		
		Movie other = (Movie) obj;
		if(this.title == other.getTitle()) {
			return true;
		}
		
		
		return false;
		
	}
	
	
	
}
