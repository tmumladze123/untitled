package models;

import java.util.ArrayList;

public class CreateUserSuccess {
    String userID;
    String username;
    ArrayList[] books;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList[] getBooks() {
        return books;
    }

    public void setBooks(ArrayList[] books) {
        this.books = books;
    }
}
