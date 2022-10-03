import java.io.File;
import java.io.IOException;

// This class implements the Runnable class interface
// for new thread that edits Java files

public class TaskFileEditor implements Runnable{
    private final File nmOfJavaFile;

    public TaskFileEditor(File nmOfJavaFile){
        this.nmOfJavaFile = nmOfJavaFile;
    }

    @Override
    public void run() {
        System.out.println("Do file editor for Java file:" + nmOfJavaFile.getAbsolutePath());
        try {
            JavaFileEditor.javaFileEditor(nmOfJavaFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
