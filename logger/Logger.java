package chat.logger;

import java.io.IOException;

public interface Logger {
    void debug(String msg) throws IOException;
    void info(String msg) throws IOException;
    void warn(String msg) throws IOException;
    void error(String msg, Exception e) throws IOException;
    void end() throws IOException;
}
