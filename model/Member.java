package chat.model;

import java.text.SimpleDateFormat;
import java.util.*;

public class Member {
    private String name;
    static private Scanner scan = new Scanner(System.in);
    static private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public boolean left = false;

    public Member() {
        System.out.println("Enter new member name:");
        this.name = scan.nextLine();
    }

    public String getName() {
        return name;
    }

    public void sendMessageToChat() {
        System.out.println("\nMember " + this.name);
        System.out.println("Press Number for Action\n1. Send message\n2. Exit chat");
        String checkActionNumber = scan.nextLine();

        switch (checkActionNumber) {
            case "1":
                Date date = new Date(System.currentTimeMillis());
                System.out.println("\n" + formatter.format(date));
                System.out.println("Member " + this.name + " is writing.");
                String textToSend = scan.nextLine();
                break;
            case "2":
                left = true;
                System.out.println("\nMember " + this.name + " left chat.");
                break;
            default:
                System.out.println("\nInput 1 or 2!");
                break;
        }
    }
}