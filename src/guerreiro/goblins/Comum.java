package guerreiro.goblins;

import guerreiro.Guerreiro;

public class Comum extends Guerreiro {
    
    public Comum(String nome, int idade, double peso) {
        super(nome, idade, peso, 10);
        this.setEnergia(50);
    }

    @Override
    public String toString() {
        return "Goblin Comum: " + super.toString();
    }
    
}
