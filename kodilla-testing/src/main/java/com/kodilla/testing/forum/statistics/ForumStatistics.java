package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

//Ilość użytkowników
private int numberUsers;
//Ilość postów
private int numberPosts;
//Ilość komentarzy
private  int numberComments;
//Średnia ilość postów na użytkownika
private double averageNumberOfPostsPerUser;
//Średnia ilość komentarzy na użytkownika
private double averageNumberOfCommentsPerUser;
//Średnia ilość komentarzy na post
private double averageNumberOfCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics){

        numberUsers = statistics.usersNames().size();
        numberPosts = statistics.postsCount();
        numberComments = statistics.commentsCount();

        if(numberUsers !=0){
            averageNumberOfPostsPerUser = (double) numberPosts / (double) numberUsers;
            averageNumberOfCommentsPerUser = (double) numberComments / (double) numberUsers;
        } else {
            averageNumberOfPostsPerUser = 0;
            averageNumberOfCommentsPerUser = 0;
        }

        if (numberPosts !=0) {
            averageNumberOfCommentsPerPost = (double) numberComments / (double) numberPosts;
        } else {
            averageNumberOfCommentsPerPost = 0;
        }
    }

    public void ShowStatistics(){
        System.out.println(" numberUsers "+ numberUsers);
        System.out.println(" numberPosts "+ numberPosts);
        System.out.println(" numberComments "+ numberComments);
        System.out.println(" averageNumberOfPostsPerUser "+ String.format("%.2f",averageNumberOfPostsPerUser));
        System.out.println(" averageNumberOfCommentsPerUser "+ String.format("%.2f",averageNumberOfCommentsPerUser));
        System.out.println(" averageNumberOfCommentsPerPost " + String.format("%.2f", averageNumberOfCommentsPerPost));
    }

    public int getNumberUsers() {
        return numberUsers;
    }

    public int getNumberPosts() {
        return numberPosts;
    }

    public int getNumberComments() {
        return numberComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }
}
