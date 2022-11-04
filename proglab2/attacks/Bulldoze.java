package attacks;
import ru.ifmo.se.pokemon.*;

public class Bulldoze extends StatusMove{
    public Bulldoze(){
        super(Type.GROUND,60.0,1.0);
    }
    @Override
    protected String describe(){
        return "Использует Bulldoze";
    }
    
    protected void applyOppEffects(Pokemon pok){
        pok.setMod(Stat.SPEED, -1);
    }
}
