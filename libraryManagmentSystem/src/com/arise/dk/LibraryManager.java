package com.arise.dk;

public class LibraryManager {
    Books books = new Books();

    // Add new book
    public void createBooks(int bookId, String name, String author, int copies) {
        for (Books x : books.listOfBooks) {
            if (x.getBookId() == bookId) {
                System.out.println("⚠ Book with this ID already exists!");
                return;
            }
        }
        Books book = new Books(bookId, name, author, copies);
        books.listOfBooks.add(book);
        System.out.println("✅ Book added successfully!");
    }

    // Show all books
    public void showListOfBooks() {
        if (!books.listOfBooks.isEmpty()) {
            for (Books x : books.listOfBooks) {
                System.out.println(x);
            }
        } else {
            System.out.println("⚠ No books available in the library.");
        }
    }

    // Borrow book
    public void borrowBook(String userName, int userId, int bookId, int copies) {
        User u = new User(userId, userName);

        Books found = null;
        for (Books x : books.listOfBooks) {
            if (x.getBookId() == bookId) {
                found = x;
                break;
            }
        }

        if (found == null) {
            System.out.println("⚠ Book not found with ID: " + bookId);
            return;
        }

        if (found.getCopiesAvailable() < copies) {
            System.out.println("⚠ Not enough copies. Available: " + found.getCopiesAvailable());
            return;
        }

        books.map.put(bookId, u); // overwrite allowed (1 bookId → 1 user for now)
        found.setCopiesAvailable(found.getCopiesAvailable() - copies);

        System.out.println("✅ Borrow successful: " + userName +
                " borrowed '" + found.getTitle() + "' (" + copies + " copies). Remaining: " + found.getCopiesAvailable());
    }

    // View borrowed books
    public void viewBorrowedBooksByUser() {
        if (!books.map.isEmpty()) {
            for (Integer bid : books.map.keySet()) {
                System.out.println("BookID: " + bid + " → " + books.map.get(bid));
            }
        } else {
            System.out.println("⚠ No borrowed books yet.");
        }
    }

    // Return book
    public void returnBooks(int bookId, int userId) {
        if (books.map.containsKey(bookId)) {
            User u = books.map.get(bookId);
            if (u.getUserId() == userId) {
                for (Books b : books.listOfBooks) {
                    if (b.getBookId() == bookId) {
                        b.setCopiesAvailable(b.getCopiesAvailable() + 1);
                        break;
                    }
                }
                books.map.remove(bookId);
                System.out.println("✅ Book returned successfully!");
            } else {
                System.out.println("⚠ User ID mismatch! This book was not borrowed by you.");
            }
        } else {
            System.out.println("⚠ No record found for BookID: " + bookId);
        }
    }
}
