package pokemons;
import attacks.*;
import ru.ifmo.se.pokemon.*;
public class Sawk extends Pokemon{
    public Sawk(String name, int lvl){
        super(name,lvl);
        setStats(75, 125, 75, 30, 75, 85);
        setType(Type.FIGHTING);
        addMove(new CloseCombat());
        addMove(new RockTomb());
        addMove(new BulkUp());
        addMove(new Bulldoze());
    }
}
