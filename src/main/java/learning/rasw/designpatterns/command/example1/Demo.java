package learning.rasw.designpatterns.command.example1;


/**
 * https://www.baeldung.com/java-command-pattern
 * The command pattern is a behavioral design pattern and is part of the GoF‘s formal list of design patterns.
 * Simply put, the pattern intends to encapsulate in an object all the data required for performing a given action (command),
 * including what method to call, the method’s arguments, and the object to which the method belongs.
 *
 * This model allows us to decouple objects that produce the commands from their consumers,
 * so that’s why the pattern is commonly known as the producer-consumer pattern.
 *
 *
 *
 *
 * Client class
 * A client is an object that controls the command execution process by specifying what commands to execute
 * and at what stages of the process to execute them.
 */
public class Demo {
    public static void main(String[] args) {
        standardApproach();
        usingLambda();
        usingMethodReference();
    }

    private static void standardApproach(){
        TextFileOperationExecutor textFileOperationExecutor
                = new TextFileOperationExecutor();
        System.out.println(
                textFileOperationExecutor.executeOperation(
                        new OpenTextFileOperation(new TextFile("file1.txt"))));

        System.out.println(textFileOperationExecutor.executeOperation(
                new SaveTextFileOperation(new TextFile("file2.txt"))));
    }

    private static void usingLambda(){
        TextFileOperationExecutor textFileOperationExecutor
                = new TextFileOperationExecutor();
        System.out.println(textFileOperationExecutor.executeOperation(() -> "Opening file file1.txt"));

        System.out.println(textFileOperationExecutor.executeOperation(() -> "Saving file file2.txt"));
    }

    private static void usingMethodReference(){
        TextFileOperationExecutor textFileOperationExecutor
                = new TextFileOperationExecutor();

        TextFile textFile = new TextFile("file1.txt");
        System.out.println(textFileOperationExecutor.executeOperation(textFile::open));

        System.out.println(textFileOperationExecutor.executeOperation(textFile::save));
    }
}
