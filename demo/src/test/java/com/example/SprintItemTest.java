package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Pipeline.Pipeline;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.channels.Pipe;
import java.util.Date;

class SprintItemTest {
    
    private DeploymentSprint deploymentSprint;
    private ReviewSprint reviewSprint;
    private BackLogItem backlogItem;

    @BeforeEach
    void setUp() {
        deploymentSprint = new DeploymentSprint(null, null, null);
        reviewSprint = new ReviewSprint(null, null, null);
        backlogItem = new BackLogItem("Test Feature");
    }

    @Test
    void testSetStartDate() {
        Date startDate = new Date();
        deploymentSprint.setStartDate(startDate);
        assertEquals(startDate, deploymentSprint.getStartDate(), "Startdatum moet correct zijn ingesteld.");
    }

    @Test
    void testSetStartDateFails() {
        Date startDate = new Date();
        deploymentSprint.setStartDate(startDate);
        deploymentSprint.startSprintItem();
        Date newStartDate = new Date(1672531199000L);
        deploymentSprint.setStartDate(newStartDate);
        assertNotEquals(newStartDate, deploymentSprint.getStartDate(), "Startdatum mag niet worden overschreven.");
    }

    @Test
    void testSetEndDate() {
        Date endDate = new Date();
        deploymentSprint.setEndDate(endDate);
        assertEquals(endDate, deploymentSprint.getEndDate(), "Einddatum moet correct zijn ingesteld.");
    }

    @Test
    void testSetEndDateFails() {
        Date endDate = new Date();
        deploymentSprint.setEndDate(endDate);
        deploymentSprint.startSprintItem();
        Date newEndDate = new Date(1672531199000L);
        deploymentSprint.setEndDate(newEndDate);
        assertNotEquals(newEndDate, deploymentSprint.getEndDate(), "Einddatum mag niet worden overschreven.");
    }

    @Test
    void testSetName() {
        String name = "Test Sprint";
        deploymentSprint.setName(name);
        assertEquals(name, deploymentSprint.getName(), "Naam moet correct zijn ingesteld.");
    }

    @Test
    void testSetNameFails() {
        String name = "Test Sprint";
        deploymentSprint.setName(name);
        deploymentSprint.startSprintItem();
        String newName = "New Sprint";
        deploymentSprint.setName(newName);
        assertNotEquals(newName, deploymentSprint.getName(), "Naam mag niet worden overschreven.");
    }

    @Test
    void testAddBacklogItem() {
        deploymentSprint.addBacklogItem(backlogItem);
        assertTrue(deploymentSprint.getBacklogItems().contains(backlogItem), "Backlog item moet zijn toegevoegd aan de sprint.");
    }

    @Test
    void testAddBacklogItemFails() {
        deploymentSprint.startSprintItem();
        deploymentSprint.addBacklogItem(backlogItem);
        assertFalse(deploymentSprint.getBacklogItems().contains(backlogItem), "Backlog item mag niet worden toegevoegd aan de sprint.");
    }

    @Test
    void testRemoveBacklogItem() {
        deploymentSprint.addBacklogItem(backlogItem);
        deploymentSprint.removeBacklogItem(backlogItem);
        assertFalse(deploymentSprint.getBacklogItems().contains(backlogItem), "Backlog item moet zijn verwijderd van de sprint.");
    }

    @Test
    void testRemoveBacklogItemFails() {
        deploymentSprint.addBacklogItem(backlogItem);
        deploymentSprint.startSprintItem();
        deploymentSprint.removeBacklogItem(backlogItem);
        assertTrue(deploymentSprint.getBacklogItems().contains(backlogItem), "Backlog item mag niet worden verwijderd van de sprint.");
    }

    @Test
    void testReviewSprint() {
        reviewSprint.addBacklogItem(backlogItem);
        reviewSprint.startSprintItem();
        reviewSprint.finishSprintItem();
        Document reviewDocument = new Document("Review Document", "This is a review document.");
        reviewSprint.setReviewDocument(reviewDocument);
        reviewSprint.reviewSprintItem();
        assertEquals(reviewDocument, reviewSprint.getReviewDocument(), "Review document moet correct zijn ingesteld.");
        assertEquals("Reviewing", reviewSprint.getState().toString(), "Sprint moet in de Reviewing status staan.");
    }

    @Test
    void testReviewSprintFails() {
        reviewSprint.addBacklogItem(backlogItem);
        reviewSprint.startSprintItem();
        reviewSprint.finishSprintItem();
        reviewSprint.reviewSprintItem();
        assertEquals("Finished", reviewSprint.getState().toString(), "Sprint moet in de Finished status staan.");
    }

    @Test
    void testReleaseSprint() {
        Pipeline pipeline = new Pipeline("Test Pipeline");
        deploymentSprint.addBacklogItem(backlogItem);
        deploymentSprint.startSprintItem();
        deploymentSprint.finishSprintItem();
        deploymentSprint.setPipeline(pipeline);
        deploymentSprint.releaseSprintItem();
        assertEquals("Releasing", deploymentSprint.getState().toString(), "Sprint moet in de finished status staan zonder pipeline.");
    }

    @Test
    void testReleaseSprintFails() {
        deploymentSprint.addBacklogItem(backlogItem);
        deploymentSprint.startSprintItem();
        deploymentSprint.finishSprintItem();
        deploymentSprint.releaseSprintItem();
        assertEquals("Finished", deploymentSprint.getState().toString(), "Sprint moet in de finished status staan zonder pipeline.");
    }
}
