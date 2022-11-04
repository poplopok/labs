package attacks;

import ru.ifmo.se.pokemon.*;

public class FireBlast extends SpecialMove {
    public FireBlast(){
        super(Type.FIRE,110.0,80.9);
    }
    @Override
    public String describe(){
        return "Поджигает противника с помощью Fire Blast";
    }
    public void applyOppEffects(Pokemon pok){
        Effect effect= new Effect().chance(1.0).condition(Status.BURN);
        pok.addEffect(effect);
    }
}
