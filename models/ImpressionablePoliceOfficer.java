package models;

import enums.Mood;

public class ImpressionablePoliceOfficer extends PoliceOfficer {
    public ImpressionablePoliceOfficer(String name, String origin, String weaponType, int experience) {
        super(name, origin, weaponType, experience);
    }

 public void hearSounds(Creature creature) {
        int soundLevel = creature.rustleWings();
        if (soundLevel > 10) {
            int panicLevel = Person.random.nextInt(100);
            if (panicLevel > 50) {
                setMood(Mood.PANIC);
            } else {
                setMood(Mood.SHOCKED);
            }
        }
    }

    public void seeVisions(Creature creature) {
        int size = creature.instillHorror();
        if (size > 10) {
            int visionReaction = Person.random.nextInt(100);
            if (visionReaction > 70) {
                setMood(Mood.PANIC);
            } else {
                setMood(Mood.SHOCKED);
            }
        }
    }
}