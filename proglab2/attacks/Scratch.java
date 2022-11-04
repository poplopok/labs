package attacks;

import ru.ifmo.se.pokemon.*;

public class Scratch extends PhysicalMove {
    public Scratch(){
        super(Type.NORMAL,40.0,1.0);
    }
    @Override
    protected String describe(){
        return "Использует атаку Scratch";
    }
}
