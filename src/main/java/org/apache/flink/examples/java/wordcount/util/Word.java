package org.apache.flink.examples.java.wordcount.util;

/**
 * This is the POJO (Plain Old Java Object) that is being used
 * for all the operations.
 * As long as all fields are public or have a getter/setter, the system can handle them
 */
public class Word {
    // fields
    private String word;
    private int frequency;

    // constructors
    public Word() {}

    public Word(String word, int i) {
        this.word = word;
        this.frequency = i;
    }

    // getters setters
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Word=" + word + " freq=" + frequency;
    }
}
