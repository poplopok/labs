import pokemons.*;
import ru.ifmo.se.pokemon.*;
public class Main {
    public static void main(String[] args){
        Battle b=new Battle();
        Sawk sawk=new Sawk("Клименков",1);
        Binacle binacle=new Binacle("Говард",1);
        Barbaracle barbaracle=new Barbaracle("Доминик",2);
        Cleffa cleffa=new Cleffa("Дуник",1);
        Clefairy clefairy=new Clefairy("Пак",2);
        Clefable clefable=new Clefable("Джордж",3);
        b.addAlly(sawk);
        b.addAlly(binacle);
        b.addAlly(barbaracle);
        b.addFoe(cleffa);
        b.addFoe(clefairy);
        b.addFoe(clefable);
        b.go();
    }
}