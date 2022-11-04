package attacks;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove{
    public DoubleTeam(){
        super(Type.NORMAL,0.0,1.0);
    }
    @Override
    protected String describe(){
        return "прокачивает ловкость с помощью Double Team ";
    }
    protected void applySelfEffects(Pokemon pok){
        pok.setMod(Stat.EVASION, +1);
    }
}
