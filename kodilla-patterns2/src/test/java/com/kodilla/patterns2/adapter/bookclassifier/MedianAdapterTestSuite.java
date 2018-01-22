package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest(){

        //Given
        Book book1 = new Book("John Smith","test1",2011,"8787897894443");
        Book book2 = new Book("Ivone Nowak","test2",2001,"8478943784377843");
        Book book3 = new Book("Jessie Piknman","test3",1980,"9832993789443");
        Book book4 = new Book("Walter White","test4",2015,"298298937897");
        Book book5 = new Book("Steve Newmack","test5",1997,"123324344555");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);;
        bookSet.add(book4);
        bookSet.add(book5);

        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int medianBook  = medianAdapter.publicationYearMedian(bookSet);
        //Then
        System.out.println("Median for books is: " +  medianBook);
        assertEquals(medianBook, 2001);
    }
}
