package factories;

import models.Person;

public abstract class PersonFactory {
    public abstract Person createPerson(String name, String origin);
}