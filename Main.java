import factories.CultistFactory;
import factories.PoliceOfficerFactory;
import models.*;
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
        island.setMonolith(monolith);
        
        RingOfFire ringOfFire = new RingOfFire();
        island.setRingOfFire(ringOfFire);
      
        
        cultist1.joinRitual(ringOfFire);
        cultist2.joinRitual(ringOfFire);
        cultist3.joinRitual(ringOfFire);
        
        monolith.influence(cultist1);
        monolith.influence(cultist2);
        
        cultist1.react();
      
        cultist2.react();
       
        
        officer1.witnessRitual();
        
        officer4.witnessRitual();

        
        officer1.arrest(cultist4);
        officer2.arrest(cultist5);
        
        cultist4.resist();
        cultist5.resist();
        
        officer1.shootAt(cultist4);
        officer2.shootAt(cultist5);
        officer3.shootAt(cultist1);
        
        cultist4.tryToEscape();
        cultist5.tryToEscape();
        
        if (cultist1.getState() != State.KILLED && cultist1.getHp() > 0) {
            cultist2.carryWounded(cultist1);
        }
        
        Inspector inspector = (Inspector) officer5;
        RaidResults results = inspector.count(island.getCultists());
        
       
        


  
        Statuette confiscatedStatuette = inspector.take(monolith);
     
        
        InterrogationResults interrogation = inspector.interrogate(cultist2);
      


        
        PoliceStation station = new PoliceStation();
        
        if (cultist4.getState() == State.ARRESTED || cultist4.getState() == State.WOUNDED_ARRESTED) {
            officer1.deliver(cultist4, station);
        }

        if (cultist5.getState() == State.ARRESTED || cultist5.getState() == State.WOUNDED_ARRESTED) {
            officer2.deliver(cultist5, station);
        }
    }
}