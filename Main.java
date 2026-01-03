import factories.CultistFactory;
import factories.PoliceOfficerFactory;
import models.*;
import records.InterrogationResults;
import records.RaidResults;
import enums.State;

public class Main {
    public static void main(String[] args) {
        Island island = new Island();
        
        PoliceOfficerFactory standardOfficerFactory = new PoliceOfficerFactory("Пистолет", 65);
        PoliceOfficerFactory shotgunOfficerFactory = new PoliceOfficerFactory("Дробовик", 80);
        PoliceOfficerFactory smgOfficerFactory = new PoliceOfficerFactory("Пистолет-пулемет", 45);
        
        PoliceOfficer officer1 = standardOfficerFactory.createPerson("Джон Смит", "Нью-Йорк");
        PoliceOfficer officer2 = shotgunOfficerFactory.createPerson("Мария Родригес", "Лос-Анджелес");
        PoliceOfficer officer3 = smgOfficerFactory.createPerson("Томас Джонсон", "Чикаго");
        PoliceOfficer officer4 = new ImpressionablePoliceOfficer("Роберт Уилсон", "Майами", "Пистолет", 30);
        PoliceOfficer officer5 = new Inspector("Джеймс Андерсон", "Вашингтон", "Револьвер", 90);
        
        CultistFactory highRankFactory = new CultistFactory("high");
        CultistFactory mediumRankFactory = new CultistFactory("medium");
        CultistFactory lowRankFactory = new CultistFactory("low");
        
        Cultist cultist1 = highRankFactory.createPerson("Молох", "Неизвестно");
        Cultist cultist2 = mediumRankFactory.createPerson("Азазель", "Европа");
        Cultist cultist3 = mediumRankFactory.createPerson("Вельзевул", "Азия");
        Cultist cultist4 = lowRankFactory.createPerson("Лилит", "Африка");
        Cultist cultist5 = lowRankFactory.createPerson("Баал", "Южная Америка");

        officer1.moveTo(island);
        officer2.moveTo(island);
        officer3.moveTo(island);
        officer4.moveTo(island);
        officer5.moveTo(island);
        
        cultist1.moveTo(island);
        cultist2.moveTo(island);
        cultist3.moveTo(island);
        cultist4.moveTo(island);
        cultist5.moveTo(island);
        
        Statuette statuette = new Statuette("Обсидиан");
        Monolith monolith = new Monolith(3.5f, "Базальт", statuette);
        
        RingOfFire ringOfFire = new RingOfFire();
        
        PoliceStation station = new PoliceStation();
    }
}