package learning.rasw.designpatterns.command.example2;

public interface Command {
    void call();
    void undo();
    void redo();
    boolean isSucceeded();
}
