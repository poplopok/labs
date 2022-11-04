package attacks;
import ru.ifmo.se.pokemon.*;
public class CloseCombat extends StatusMove{
    public CloseCombat(){
        super(Type.NORMAL,120.0,1.0);
    }
    @Override
    protected String describe(){
        return "Использует Close Combat";
    }
    
    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.DEFENSE, -1);
        p.setMod(Stat.SPECIAL_DEFENSE, -1);
    }
}