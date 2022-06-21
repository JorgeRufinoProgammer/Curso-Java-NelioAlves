package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Comment;
import entities.Post;

public class TestaPostMelhorado {

	public static void main(String[] args) {
		List<Post> postsList = new ArrayList<>();
		
		int n = Util.inputInt("Quantos posts?");
		
		for (int i = 0; i < n; i++) {
			Date moment = new Date();
			String title = Util.inputString("What title?"+" #"+(i+1));
			String content = Util.inputString("What content?"+" #"+(i+1));
			int likes = Util.inputInt("How many likes?"+" #"+(i+1));
			
			Post post = new Post(moment, title, content, likes);
			
			int m = Util.inputInt("Quantos comments?");
			
			for (int j = 0; j < m; j++) {
				Comment comment = new Comment(Util.inputString("What comment #"+j+"? Post #"+(i+1)));
				post.setComment(comment);
			}
			
			postsList.add(post);
		}
		
		for (Post post : postsList) {
			System.out.println(post);			
		}
		

	}

}
