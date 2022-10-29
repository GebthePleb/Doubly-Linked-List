import java.util.ArrayList;
/**
 * 
 * @author Gabriel O'Donnell
 * This is a driver function for my linked list class. This is simply so I can show
 * how it works and use all of its different functions.
 *
 */
public class ListDriver {

	public static void main(String[] args) {
		DoublyLinkedList<Movie> movCollection= new DoublyLinkedList<Movie>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//Make our data pieces
		Movie a = new Movie("Avengers", "Joss Whedon", 2012);
		Movie b = new Movie("Pulp Fiction", "Quentin Tarantino", 1994);
		Movie c = new Movie("Spider-man: Into the Spider-Verse", "Peter Ramsey", 2018);
		Movie d = new Movie("Cats", "Tom Hopper", 2019);
		Movie f = new Movie("Amsterdam", "David O. Russell", 2022);
		Movie g = new Movie("1917", "Sam Mendes", 2019);
		Movie h = new Movie("Top Gun: Maverick", "Joseph Kosinski", 2022);
		Movie i = new Movie("Smile", "Parker Finn", 2022);
		Movie j = new Movie("Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2001);
		Movie k = new Movie("Rogue One: A Star Wars Story", "Gareth Edwards", 2016);
		
		//add to the list
		movCollection.push_back(a);
		movCollection.push_back(b);
		movCollection.push_back(c);
		movCollection.push_back(d);
		movCollection.push_back(f);
		movCollection.push_back(g);
		movCollection.push_back(h);
		movCollection.push_back(i);
		movCollection.push_back(j);
		movCollection.push_back(k);
		
		//print list
		movCollection.displayList();
		
		
		//Show the copy constructor
		System.out.println();
		System.out.println("Copy:  ");
		DoublyLinkedList<Movie> myMovCollection= new DoublyLinkedList<Movie>(movCollection);
		myMovCollection.displayList();
		System.out.println();
		
		//Print into reverse
		System.out.println("Reverse: ");
		
		myMovCollection.reverse();
		myMovCollection.displayList();
		System.out.println();
		System.out.println("Original: ");
		
		movCollection.displayList();
		System.out.println();
		System.out.println();
		
		
		
		//Searching for Smile
		result = movCollection.searchItem(i);
		System.out.print("Resulting Array: ");
		if(result.size()==0) {
			System.out.println("Not in Array");
		}
		
		else {
			for(int index = 0; index < result.size(); index++) { //go through the list
				System.out.print(result.get(index)+ " ");
			}
		}
		
		System.out.println();
		System.out.println();
		
		movCollection.deleteItem(a);
		System.out.println();
		System.out.println();
		movCollection.displayList();
		
		
	}

}
