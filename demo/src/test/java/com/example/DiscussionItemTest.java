package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscussionItemTest {
    
    private Discussion discussionItem;
    private Thread discussionThread;

    @BeforeEach
    void setUp() {
        discussionItem = new Discussion("Test Discussion");
        discussionThread = new Thread("Test Thread", null);

    }

    @Test
    void testAddThread() {
        discussionItem.addThread(discussionThread);
        discussionItem.getThreads();
        assertTrue(discussionItem.getThreads().contains(discussionThread), "Thread moet zijn toegevoegd aan discussie.");
    }

    @Test
    void testAddThreadFails() {
        discussionItem.addThread(discussionThread);
        discussionItem.getThreads();
        assertFalse(discussionItem.getThreads().contains(new Thread("Non-existent Thread", null)), "Niet-bestaande thread mag niet worden toegevoegd aan discussie.");
    }

    @Test
    void testRemoveThread() {
        discussionItem.addThread(discussionThread);
        discussionItem.removeThread(discussionThread);
        assertFalse(discussionItem.getThreads().contains(discussionThread), "Thread moet zijn verwijderd van discussie.");
    }

    @Test
    void testLockAllThreads() {
        discussionItem.addThread(discussionThread);
        discussionItem.lockAllThreads();
        discussionThread.addMessage(null); // Simuleer een bericht
        assertTrue(discussionThread.getMessages().isEmpty(), "Berichten moeten niet kunnen worden toegevoegd aan een vergrendelde thread.");
    }

    @Test
    void testUnlockAllThreads() {
        discussionItem.addThread(discussionThread);
        discussionItem.lockAllThreads();
        discussionItem.unlockAllThreads();
        discussionThread.addMessage(null); // Simuleer een bericht
        assertFalse(discussionThread.getMessages().isEmpty(), "Berichten moeten kunnen worden toegevoegd aan een ontgrendelde thread.");
    }

    @Test
    void testGetCreatedDate() {
        assertNotNull(discussionItem.getCreationDate(), "Creatiedatum moet niet null zijn.");
    }
}
