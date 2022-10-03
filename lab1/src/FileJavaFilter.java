import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This class implements methods that
// finds Java files and subdirectories
// and run methods to edit files or check
// subdirectories for existence Java files

public class FileJavaFilter {

    static void fileJavaFilter(String dir, String ext) throws IOException {
        File file = new File(dir);
        File[] listFiles = file.listFiles(new JavaFileFilter(ext));
        File[] listDir = file.listFiles(File::isDirectory);
        assert listFiles != null;
        if (listFiles.length == 0) {
            System.out.println("There are no Java files is " + dir);
        } else {
            TaskFileEditor[] taskFileEditors = new TaskFileEditor[listFiles.length];
            ExecutorService poolFileEditor = Executors.newCachedThreadPool();
            for (int i = 0; i < listFiles.length; i++) {
                System.out.println("File: " + listFiles[i].getAbsolutePath());
                // в окремий поток
                taskFileEditors [i] = new TaskFileEditor(listFiles[i]);
                poolFileEditor.submit(taskFileEditors[i]);
            }
            poolFileEditor.shutdown();

        }
        assert listDir != null;
        if (listDir.length != 0){
            TaskFileFilter[] taskFileFilters = new  TaskFileFilter[listDir.length];
            ExecutorService poolFileFilter = Executors.newCachedThreadPool();
            for (int i = 0; i < listDir.length; i++) {
                System.out.println("Dir: " + listDir[i].getAbsolutePath());
                taskFileFilters [i] = new TaskFileFilter(listDir[i],ext);
                poolFileFilter.submit(taskFileFilters[i]);
            }
            poolFileFilter.shutdown();
        }
    }
}