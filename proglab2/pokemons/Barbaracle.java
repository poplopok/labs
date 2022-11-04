package pokemons;
import attacks.*;
import ru.ifmo.se.pokemon.*;
public class Barbaracle extends Binacle {
    public Barbaracle(String name,int lvl) {
        super(name,lvl);
        setStats(72, 105, 115, 54, 86, 68);
        setType(Type.WATER,Type.ROCK);
        addMove(new BulkUp());
    }
}
    

