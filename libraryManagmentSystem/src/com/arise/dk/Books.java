package com.arise.dk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Books {
    private int bookId;
    private String title;
    private String author;
    private int copiesAvailable;

    // Global storage of books + borrow map
    List<Books> listOfBooks = new ArrayList<>();
    Map<Integer, User> map = new HashMap<>();

    public Books() {
    }

    public Books(int bookId, String title, String author, int copiesAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    @Override
    public String toString() {
        return "BookID=" + bookId +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", CopiesAvailable=" + copiesAvailable;
    }
}
