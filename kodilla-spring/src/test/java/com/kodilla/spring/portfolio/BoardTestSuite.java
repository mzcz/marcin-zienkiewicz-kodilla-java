package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BoardTestSuite {

    @Test
    public void testTaskAddToDo(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When & Then
        board.getToDoList().addTasks("hibernate");
        board.getToDoList().addTasks("wzrore projektowe");
        board.getToDoList().addTasks("rest");
        board.readToDoList();
    }

    @Test
    public void testTaskAddInProgress(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When & Then

        board.getInProgressList().addTasks("Spring");
        board.readInProgressList();
    }

    @Test
    public void testTaskAddDone(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When & Then

        board.getDoneList().addTasks("Exception");
        board.getDoneList().addTasks("stream");
        board.readDoneList();
    }

    @Test
    public void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When & Then
        board.getToDoList().addTasks("hibernate");
        board.readToDoList();

        board.getInProgressList().addTasks("Spring");
        board.readInProgressList();

        board.getDoneList().addTasks("Exception");
        board.readDoneList();
    }
}
