import java.io.File;
import java.io.IOException;

// This class implements the Runnable class interface
// for new thread that checks Directory for Java files

public class TaskFileFilter implements Runnable{

    private final File nmOfFile;
    private final String ext;

    public TaskFileFilter(File nmOfFile, String ext){
        this.nmOfFile = nmOfFile;
        this.ext = ext;
    }

    @Override
    public void run() {
        System.out.println("Do file filter for dir:" + nmOfFile.getAbsolutePath());
        try {
            FileJavaFilter.fileJavaFilter(nmOfFile.getAbsolutePath(), ext);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
