package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<Book>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        // to przypisanie jest niepotrzebne,
        // bo poza metodą ta zmienna jest i tak niewidoczna,
        // więc wystarczy: return resultList, zamiast przypisywac pod bookList.
        //bookList = resultList;
        return resultList;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser){
        return  libraryDatabase.listBooksInHandsOf(libraryUser);
    }
}