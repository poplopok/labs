package pokemons;
import attacks.*;
import ru.ifmo.se.pokemon.*;
public class Binacle extends Pokemon {
    public Binacle(String name,int lvl){
        super(name,lvl);
        setStats(42, 52, 67, 39, 56, 50);
        setType(Type.WATER,Type.ROCK);
        addMove(new Confide());
        addMove(new Scratch());
        addMove(new Bulldoze());
    }
    
}
