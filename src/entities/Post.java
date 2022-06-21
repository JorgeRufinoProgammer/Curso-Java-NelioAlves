package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private String title, content;
	private int likes;
	
	private List<Comment> comment = new ArrayList<>();
	
	public Post() {}

	public Post(Date moment, String title, String content, int likes) {		
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	@Override		// Metodo criado pelo professor
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title + "\n");
		sb.append(likes);
		sb.append(" Likes - ");
		sb.append(sdf.format(moment) + "\n");
		sb.append(content + "\n");
		sb.append("Comments:\n");
		for (Comment c : comment) {
			sb.append(c.getText() + "\n");
		}
		return sb.toString();
	}
	/*
	@Override Metodo que eu criei
	public String toString() {		
		String data = sdf.format(moment);
		String texto = title
				+"\n"+likes + " Likes"
				+" - " + data
				+"\n"+content
				+"\nComments:"
				+"\n" ;
		for (Comment c : comment) {
			texto += c.getText()+"\n";			
		}
		return texto;
	}
	*/
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment.add(comment);
	}
	
}
