package com.company;

import java.util.Dictionary;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Vocabulary vocab;
        var input = new Scanner(System.in);
        System.out.println("Type exit at any prompt to close application.");
        System.out.println("Enter 1 to train hiragana, enter 2 to train katakana.");

        validOptionFound:
        while (true) {
            var modeAnswer = input.nextLine().trim().toLowerCase();
            switch (modeAnswer) {
                case "1":
                    vocab = Vocabulary.getHiragana();
                    break validOptionFound;
                case "2":
                    vocab = Vocabulary.getKatakana();
                    break validOptionFound;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Not a valid option");
                    break;
            }
        }

        System.out.println("Enter the correct romaji.");
        mainLoop:
        while (true)
        {
            var val = vocab.GetRandomEntry();

            correctAnswer:
            while (true) {
                System.out.print(val.displayedString + " : ");
                var answer = input.nextLine().trim().toLowerCase();

                if (answer.equals("exit"))
                    break mainLoop;

                if (vocab.evaluate(answer))
                {
                    System.out.println("correct");
                    break correctAnswer;
                }
                else
                    System.out.println("WRONG => \"" + val.correctAnswer + "\"");
            }
        }
    }
}
