package attacks;
import ru.ifmo.se.pokemon.*;
public class Swagger extends SpecialMove {
   public Swagger(){
    super(Type.NORMAL,0.0,0.85);
   }
   @Override
   protected String describe(){
    return "Использует Swagger";
   }
   protected void applySelfEffects(Pokemon pok){
        pok.setMod(Stat.ATTACK, +2);
   }
   protected void applyOppEffects(Pokemon poki){        
        poki.confuse();
   }
}