package arena;

// ---

import guerreiro.Guerreiro;

// ---

import java.util.LinkedList;
import java.util.List;

public class Fila {
    private LinkedList<Guerreiro> filaGO = new LinkedList<>();
    private LinkedList<Guerreiro> filaEA = new LinkedList<>();
    private LinkedList<Guerreiro> filaMortosGO = new LinkedList<>();
    private LinkedList<Guerreiro> filaMortosEA = new LinkedList<>();

    public LinkedList<Guerreiro> getFilaMortosGO() {
        return filaMortosGO;
    }

    public void addFilaMortosGO(Guerreiro guerreiro) {
        this.filaMortosGO.add(guerreiro);
    }

    public LinkedList<Guerreiro> getFilaMortosEA() {
        return filaMortosEA;
    }

    public void addFilaMortosEA(Guerreiro guerreiro) {
        this.filaMortosEA.add(guerreiro);
    }

    public LinkedList<Guerreiro> getFilaGO() {
        return filaGO;
    }

    public void addFilaGO(Guerreiro guerreiro) {
        this.filaGO.add(guerreiro);
    }

    public LinkedList<Guerreiro> getFilaEA() {
        return filaEA;
    }

    public void addFilaEA(Guerreiro guerreiro) {
        this.filaEA.add(guerreiro);
    }
    
    public void removerDefensor(LinkedList <Guerreiro> fila) {
        
    }

    protected void iniciarFilas(){
        System.out.println("Filas iniciadas");
        
        criarFilaGO();
        criarFilaEA();
    }
    
    private void criarFilaGO() { // fila de Goblins e Orcs
        
        List<Guerreiro> listaGO = LerArquivo.lerGuerreirosLadoGO();
        
        for(int i = 0; i < listaGO.size(); i++) {
            addFilaGO(listaGO.get(i));
        }
    }
    
    private void criarFilaEA() { // fila de Elfos e Anoes
        
        List <Guerreiro> listaEA = LerArquivo.lerGuerreirosLadoEA();
        
        for(int i = 0; i < listaEA.size(); i++) {
            addFilaEA(listaEA.get(i));
        }
    }

}
