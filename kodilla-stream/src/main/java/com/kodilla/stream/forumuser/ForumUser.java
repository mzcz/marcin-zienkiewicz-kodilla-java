package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int idUser;
    private final String name;
    private final char sex;
    private final LocalDate dayOfBirth;
    private final int countPosts;

    public ForumUser(int idUser, String name, char sex, LocalDate dayOfBirth, int countPosts) {
        this.idUser = idUser;
        this.name = name;
        this.sex = sex;
        this.dayOfBirth = dayOfBirth;
        this.countPosts = countPosts;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public int getCountPosts() {
        return countPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", dayOfBirth=" + dayOfBirth +
                ", countPosts=" + countPosts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        return idUser == forumUser.idUser;
    }

    @Override
    public int hashCode() {
        return idUser;
    }
}
