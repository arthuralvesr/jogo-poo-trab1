package guerreiro.orcs;

import guerreiro.Guerreiro;
import guerreiro.GuerreiroMontador;
import java.util.LinkedList;

public class Soldado extends GuerreiroMontador {
    
    public Soldado(String nome, int idade, double peso, GuerreiroMontador montaria) {
        super(nome, idade, peso, 20);
        this.setEnergia(300);
        this.setMontaria(montaria);
    }

    @Override
    public LinkedList<Guerreiro> atacar(LinkedList<Guerreiro> ataque, LinkedList<Guerreiro> defesa, LinkedList<Guerreiro> mortosDefesa, boolean primeiro) {       
        LinkedList<Guerreiro> addFila = super.atacar(ataque, defesa, mortosDefesa, primeiro);
        
        if (!defesa.getFirst().isMorto() && this.montaria != null) {
            LinkedList<Guerreiro> addFilaMontaria = this.montaria.atacar(ataque, defesa, mortosDefesa, primeiro);
            
            addFila.addAll(addFilaMontaria);
        }
        
        return addFila;
    }

    @Override
    public LinkedList<Guerreiro> aoMorrer(LinkedList<Guerreiro> mortosDefesa) {
        LinkedList <Guerreiro> warg = new LinkedList<>();
        
        warg.add(this.montaria);
        
        return warg;
    }
}
