package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTest {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testForumStatisticNoPostWithMock() {
        //gdy liczba postów = 0
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postCount = 0;
        when(statisticsMock.postsCount()).thenReturn(postCount);

        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0, forumStatistics.getNumberPosts());
        forumStatistics.ShowStatistics();
    }
    @Test
    public void testForumStatisticNotNullPostWithMock() {
        //gdy liczba postów = 1000
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postCount = 1000;
        when(statisticsMock.postsCount()).thenReturn(postCount);

        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(1000, forumStatistics.getNumberPosts());
        forumStatistics.ShowStatistics();
    }

    @Test
    public void testForumStatisticCommentsLowerThanPostsWithMock() {
        //gdy liczba komentarzy < liczba postów
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postCount = 10000;
        int commentsCount = 9999;
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);


        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        boolean result = false;
        if (forumStatistics.getNumberComments() < forumStatistics.getNumberPosts()) {
            result = true;
        }
        Assert.assertTrue(result);
        forumStatistics.ShowStatistics();
    }

    @Test
    public void testForumStatisticCommentsGreaterThanPostsWithMock() {
        //gdy liczba komentarzy > liczba postów
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        int postCount = 1000;
        int commentsCount = 1001;
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);


        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        boolean result = false;
        if (forumStatistics.getNumberComments() > forumStatistics.getNumberPosts()) {
            result = true;
        }
        Assert.assertTrue(result);
        forumStatistics.ShowStatistics();
    }

    @Test
    public void testForumStatisticsNoUsersWithMock() {
        //gdy liczba użytkowników = 0
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();

        when(statisticsMock.usersNames()).thenReturn(usersNames);

        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0, forumStatistics.getNumberUsers());
        forumStatistics.ShowStatistics();
    }

    @Test
    public void testForumStatisticsUsersWithMock() {
        //gdy liczba użytkowników = 100
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for (int i=0; i< 100;i++) {
            usersNames.add("User" + i);
        }

        when(statisticsMock.usersNames()).thenReturn(usersNames);

        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, forumStatistics.getNumberUsers());
        forumStatistics.ShowStatistics();
    }

    @Test
    public void testForumStatisticsAdditionalAveragePostPerUserWithMock() {
        //gdy liczba użytkowników = 100 i liczba postow 1000

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>();
        for (int i=0; i< 500;i++) {
            usersNames.add("User" + i);
        }
        int postCount = 1500;
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postCount);

        ForumStatistics forumStatistics = new ForumStatistics();

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(3.0, forumStatistics.getAverageNumberOfPostsPerUser(),0.0);
        forumStatistics.ShowStatistics();
    }
}
