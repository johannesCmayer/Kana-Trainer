package com.company;

public class VocabularyEntry {
    public String displayedString;
    public String correctAnswer;
    public float frequency = 1;

    public  VocabularyEntry(String view, String target)
    {
        this.displayedString = view;
        this.correctAnswer = target;
    }
}
