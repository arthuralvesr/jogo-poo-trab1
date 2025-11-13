package guerreiro.elfos;

import guerreiro.Guerreiro;
import guerreiro.GuerreiroMontador;
import java.util.LinkedList;

public class Superior extends Elfos {

    public Superior(String nome, int idade, double peso, Guerreiro montaria) {
        super(nome, idade, peso, 1, montaria);
        this.setEnergia(500);
    }

    @Override
    public LinkedList<Guerreiro> atacar(LinkedList<Guerreiro> ataque, LinkedList<Guerreiro> defesa, LinkedList<Guerreiro> mortosDefesa, boolean primeiro) {
        Guerreiro defensor = defesa.getFirst();
        
        LinkedList<Guerreiro> addFila = defensor.reduzirEnergia((defensor.getEnergia() + 1), mortosDefesa, ataque, defesa); 
      
        return addFila;
    }
    
    
}
