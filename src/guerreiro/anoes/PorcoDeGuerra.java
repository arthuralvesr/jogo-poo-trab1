package guerreiro.anoes;

import guerreiro.Guerreiro;
import java.util.LinkedList;

public class PorcoDeGuerra extends Guerreiro {

    public PorcoDeGuerra(String nome, int idade, double peso) {
        super(nome, idade, peso, 0);
        this.setEnergia(250);
    }
    
    @Override
    public LinkedList<Guerreiro> atacar(LinkedList<Guerreiro> ataque, LinkedList<Guerreiro> defesa, LinkedList<Guerreiro> mortosDefesa, boolean primeiro) {
        return null;
    }
    
    @Override
    public LinkedList<Guerreiro> reduzirEnergia(int danoAtaque, LinkedList<Guerreiro> mortosDefesa, LinkedList<Guerreiro> ataque, LinkedList <Guerreiro> defesa) {
        
        if(this.getEnvenenado() > 3) {
        } else {
           this.envenenado++; 
        }
       
        LinkedList<Guerreiro> addFila = super.reduzirEnergia(danoAtaque, mortosDefesa, ataque, defesa);
         
        return addFila;
    }
}
