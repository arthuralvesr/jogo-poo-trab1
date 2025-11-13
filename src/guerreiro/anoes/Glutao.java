package guerreiro.anoes;

import guerreiro.Guerreiro;
import guerreiro.GuerreiroMontador;
import java.util.LinkedList;

public class Glutao extends GuerreiroMontador {

    public Glutao(String nome, int idade, double peso, GuerreiroMontador montaria) {
        super(nome, idade, peso, 30);
        this.setMontaria(montaria);
    }

    @Override
    public LinkedList<Guerreiro> aoMorrer(LinkedList<Guerreiro> mortosDefesa) {
        LinkedList <Guerreiro> porcoDeGuerra = new LinkedList<>();
        
        porcoDeGuerra.add(this.montaria);
        
        return porcoDeGuerra;
    }
    
    
    
}
