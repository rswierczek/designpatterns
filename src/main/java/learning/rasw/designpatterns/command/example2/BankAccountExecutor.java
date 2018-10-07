package learning.rasw.designpatterns.command.example2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;


public class BankAccountExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountExecutor.class);

    private Deque<Command> undoStack = new LinkedList<>();
    private Deque<Command> redoStack = new LinkedList<>();

    public void call(Command command){
        command.call();
        undoStack.offerLast(command);
    }

    public void undoLastAction(){
        if (!undoStack.isEmpty()) {
            Command previousAction = undoStack.pollLast();
            redoStack.offerLast(previousAction);
            LOGGER.info("{} undoes {}", this, previousAction);
            previousAction.undo();
        }
    }

    public void redoLastAction(){
        if (!redoStack.isEmpty()) {
            Command previousAction = redoStack.pollLast();
            undoStack.offerLast(previousAction);
            LOGGER.info("{} redos {}", this, previousAction);
            previousAction.redo();
        }


    }
}
