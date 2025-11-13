package guerreiro.elfos;

import guerreiro.Guerreiro;
import guerreiro.GuerreiroMontador;
import java.util.LinkedList;

public class Arqueiro extends Elfos {

    public Arqueiro(String nome, int idade, double peso, Guerreiro montaria) {
        super(nome, idade, peso, 5, montaria);
    }

    @Override
    public LinkedList<Guerreiro> atacar(LinkedList<Guerreiro> ataque, LinkedList<Guerreiro> defesa, LinkedList<Guerreiro> mortosDefesa, boolean primeiro) {
        LinkedList<Guerreiro> addFila = new LinkedList<>();
        
        for (Guerreiro g : defesa) {
            LinkedList<Guerreiro> resultadoDoDefensor = g.reduzirEnergia(this.ataque, mortosDefesa, ataque, defesa); 
            
            addFila.addAll(resultadoDoDefensor);
        }
        
        return addFila;
    }
    
    
    
}
