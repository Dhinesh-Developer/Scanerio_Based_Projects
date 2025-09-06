package com.dk;

import java.util.ArrayList;
import java.util.List;

public class Mail {
	
	private String sender;
	private String receiver;
	private String subject;
	private String content;
	private List<String> tags;
	private boolean isSpam;
	
	
	public Mail(String sender, String receiver, String subject, String content) {
	    super();
	    this.sender = sender;
	    this.receiver = receiver;
	    this.subject = subject;
	    this.content = content;  
	    this.tags = new ArrayList<>();
	    this.isSpam = false;
	}



	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public List<String> getTags() {
		return tags;
	}


	public void setTags(List<String> tags) {
		this.tags = tags;
	}


	public boolean isSpam() {
		return isSpam;
	}


	public void setSpam(boolean isSpam) {
		this.isSpam = isSpam;
	}
	

	@Override
	public String toString() {
		return "Mail [sender=" + sender +"\n" +", receiver=" + receiver +"\n" + ", subject=" + subject +"\n" + ", content=" + content
				+"\n" + ", tags=" + tags +"\n" + ", isSpam=" + isSpam + "]"+"\n" ;
	}
	
	public void addTag(String tag) {
		if(!tag.contains(tag)) {
			tags.add(tag);
		}
	}
	
	public void removeTag(String tag) {
		tags.remove(tag);
	}
	
	
	
	
	
}
