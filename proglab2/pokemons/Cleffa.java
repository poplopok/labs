package pokemons;
import attacks.DoubleTeam;
import attacks.FireBlast;
import ru.ifmo.se.pokemon.*;
public class Cleffa extends Pokemon{
    public Cleffa(String name,int lvl){
        super(name,lvl);
        setStats(50,25, 28, 45, 55, 15);
        setType(Type.FAIRY);
        addMove(new DoubleTeam());
        addMove(new FireBlast());
    }
    
}