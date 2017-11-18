package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void logFile(){
        Logger.getInstance().log("start logging...");
    }

    @Test
    public void testGetLog(){
        //Given
        //When
        String log = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("start logging...", log);
    }

}
