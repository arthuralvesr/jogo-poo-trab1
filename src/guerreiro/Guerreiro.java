package guerreiro;

// ---

import java.util.LinkedList;


public abstract class Guerreiro {
    
    protected final String nome;
    protected int idade;
    protected double peso;
    protected int energia;
    protected int ataque;
    protected boolean morto;
    protected boolean tonto;
    protected int envenenado;

    public Guerreiro(String nome, int idade, double peso, int ataque) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.energia = 100;
        this.ataque = ataque;
        this.morto = false;
        this.tonto = false;
        this.envenenado = 0;
    }

    public void setEnvenenado(int envenenado) {
        this.envenenado = envenenado;
    }

    public int getEnvenenado() {
        return envenenado;
    }

    public boolean isTonto() {
        return tonto;
    }

    public void setTonto(boolean tonto) {
        this.tonto = tonto;
    }

    public boolean isMorto() {
        return morto;
    }

    public void matar() {
        this.morto = true;
    }
    
    public void reviver() {
        this.morto = false;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    public LinkedList <Guerreiro> atacar(LinkedList<Guerreiro> ataque, LinkedList <Guerreiro> defesa, LinkedList <Guerreiro> mortosDefesa, boolean primeiro) {
        Guerreiro defensor = defesa.getFirst();
        
        LinkedList<Guerreiro> addFila = new LinkedList<>();
        
        if (this.getEnvenenado() > 0) {
            this.reduzirEnergia((5 * this.getEnvenenado()), mortosDefesa, ataque, defesa);
           
        }
        
        if(!defensor.isMorto()) {
            addFila.addAll(defensor.reduzirEnergia(this.ataque, mortosDefesa, ataque, defesa)); 
            
        }        
        
        System.out.println("Atacante: " + this.nome + " atingiu " + defensor.getNome() + " com " + this.ataque + " " + this.energia + " | energia final " + defensor.getEnergia());
        
        System.out.println(); 
        
        
        if (defensor instanceof GuerreiroMontador) {
            GuerreiroMontador g = null;
            if (g != null) {
                System.out.println("Montaria: " + g.getMontaria().getNome() + " vida: " + g.getMontaria().getEnergia());
            }
        } 
        
        return addFila;
    }
    
    @Override
    public String toString() {
        return nome + ", " + idade + ", " + peso;
    }
    
    public LinkedList <Guerreiro> reduzirEnergia(int danoAtaque, LinkedList <Guerreiro> mortosDefesa, LinkedList<Guerreiro> ataque, LinkedList <Guerreiro> defesa) {
        this.energia -= danoAtaque;
        
        if(this.energia <= 0) {
            this.energia = 0;
            this.matar();
            return this.aoMorrer(mortosDefesa);   
        }
        
        return new LinkedList<>();
    }
    
    public LinkedList<Guerreiro> aoMorrer(LinkedList <Guerreiro> mortosDefesa) {
        return new LinkedList<>();
    }
}
