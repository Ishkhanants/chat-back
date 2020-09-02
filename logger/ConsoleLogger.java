package chat.logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ConsoleLogger implements Logger{
    private Level level;
    private ArrayList<String> buf = new ArrayList<>();

    public ConsoleLogger(Level level) throws IOException {
        this.level = level;
    }

    @Override
    public void debug(String msg) throws IOException {
        if(level.getPriority()==1){
            buf.add("DEBUG:\n" + msg);
        }
    }

    @Override
    public void info(String msg) throws IOException {
        if(level.getPriority()<=2){
            buf.add("INFO:\n" + msg);
        }
    }

    @Override
    public void warn(String msg) throws IOException {
        if(level.getPriority()<=3){
            buf.add("WARN:\n" + msg);
        }
    }

    @Override
    public void error(String msg, Exception e) throws IOException {
        buf.add("ERROR:\n" + Arrays.toString(e.getStackTrace()) + '\n' + msg);
    }

    @Override
    public void end() throws IOException {
        for (String st: buf) {
            System.out.println(st);
        }
    }
}
