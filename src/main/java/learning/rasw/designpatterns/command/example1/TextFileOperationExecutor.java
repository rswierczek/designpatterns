package learning.rasw.designpatterns.command.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * An invoker is an object that knows how to execute a given command but doesn’t know how the command has been implemented.
 * It only knows the command’s interface.
 *
 * In some cases, the invoker also stores and queues commands, aside from executing them.
 * This is useful for implementing some additional features, such as macro recording or undo and redo functionality.
 *
 * In our example, it becomes evident that there must be an additional component responsible for invoking the command
 * objects and executing them through the commands’ execute() method. This is exactly where the invoker class comes into play.
 *
 * The TextFileOperationExecutor class is just a thin layer of abstraction that decouples the command objects
 * from their consumers and calls the method encapsulated within the TextFileOperation command objects.
 *
 * In this case, the class also stores the command objects in a List. Of course, this is not mandatory in the pattern
 * implementation, unless we need to add some further control to the operations’ execution process.
 */
public class TextFileOperationExecutor {

    private List<TextFileOperation> fileOperations = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation) {
        fileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
