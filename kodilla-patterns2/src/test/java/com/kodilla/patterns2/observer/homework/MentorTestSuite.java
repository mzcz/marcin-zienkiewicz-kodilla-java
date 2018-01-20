package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MentorTestSuite {

    @Test
    public void testUpdate(){
        //Given
        KodillaTask agnieszkaQueueTopic = new AgnieszkaQueueTopic();
        KodillaTask marcinQueueTopic = new MarcinQueueTopic();
        KodillaTask danieQueueTopic = new DanieQueueTopic();
        Mentor kasia = new Mentor("Kasia");
        Mentor jacek = new Mentor("Jacek");
        agnieszkaQueueTopic.registerObserver(kasia);
        marcinQueueTopic.registerObserver(kasia);
        danieQueueTopic.registerObserver(jacek);
        //When
        agnieszkaQueueTopic.addTask("Wzorzec Obserwator");
        agnieszkaQueueTopic.addTask("Wzorzec Fasada");
        agnieszkaQueueTopic.addTask("Wzorzec Dekorator");
        agnieszkaQueueTopic.addTask("Aspekty");
        marcinQueueTopic.addTask("Wzorzec Dekorator");
        marcinQueueTopic.addTask("Wzorzec Fasada");
        marcinQueueTopic.addTask("Wzorzec Obserwator");
        danieQueueTopic.addTask("Wzorzec Fasada");
        danieQueueTopic.addTask("Wzorzec Dekorator");
        //Then
        assertEquals(7, kasia.getUpdateCount());
        assertEquals(2, jacek.getUpdateCount());
    }
}
