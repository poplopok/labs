package attacks;
import ru.ifmo.se.pokemon.*;
public class RockTomb extends StatusMove {
    public RockTomb(){
        super(Type.ROCK,60.0,0.95);
    }
    @Override
    protected String describe(){
        return "Использует Rock Tomb";
    }
    @Override
    protected void applyOppEffects(Pokemon pok){
        pok.setMod(Stat.SPEED, -1);  
    }
}
