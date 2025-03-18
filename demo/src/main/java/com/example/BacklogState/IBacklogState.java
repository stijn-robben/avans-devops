package com.example.BacklogState;

public interface IBacklogState {
        
        public void startBacklogItem();
        public void finishImplementingItem();
        public void startTestingItem();
        public void finishTestingItem();
        public void deployItem();
        public void revertToTodo();
        public void revertToReadyForTesting();

    
}
