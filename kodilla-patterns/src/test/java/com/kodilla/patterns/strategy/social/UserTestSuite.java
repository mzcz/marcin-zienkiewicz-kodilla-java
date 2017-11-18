package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTestSuite {
    private static int i;

    @Before
    public void test(){
        i++;
        System.out.println("#Test number " + i);
    }

    @Test
    public void testDefaultSharingStrategies(){
        //Given
        User marcin = new Millenials("Marcin Zienkiewicz");
        User zenon = new YGeneration("Zenon Kopydłowski");
        User marian = new ZGeneration("Marian Cezary");

        //When
        String marcinPost = marcin.sharePost();
        System.out.println("Marcin has got post in : " + marcinPost);
        String zenonPost = zenon.sharePost();
        System.out.println("Zenon has got post in : " + zenonPost);
        String marianPost = marian.sharePost();
        System.out.println("Marian has got post in : " + marianPost);

        //Then return
        Assert.assertEquals("Facebook", marcinPost);
        Assert.assertEquals("Twitter", zenonPost);
        Assert.assertEquals("Snapchat", marianPost);
    }

    @Test
    public void testIndividualSharingStrategy(){
        //Given
        User marcin = new Millenials("Marcin Zienkiewicz");

        //When
        String marcinPost = marcin.sharePost();
        System.out.println("Marcin has got post in : " + marcinPost);
        marcin.setMedium(new TwitterPublisher());
        marcinPost = marcin.sharePost();
        System.out.println("Marcin has got new post in : " + marcinPost);
        //Then
        Assert.assertEquals("Twitter", marcinPost);
    }
}
