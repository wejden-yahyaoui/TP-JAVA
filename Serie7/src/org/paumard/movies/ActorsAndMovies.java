package org.paumard.movies;

import org.paumard.movies.model.Actor;
import org.paumard.movies.model.Movie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;


public class ActorsAndMovies {

    public static void main(String[] args) {

        ActorsAndMovies actorsAndMovies = new ActorsAndMovies();
        Set<Movie> movies = actorsAndMovies.readMovies();
        
        //Question 1 : number of films 
        System.out.println("Question 1 : ");
        System.out.println("movies.size()) = " + movies.size());
        
        //Question 2 : number of actors
        List <Actor> actors = 
        		movies.stream()
        		.flatMap(movie -> movie.actors()
        		.stream())
        		.collect(Collectors.toList());
        System.out.println("\n Question 2 : ");
        System.out.println("number of actors = " +actors.size());
        
        
      //check for duplicates
        Set <Actor> actors1= 
        		movies.stream()
        		.flatMap(movie -> movie.actors()
        		.stream())
        		.collect(Collectors.toSet());
        System.out.println("number of actors without duplicates = " +actors1.size());
       
        
        //check for duplicates
       
        Long NumberOfActors = movies.stream()
			        		.flatMap(movie -> movie.actors()
			        		.stream())
			        		.distinct()
			        		.count();
        System.out.println("count actors = " +NumberOfActors);
        
        
        //Question 3 
        
        Long NumberOfyears = 
        		movies.stream()
        		.map(movie -> movie.releaseYear())
        		.distinct()
        		.count(); 
        
        System.out.println("\n Question 3 : ");
        System.out.println("number of years = " +NumberOfyears);
        
        
        //Question 4.1
        Integer latest = 
        		movies.stream()
        		.map(movie -> movie.releaseYear())
        		.max(Integer::compare).get();
        
        System.out.println("\n Question 4 : ");
        System.out.println("Year of the latest movie  = " + latest);
        
        
        //Question 4.2
        Integer old = 
        		movies.stream()
        		.map(movie -> movie.releaseYear())
        		.min(Integer::compare).get();
        
        System.out.println("Year of the oldest movie  = " +old);
        
        
        //Question 5 
        Map <Integer, Long> mapp = 
        		movies.stream()
        		.map(movie -> movie.releaseYear())
        		.collect(Collectors.groupingBy(
        				Function.identity(),
        				Collectors.counting()));
        Map.Entry<Integer, Long> year = 
        		mapp.entrySet()
        		.stream()
        		.max(Map.Entry.comparingByValue())
        		.orElseThrow();
        
        System.out.println("\n Question 5 : ");
        System.out.println("Year = "+ year);
        
        
        
        
        
        
        //Question 6 : Movie with max of actors
        
       int maxActors=  movies.stream()
						        .mapToInt(movie -> movie.actors().size())
						        .max()
						        .orElseThrow();
       
       System.out.println("\n Question 6 : ");
       System.out.println("Max actors  = " +maxActors);
       
       
       Comparator <Movie> comparator=
       		Comparator.comparing(movie -> movie.actors().size());
       
      Movie movieWithMaxActors=  
				    		  movies.stream()
				    		  .max(comparator)
				    		  .orElseThrow();
     
      System.out.println("Movie with Max Actors = " + movieWithMaxActors );
      System.out.println("Max actors  = " +movieWithMaxActors.actors().size());
        
       
     //Question 7 : actor who has appeared in most films
      
       Map<Actor, Long> map = 
        movies.stream()
        	.flatMap(movie -> movie.actors().stream())
        	.collect(
        			Collectors.groupingBy(
        					Function.identity(),
        					Collectors.counting()));
        
        
        Map.Entry<Actor, Long> entry = 
        		map.entrySet().stream()
		        .max(Comparator.comparing(Map.Entry::getValue))
		        .orElseThrow();
        
        
        System.out.println("\n Question 7 : ");
        System.out.println("The actor who has appeard in most films "+ entry);
        
        
        //Question 8 
        
        Map.Entry<Actor, Long> maxEntry = 
                movies.stream()
                	.flatMap(movie -> movie.actors().stream())
                	.collect(
                			Collectors.groupingBy(
                					Function.identity(),
                					Collectors.counting()))
                	.entrySet().stream()
        		    .max(Comparator.comparing(Map.Entry::getValue))
        		    .orElseThrow();
        
        System.out.println("\n Question 8 : ");
        System.out.println("Max entry = "+ maxEntry);
        
        Map.Entry<Actor, Long> maxEntry2 =  movies.stream()
	    	.collect(
	    			Collectors.collectingAndThen(
	    			Collectors.flatMapping(
	    					movie -> movie.actors().stream(),
	    			Collectors.groupingBy(
	    					Function.identity(),
	    					Collectors.counting())),
	    			
	    	m -> m.entrySet().stream()
	    					.max(Comparator.comparing(Map.Entry::getValue))
	    					.orElseThrow())
	    			);

        System.out.println("Max entry 2 = "+ maxEntry2);
       
        
       Map<Integer, Entry<Actor, Long>> mapPerYear=  movies.stream()
        		.collect(
        				
        				Collectors.groupingBy(
        						Movie::releaseYear,
        						Collectors.collectingAndThen(
        		    			Collectors.flatMapping(
        		    					movie -> movie.actors().stream(),
        		    			Collectors.groupingBy(
        		    					Function.identity(),
        		    					Collectors.counting())),
        		    			
        		    	m -> m.entrySet().stream()
        		    					.max(Comparator.comparing(Map.Entry::getValue))
        		    					.orElseThrow()))
        		);
      
       
       Entry<Integer, Entry <Actor , Long>> entry2 = mapPerYear.entrySet()
        .stream()
        .max(Comparator.comparing(e -> e.getValue().getValue()))
        .orElseThrow();
       
       System.out.println("entry 2= "+ entry2);
        

    }

    public Set<Movie> readMovies() {

        Function<String, Stream<Movie>> toMovie =
                line -> {
                    String[] elements = line.split("/");
                    String title = elements[0].substring(0, elements[0].lastIndexOf("(")).trim();
                    String releaseYear = elements[0].substring(elements[0].lastIndexOf("(") + 1, elements[0].lastIndexOf(")"));
                    if (releaseYear.contains(",")) {
                        // Movies with a coma in their title are discarded
                    	int indexOfComa = releaseYear.indexOf(",");
                    	releaseYear = releaseYear.substring(0,indexOfComa);
                        //return Stream.empty();
                    }
                    Movie movie = new Movie(title, Integer.valueOf(releaseYear));


                    for (int i = 1; i < elements.length; i++) {
                        String[] name = elements[i].split(", ");
                        String lastName = name[0].trim();
                        String firstName = "";
                        if (name.length > 1) {
                            firstName = name[1].trim();
                        }

                        Actor actor = new Actor(lastName, firstName);
                        movie.addActor(actor);
                    }
                    return Stream.of(movie);
                };

        try (FileInputStream fis = new FileInputStream("files/movies-mpaa.txt.gz");
             GZIPInputStream gzis = new GZIPInputStream(fis);
             InputStreamReader reader = new InputStreamReader(gzis);
             BufferedReader bufferedReader = new BufferedReader(reader);
             Stream<String> lines = bufferedReader.lines();
        ) {

            return lines.flatMap(toMovie).collect(Collectors.toSet());

        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        return Set.of();
    }
}
