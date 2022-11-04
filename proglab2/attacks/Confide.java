package attacks;
import ru.ifmo.se.pokemon.*;
public class Confide extends StatusMove {
    public Confide(){
        super(Type.NORMAL,0.0,1.0);
    }
    @Override
    protected String describe(){
        return "Использует Confide";
    }
    protected void applyOppEffects(Pokemon pok){
        pok.setMod(Stat.SPECIAL_ATTACK, -1);
    }
}
