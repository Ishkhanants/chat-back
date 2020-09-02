package chat.logger;

import java.io.IOException;

public class LoggerFactory {
    public static Logger createLogger(String loggerType,Level level) throws IOException {
        if(loggerType.equals("file")){
            return new FileLogger(level);
        }else if(loggerType.equals("console")){
            return  new ConsoleLogger(level);
        }else{
            throw new IllegalArgumentException("");
        }
    }
}
