package guerreiro;

public abstract class GuerreiroMontador extends Guerreiro {
    
    protected Guerreiro montaria;

    public GuerreiroMontador(String nome, int idade, double peso, int ataque) {
        super(nome, idade, peso, ataque);
        this.montaria = null;
    }

    public Guerreiro getMontaria() {
        return montaria;
    }

    public void setMontaria(Guerreiro montaria) {
        this.montaria = montaria;
    }
     
}
