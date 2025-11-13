package arena;

// ---

import guerreiro.Guerreiro;
import guerreiro.GuerreiroMontador;
import guerreiro.orcs.SenhorDasFeras;

// ---

import java.util.Random;
import java.util.LinkedList;

// ---

public class Arena {
    private Fila fila;
    
    public static void main(String[] args) {
        Arena arena = new Arena();
        arena.fila = new Fila();
        
        arena.iniciarGuerra();
    }
    
    public void iniciarGuerra() {
        fila.iniciarFilas();
        int round = 1;
        
        LinkedList <Guerreiro> filaGO = fila.getFilaGO();
        LinkedList <Guerreiro> filaEA = fila.getFilaEA();
        LinkedList <Guerreiro> filaMortosGO = fila.getFilaMortosGO();
        LinkedList <Guerreiro> filaMortosEA = fila.getFilaMortosEA();
        
        // exibir dados de cada lado
        System.out.println("a)");
        System.out.println("LADO 1:");
        exibirDados(filaGO);
        
        System.out.println();
        
        System.out.println("LADO 2:");
        exibirDados(filaEA);
        System.out.println();
        
        // soma dos pesos de ambos lados       
        System.out.println("b)");
        System.out.println("\tGoblins e Orcs pesam " + somarPesos(filaGO) + " kilos.");
        System.out.println("\tElfos e Anoes pesam " + somarPesos(filaEA) + " kilos.");
        System.out.println();
        

        // Guerreiro mais velho:        
        System.out.println("c)");
        guerreiroMaisVelho(filaGO, filaEA);
        
        
        // batalha
        while (!filaGO.isEmpty() && !filaEA.isEmpty()) {
            // System.out.println("Round: " + round);
            int sorteio = sorteio();
            boolean primeiro = true;
            
            if (sorteio == 1) {
                realizarAtaque(filaGO, filaEA, filaMortosEA, primeiro);
                
                if (!filaEA.isEmpty() && !filaEA.getFirst().isMorto()) { // so contra ataca se o primeiro nao morrer
                    primeiro = false;
                    realizarAtaque(filaEA, filaGO, filaMortosGO, primeiro);
                }
  
            } else {
                realizarAtaque(filaEA, filaGO, filaMortosGO, primeiro);
                
                if (!filaGO.isEmpty() && !filaGO.getFirst().isMorto()) { // so contra ataca se o primeiro nao morrer
                    primeiro = false;
                    realizarAtaque(filaGO, filaEA, filaMortosEA, primeiro);
                }  
            }
            
            rotacionarFilas(filaGO, filaEA); // rotaciono a fila, mesmo com os mortos
            
            limparMortos(filaGO, filaEA, filaMortosGO, filaMortosEA); // limpo os mortos
            
            if(filaGO.isEmpty() || filaEA.isEmpty()){
                // System.out.println("Final da batalha");
                break;
            }
            
            round++;
        } 
          
        // lado vencedor
        System.out.println();
        System.out.println("d)");
        ladoVencedor(filaGO, filaEA);
        
        // dado do ultimo membro do lado perdedor e dados do ultimo ataque do lado vencedor
        System.out.println();
        dadosUltimos(filaGO, filaEA, filaMortosGO, filaMortosEA);
    }

    private void exibirDados(LinkedList <Guerreiro> fila){
        
        for(Guerreiro g : fila){
            System.out.println("\t " + g.toString());
            
            /* if (g instanceof GuerreiroMontador){
                GuerreiroMontador montado = (GuerreiroMontador) g; // casting explicito para falar que e montador
                
                if(montado.getMontaria() != null) {
                    System.out.println("\tMontaria: " + montado.getMontaria());
                } 
            } */
            
        }
    }
    
    private double somarPesos(LinkedList <Guerreiro> fila) {
        double pesoFila = 0;
        
        for(Guerreiro g : fila){
            pesoFila += g.getPeso();
        }
        
        return pesoFila;
    }
    
    private void guerreiroMaisVelho(LinkedList<Guerreiro> filaGO, LinkedList<Guerreiro> filaEA){
        Guerreiro maisVelho = filaGO.getFirst();
        
        for (Guerreiro g : filaGO) {
            if (g.getIdade() > maisVelho.getIdade()) {
                maisVelho = g;
            }
        }
        
        for (Guerreiro g : filaEA) {
            if (g.getIdade() > maisVelho.getIdade()) {
                maisVelho = g;
            }
        }
        
        System.out.println("\tO " + maisVelho.getClass().getSimpleName() + " " + maisVelho.getNome() + " é o mais velho");
        
    }

    private void realizarAtaque(LinkedList<Guerreiro> ataque, LinkedList <Guerreiro> defesa, LinkedList <Guerreiro> mortosDefesa, boolean primeiro) {
        Guerreiro atacante = ataque.getFirst();
        LinkedList <Guerreiro> addFila = new LinkedList<>();
        
        if(!atacante.isTonto()) {
            addFila.addAll(atacante.atacar(ataque, defesa, mortosDefesa, primeiro));
        }
        
        if (atacante instanceof SenhorDasFeras) { // se for o senhor das feras o atacante, o warg deve ser adicionado na fila dele
            ataque.addAll(addFila);
        } else {
            defesa.addAll(addFila);
        }
        
        atacante.setTonto(false); // reseta o tonto pos tentativa de ataqueá
    }
        
    private void limparMortos(LinkedList<Guerreiro> filaGO, LinkedList <Guerreiro> filaEA, LinkedList<Guerreiro> filaMortosGO, LinkedList <Guerreiro> filaMortosEA) {
        
        for(Guerreiro g : filaGO){
            if(g.isMorto()) {
                filaGO.remove(g);
                filaMortosGO.add(g);
            }
        }
        
        for(Guerreiro g : filaEA){
            if(g.isMorto()) {
                filaEA.remove(g);
                filaMortosEA.add(g);
            }
        }
    }
    
    private void rotacionarFilas(LinkedList<Guerreiro> filaGO, LinkedList <Guerreiro> filaEA) {
        
        Guerreiro trocadoGO = filaGO.getFirst();
        filaGO.addLast(trocadoGO);
        filaGO.removeFirst();
        
        Guerreiro trocadoEA = filaEA.getFirst();
        filaEA.addLast(trocadoEA);
        filaEA.removeFirst();
    }
    
    private void ladoVencedor(LinkedList<Guerreiro> filaGO, LinkedList <Guerreiro> filaEA) {

        if(filaEA.isEmpty()) {
            System.out.println("\tGoblins e Orcs venceram");
        } else if (filaGO.isEmpty() ) {
            System.out.println("\tElfos e anoes venceram");
        } else {
            System.out.println("\tEmpate");
        }
    }
    
    private void dadosUltimos(LinkedList<Guerreiro> filaGO, LinkedList <Guerreiro> filaEA, LinkedList<Guerreiro> filaMortosGO, LinkedList <Guerreiro> filaMortosEA){
        
        if(filaEA.isEmpty()) {
            Guerreiro ultimoPerdedor = filaMortosEA.getLast();
            Guerreiro ultimoVencedor = filaGO.getLast();
            
            System.out.println("e)");
            System.out.println("\tO " + ultimoPerdedor.getClass().getSimpleName() + " " + ultimoPerdedor.getNome() + " de " + ultimoPerdedor.getIdade() + " anos e " + ultimoPerdedor.getPeso() + " kilos foi o ultimo a ser derrotado no lado Elfos e Anoes");
            System.out.println();
            System.out.println("f)");
            System.out.println("\tO " + ultimoVencedor.getClass().getSimpleName() + " " + ultimoVencedor.getNome() + " de " + ultimoVencedor.getIdade() + " anos e " + ultimoVencedor.getPeso() + " kilos transferiu o ultimo ataque no " + ultimoPerdedor.getClass().getSimpleName() + " " + ultimoPerdedor.getNome() + " de " + ultimoPerdedor.getIdade() + " anos e " + ultimoPerdedor.getPeso() + " kilos");
            
        } else if (filaGO.isEmpty() ) {
            Guerreiro ultimoPerdedor = filaMortosGO.getLast();
            Guerreiro ultimoVencedor = filaEA.getLast();
            
            System.out.println("e)");
            System.out.println("\tO " + ultimoPerdedor.getClass().getSimpleName() + " " + ultimoPerdedor.getNome() + " de " + ultimoPerdedor.getIdade() + " anos e " + ultimoPerdedor.getPeso() + " kilos foi o ultimo a ser derrotado no lado Goblins e Orcs");
            System.out.println();
            System.out.println("f)");
            System.out.println("\tO " + ultimoVencedor.getClass().getSimpleName() + " " + ultimoVencedor.getNome() + " de " + ultimoVencedor.getIdade() + " anos e " + ultimoVencedor.getPeso() + " kilos transferiu o ultimo ataque no " + ultimoPerdedor.getClass().getSimpleName() + " " + ultimoPerdedor.getNome() + " de " + ultimoPerdedor.getIdade() + " anos e " + ultimoPerdedor.getPeso() + " kilos");
            
        } else {
            Guerreiro ultimoPerdedorGO = filaMortosGO.getLast();
            Guerreiro ultimoPerdedorEA = filaMortosEA.getLast();
            
            System.out.println("e)");
            System.out.println(ultimoPerdedorGO.toString() + " foi o ultimo a ser derrotado no lado Goblins e Orcs");
            System.out.println();
            System.out.println("e)");
            System.out.println(ultimoPerdedorEA.toString() + " foi o ultimo a ser derrotado no lado Elfos e Anoes");
        }
        
    }
    
    private static int sorteio() {
        Random rand = new Random();
        return rand.nextInt(2); // gera 0 ou 1 | 1 = GO - 0 = EA
    }
    
    
}   

