package attacks;

import ru.ifmo.se.pokemon.*;

public class Pound extends PhysicalMove {
    public Pound(){
        super(Type.NORMAL,40.0,1.0);
    }
    @Override
    protected String describe(){
        return "Использует Pound";
    }
}
