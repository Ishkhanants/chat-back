package chat.logger;

public enum Level {
    DEBUG(1),
    INFO(2),
    ERROR(3),
    WARN(4);

    private int priority;

    Level(int priority){
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
