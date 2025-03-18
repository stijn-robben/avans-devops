package com.example.SprintState;

public interface ISprintState {
    
    public void startSprintItem(); //to in progress
    public void timeFinishSprintItem(); //to finished
    public void releaseSprintItem(); //to releasing 
    public void finishReleasingSprintItem(); //to released
    public void reviewSprintItem(); //to reviewing 
    public void finishReviewingSprintItem(); //to reviewed
    public void closeSprintItem(); //to closed
    public void cancelSprintItem(); //to canceled

}
