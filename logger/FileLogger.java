package chat.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileLogger implements Logger{
    private final FileWriter fw = new FileWriter("C:\\Users\\marti\\Downloads\\testForLogger.txt");
    private Level level;

    public FileLogger(Level level) throws IOException {
      this.level = level;
    }

    @Override
    public void debug(String msg) throws IOException {
        if(level.getPriority()==1){
            fw.write("DEBUG:\n" + msg);
        }
    }

    @Override
    public void info(String msg) throws IOException {
        if(level.getPriority()<=2){
            fw.write("INFO:\n" + msg);
        }
    }

    @Override
    public void warn(String msg) throws IOException {
        if(level.getPriority()<=3){
            fw.write("WARN:\n" + msg);
        }
    }

    @Override
    public void error(String msg, Exception e) throws IOException {
            fw.write("ERROR:\n" + Arrays.toString(e.getStackTrace()) + '\n' + msg);
    }

    @Override
    public void end() throws IOException {
        fw.close();
    }
}
