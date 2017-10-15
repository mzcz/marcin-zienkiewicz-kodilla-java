package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTest {
    private static int testCounter = 0;
    private ForumStatistics forumStatistics;
    private Statistics statisticsMock;
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

        // jak mamy w kazdym tescie ten sam kod, jak np. tutaj w kazdym tescie inicjalizacja
        // ForumStatistics forumStatistics = new ForumStatistics();
        // to chcemy to wydzielić to części wspolnej
        // więc stworzyłam pole
        // private ForumStatistics forumStatistics;
        // w i beforeEveryTest przypisuje mu wartosc. Wychodzi na to samo, a o kilka linijek kodu mniej:-)
        // tak samo z : ForumStatistics statisticsMock = mock(Statistics.class);
        forumStatistics = new ForumStatistics();
        statisticsMock = mock(Statistics.class);
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testForumStatisticNoPostWithMock() {
        //gdy liczba postów = 0
        //Given
        int postCount = 0;
        when(statisticsMock.postsCount()).thenReturn(postCount);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0, forumStatistics.getNumberPosts());
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerPost(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerUser(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfPostsPerUser(),0.0);
        forumStatistics.ShowStatistics();
    }
    @Test
    public void testForumStatisticNotNullPostWithMock() {
        //gdy liczba postów = 1000
        //Given
        int postCount = 1000;
        when(statisticsMock.postsCount()).thenReturn(postCount);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(1000, forumStatistics.getNumberPosts());
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerPost(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerUser(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfPostsPerUser(),0.0);
        forumStatistics.ShowStatistics();
    }

    @Test
    public void testForumStatisticCommentsLowerThanPostsWithMock() {
        //gdy liczba komentarzy < liczba postów
        //Given
        int postCount = 10000;
        int commentsCount = 5000;
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        boolean result = false;
        if (forumStatistics.getNumberComments() < forumStatistics.getNumberPosts()) {
            result = true;
        }

        Assert.assertTrue(result);
        Assert.assertEquals(0.5, forumStatistics.getAverageNumberOfCommentsPerPost(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerUser(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfPostsPerUser(),0.0);
        forumStatistics.ShowStatistics();
    }

    @Test
    public void testForumStatisticCommentsGreaterThanPostsWithMock() {
        //gdy liczba komentarzy > liczba postów
        //Given
        int postCount = 1000;
        int commentsCount = 1001;
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        boolean result = false;
        if (forumStatistics.getNumberComments() > forumStatistics.getNumberPosts()) {
            result = true;
        }
        Assert.assertTrue(result);
        Assert.assertEquals(1.001, forumStatistics.getAverageNumberOfCommentsPerPost(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerUser(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfPostsPerUser(),0.0);
        forumStatistics.ShowStatistics();
    }

    @Test
    public void testForumStatisticsNoUsersWithMock() {
        //gdy liczba użytkowników = 0
        //Given
        List<String> usersNames = new ArrayList<>();

        when(statisticsMock.usersNames()).thenReturn(usersNames);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0, forumStatistics.getNumberUsers());
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerPost(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerUser(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfPostsPerUser(),0.0);
        forumStatistics.ShowStatistics();
    }

    @Test
    public void testForumStatisticsUsersWithMock() {
        //gdy liczba użytkowników = 100
        //Given
        List<String> usersNames = new ArrayList<>();
        for (int i=0; i< 100;i++) {
            usersNames.add("User" + i);
        }

        when(statisticsMock.usersNames()).thenReturn(usersNames);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, forumStatistics.getNumberUsers());
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerPost(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerUser(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfPostsPerUser(),0.0);
        forumStatistics.ShowStatistics();
    }

    @Test
    public void testForumStatisticsAdditionalAveragePostPerUserWithMock() {
        //gdy liczba użytkowników = 100 i liczba postow 1000

        //Given
        List<String> usersNames = new ArrayList<>();
        for (int i=0; i< 500;i++) {
            usersNames.add("User" + i);
        }
        int postCount = 1500;
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postCount);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerPost(),0.0);
        Assert.assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerUser(),0.0);
        Assert.assertEquals(3.0, forumStatistics.getAverageNumberOfPostsPerUser(),0.0);
        forumStatistics.ShowStatistics();
    }

}