package guerreiro.orcs;

import guerreiro.Guerreiro;
import guerreiro.GuerreiroMontador;

import java.util.LinkedList;

public class Acougueiro extends GuerreiroMontador {

    public Acougueiro(String nome, int idade, double peso, GuerreiroMontador montaria) {
        super(nome, idade, peso, 20);
        this.setEnergia(50);
        this.setMontaria(montaria);
    }

    @Override
    public LinkedList<Guerreiro> reduzirEnergia(int danoAtaque, LinkedList<Guerreiro> mortosDefesa, LinkedList<Guerreiro> ataque, LinkedList <Guerreiro> defesa) {
        LinkedList<Guerreiro> addFila = super.reduzirEnergia(danoAtaque, mortosDefesa, ataque, defesa); 
        
        if (!this.isMorto() && this.energia < 40 && this.montaria != null){
            this.montaria.matar();
            this.setEnergia(this.energia + 100);
        }
        
        return addFila;
    }
    
    
    
}
