package guerreiro.orcs;

import guerreiro.Guerreiro;
import java.util.LinkedList;

public class SenhorDasFeras extends Guerreiro {

    public SenhorDasFeras(String nome, int idade, double peso) {
        super(nome, idade, peso, 50);
        this.setEnergia(400);
    }

    @Override
    public LinkedList<Guerreiro> atacar(LinkedList<Guerreiro> ataque, LinkedList<Guerreiro> defesa, LinkedList<Guerreiro> mortosDefesa, boolean primeiro) {
        LinkedList<Guerreiro> addFila = super.atacar(ataque, defesa, mortosDefesa, primeiro);
        
        Guerreiro atacante = ataque.getFirst();
        Guerreiro defensor = defesa.getFirst();
        
        if (defensor.isMorto()) {
            Guerreiro warg = new Warg(atacante.getNome(), atacante.getIdade(), atacante.getPeso());
            addFila.add(warg);
        }
        
        return addFila;
    }
    
    
 
    
}
