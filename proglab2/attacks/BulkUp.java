package attacks;
import ru.ifmo.se.pokemon.*;

public class BulkUp extends StatusMove {
    public BulkUp(){
        super(Type.FIGHTING,0.0,1.0);
    }
    @Override
    protected String describe(){
        return ("Использует Bulk Up");
    }
   @Override
   protected void applySelfEffects(Pokemon pok){
        pok.setMod(Stat.ATTACK,+1);
        pok.setMod(Stat.DEFENSE,+1);

   }
}
