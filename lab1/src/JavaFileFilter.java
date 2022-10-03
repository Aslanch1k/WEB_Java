import java.io.File;
import java.io.FilenameFilter;

// This class filters files in the dir
// and return only Java files

public class JavaFileFilter implements FilenameFilter{
    private final String ext;

    public JavaFileFilter(String ext){
        this.ext = ext.toLowerCase();
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(ext);
    }
}
