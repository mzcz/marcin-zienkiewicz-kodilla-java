package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks(){

        //given
        //creating library
        Library library = new Library("Library 1");

        //creating books
        IntStream.iterate(1,n -> n+1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("title " + n, "author " + n, LocalDate.now().minusDays(n))));

        //making a shallow copy of object library
        Library clonedlibrary = null;

        try {
            clonedlibrary = library.shallowCopy();
            clonedlibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object library
        Library cloneDeepLibrary = null;

        try {
            cloneDeepLibrary = library.deepCopy();
            cloneDeepLibrary.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().add(new Book("title 6", "author 6", LocalDate.now()));
        //Then
        System.out.println(library);
        System.out.println(clonedlibrary);
        System.out.println(cloneDeepLibrary);
        Assert.assertEquals(6, library.getBooks().size());
        Assert.assertEquals(6, clonedlibrary.getBooks().size());
        Assert.assertEquals(5, cloneDeepLibrary.getBooks().size());

        Assert.assertEquals(clonedlibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(cloneDeepLibrary.getBooks(), library.getBooks());
    }
}
