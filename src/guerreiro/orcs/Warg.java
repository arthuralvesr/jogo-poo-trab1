package guerreiro.orcs;

import guerreiro.Guerreiro;
import guerreiro.GuerreiroMontador;
import java.util.LinkedList;

public class Warg extends GuerreiroMontador {
    
    public Warg(String nome, int idade, double peso) {
        super(nome, idade, peso, 15);
        this.setEnergia(30);
    }

    @Override
    public LinkedList<Guerreiro> atacar(LinkedList<Guerreiro> ataque, LinkedList<Guerreiro> defesa, LinkedList<Guerreiro> mortosDefesa, boolean primeiro) {
        int contWarg = 0;
        
        for(int i = 1; i < ataque.size(); i++){
            Guerreiro ver = ataque.get(i);
            
            if(ver instanceof Warg) {
                contWarg++;
            } else {
                break;
            }
        }
        
        Guerreiro defensor = defesa.getFirst();
        
        return defensor.reduzirEnergia(this.ataque + (5 * contWarg), mortosDefesa, ataque, defesa);
    }
    
    
    
}
