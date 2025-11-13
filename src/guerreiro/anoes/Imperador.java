package guerreiro.anoes;

import guerreiro.Guerreiro;
import java.util.LinkedList;

public class Imperador extends Guerreiro {

    public Imperador(String nome, int idade, double peso) {
        super(nome, idade, peso, 50);
        this.setEnergia(250);
    }

    @Override
    public LinkedList<Guerreiro> atacar(LinkedList<Guerreiro> ataque, LinkedList<Guerreiro> defesa, LinkedList<Guerreiro> mortosDefesa, boolean primeiro) {
        Guerreiro defensor = defesa.getFirst();
        LinkedList<Guerreiro> addFila = new LinkedList<>();

        if (primeiro == true) {
            addFila.addAll(super.atacar(ataque, defesa, mortosDefesa, primeiro));
            defensor.setTonto(true);
               
        } else {
            
            addFila.addAll(super.atacar(ataque, defesa, mortosDefesa, primeiro));
        }
        
        return addFila;
    }
    
}
