package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumList = new ArrayList<>();

    public Forum() {

        theForumList.add(new ForumUser(1,"marcin",'M', LocalDate.of(1980, 02,24), 0));
        theForumList.add(new ForumUser(2,"piotr",'M', LocalDate.of(1985, 02,24), 30));
        theForumList.add(new ForumUser(3,"victoria",'F', LocalDate.of(2000, 02,24), 5));
        theForumList.add(new ForumUser(4,"ola",'F', LocalDate.of(2005, 02,24), 100));
        theForumList.add(new ForumUser(5,"beata",'F', LocalDate.of(2005, 02,24), 2));
        theForumList.add(new ForumUser(6,"adrian",'M', LocalDate.of(1999, 02,24), 50));
        theForumList.add(new ForumUser(7,"aga",'F', LocalDate.of(1997, 02,24), 1));
        theForumList.add(new ForumUser(8,"marek",'M', LocalDate.of(1997, 10,20), 10));
        theForumList.add(new ForumUser(9,"lukasz",'M', LocalDate.of(1996, 02,24), 1));
    }

    public List<ForumUser> getUserList(){
        return new ArrayList<>(theForumList);
    }

}
