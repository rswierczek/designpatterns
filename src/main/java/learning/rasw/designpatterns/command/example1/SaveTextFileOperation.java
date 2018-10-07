package learning.rasw.designpatterns.command.example1;

/**
 *  A command is an object whose role is to store all the information required for executing an action, including the method to call, the method     arguments, and the object (known as the receiver) that implements the method.
 */
public class SaveTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    public SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.save();
    }
}
