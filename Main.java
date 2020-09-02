package chat;

import chat.logger.*;
import chat.model.Member;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Member[] removeTheElement(Member[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        Member[] anotherArray = new Member[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }

    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.createLogger("file", Level.INFO);

        System.out.println("Input count of members:");
        Scanner scan = new Scanner(System.in);
        int countOfMembers = scan.nextInt();

        logger.info("Count of members inserted is " + countOfMembers);
        logger.warn("Warning!");
        logger.debug("Debug!");
        logger.error("Error!", new RuntimeException());

        Member[] memberArray = new Member[countOfMembers];

        for (int i = 0; i < countOfMembers; i++) {
            memberArray[i] = new Member();
        }

        Random randNumGenerator = new Random();

        while (countOfMembers != 0) {
            System.out.print("\nActive members: ");
            for (int i = 0; i < countOfMembers; ++i) {
                System.out.print(memberArray[i].getName() + " ");
            }

            System.out.println();

            int randomMemberNumber = randNumGenerator.nextInt(countOfMembers);
            memberArray[randomMemberNumber].sendMessageToChat();

            if (memberArray[randomMemberNumber].left) {
                memberArray = removeTheElement(memberArray, randomMemberNumber);
                countOfMembers--;
            }

            if (countOfMembers == 0) {
                System.out.println("\nAll active members left chat," +
                        "\nso chat is finishing now!");
            }
        }

        logger.end();
    }
}