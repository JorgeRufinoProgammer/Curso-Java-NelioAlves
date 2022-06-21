package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class TestaPost {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Post post1 = new Post(sdf.parse("21/06/2018 13:05:44"),
										"Traveling to New Zealand",
										"I'm going to visit this wonderful country!" 
										,12);
		
		Comment c1 = new Comment("Have a nice trip");
		Comment c2 = new Comment("Wow that's awesome!");
		
		post1.setComment(c1);
		post1.setComment(c2);
		
		Post post2 = new Post(sdf.parse("28/07/2018 23:14:19"),
										"Good night guys",
										"See you tomorrow" 
										,5);
		
		Comment c3 = new Comment("Good night");
		Comment c4 = new Comment("May the Force be with you");
		
		post2.setComment(c3);
		post2.setComment(c4);
		
		System.out.println(post1);
		System.out.println(post2);
		
		sc.close();

	}

}
