package guerreiro.goblins;

import arena.Fila;
import guerreiro.Guerreiro;
import java.util.Iterator;

import java.util.LinkedList;

public class ReiGoblin extends Guerreiro{
    
    public ReiGoblin(String nome, int idade, double peso) {
        super(nome, idade, peso, 100);
        this.setEnergia(300);
    }
    
    @Override
    public String toString() {
        return "Rei Goblin: " + super.toString();
    }
    
    @Override
    public LinkedList<Guerreiro> aoMorrer(LinkedList <Guerreiro> mortosDefesa) {
        // ressucitar os goblins mortos
        LinkedList <Guerreiro> goblinsRevividos = new LinkedList<>();
        
        Iterator<Guerreiro> iterator = mortosDefesa.iterator();
        
        while(iterator.hasNext()) {
            Guerreiro morto = iterator.next();
            
            if (morto instanceof Comum) {
                goblinsRevividos.add(morto);
                morto.reviver();
                iterator.remove();  
                
            }
        }

        return goblinsRevividos;
    }
    
}
