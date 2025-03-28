package com.example;

import com.example.TeamMember.ProductOwnerMember;
import com.example.TeamMember.TeamMember;
import com.example.TeamMember.TesterMember;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BackLogItemTest {

    private BackLogItem backlogItem;

    @BeforeEach
    void setUp() {
        backlogItem = new BackLogItem("Test Feature");
    }

    @Test
    void testAssignDeveloper() {
        TeamMember dev = new ProductOwnerMember("Alice");
        backlogItem.assignDeveloper(dev);
        assertEquals(dev.getName(), backlogItem.getAssignedDeveloperName(), "Developer moet correct toegewezen zijn.");
    }

    @Test
    void testAddActivity() {
        TeamMember dev = new TesterMember("Alice");

        Activity activity = new Activity("Write unit tests", 12, dev);
        backlogItem.addActivity(activity);
        assertTrue(backlogItem.getActivities().contains(activity), "Activiteit moet zijn toegevoegd aan backlog item.");
    }

    @Test
    void testRemoveActivity() {
        TeamMember dev = new TesterMember("Alice");

        Activity activity = new Activity("Write unit tests", 12, dev);
        backlogItem.addActivity(activity);
        backlogItem.removeActivity(activity);
        assertFalse(backlogItem.getActivities().contains(activity), "Activiteit moet zijn verwijderd van backlog item.");
    }

    @Test
    void testInitialStateIsToDo() {
        assertEquals("ToDo", backlogItem.getState().toString(), "Backlog item moet starten in ToDo status.");
    }

    @Test
    void testValidStateTransition_ToDoing() {
        backlogItem.startBacklogItem();
        assertEquals("Doing", backlogItem.getState().toString(), "Backlog item moet in Doing status staan.");
    }

    @Test
    void testInvalidStateTransition_DirectToDone() {
        backlogItem.finishImplementingItem();  // Mag alleen als Tested of ReadyForTesting voltooid is
        assertEquals("ToDo", backlogItem.getState().toString(), "Backlog item moet in ToDo status staan.");
    }
}
