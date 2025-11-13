package guerreiro.elfos;

import guerreiro.Guerreiro;
import guerreiro.GuerreiroMontador;
import java.util.LinkedList;

public class Elfos extends GuerreiroMontador {
    
    public Elfos(String nome, int idade, double peso, int ataque, Guerreiro montaria) {
        super(nome, idade, peso, ataque);
        this.setMontaria(montaria);
    }
    
    
    @Override
    public LinkedList <Guerreiro> reduzirEnergia(int dano, LinkedList <Guerreiro> mortosDefesa, LinkedList<Guerreiro> ataque, LinkedList <Guerreiro> defesa) {
        
        if(this.montaria == null || this.montaria.isMorto()){
            super.reduzirEnergia(dano, mortosDefesa, ataque, defesa);
            
        } else {
            this.montaria.setEnergia(this.montaria.getEnergia() - dano);
            
            if(this.montaria.getEnergia() <= 0) {
                this.montaria.setEnergia(0);
                this.montaria.matar();
            }
        }
        
        return new LinkedList<>();
    }
}
