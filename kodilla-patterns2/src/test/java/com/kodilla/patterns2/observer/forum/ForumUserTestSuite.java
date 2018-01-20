package com.kodilla.patterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {

    @Test
    public void testUpdate(){
        //Given
        ForumTopic javaHelpForumTopic = new JavaHelpForumTopic();
        ForumTopic javaToolsForumTopic = new JavaToolsForumTopic();
        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
        ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");
        javaHelpForumTopic.registerObserver(johnSmith);
        javaToolsForumTopic.registerObserver(ivoneEscobar);
        javaHelpForumTopic.registerObserver(jessiePinkman);
        javaToolsForumTopic.registerObserver(jessiePinkman);
        //When
        javaHelpForumTopic.addPost("Hi everyone! Could Yoy help me with for loop?");
        javaHelpForumTopic.addPost("Better try to use while loop in this case. ");
        javaToolsForumTopic.addPost("Help pls, my Mysql db doesn't want to work :(");
        javaHelpForumTopic.addPost("Why while? Is it better?");
        javaToolsForumTopic.addPost("When I try to log in I got ' bad credentials' message.");
        //Then
        assertEquals(3, johnSmith.getUpdateCount());
        assertEquals(2, ivoneEscobar.getUpdateCount());
        assertEquals(5, jessiePinkman.getUpdateCount());
    }
}
