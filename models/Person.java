package models;

import enums.Mood;
import java.util.Random;

public abstract class Person {
    private final String name;
    private final String origin;
    private Mood mood;
    protected static final Random random = new Random();

    public Person(String name, String origin) {
        this.name = name;
        this.origin = origin;
        this.mood = Mood.CALM;
    }

public abstract void react();

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }
}