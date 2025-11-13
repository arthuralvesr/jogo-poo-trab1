package arena;

// ---

import guerreiro.Guerreiro;
import guerreiro.anoes.Glutao;
import guerreiro.anoes.Imperador;
import guerreiro.anoes.PorcoDeGuerra;
import guerreiro.elfos.Arqueiro;
import guerreiro.elfos.Guardiao;
import guerreiro.elfos.Superior;
import guerreiro.elfos.Cavalo;
import guerreiro.goblins.Comum;
import guerreiro.goblins.ReiGoblin;
import guerreiro.orcs.Acougueiro;
import guerreiro.orcs.SenhorDasFeras;
import guerreiro.orcs.Soldado;
import guerreiro.orcs.Warg;
import excecoes.ContagemReiGoblin;
import excecoes.ContagemImperador;
import guerreiro.GuerreiroMontador;


//---

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ---

public class LerArquivo {
    
    public static List<Guerreiro> lerGuerreirosLadoGO() {
        String arquivo = "/home/arthur-alves/Poo/trabalho/filaGO.txt";
        List<Guerreiro> guerreirosGO = new ArrayList<>(); // cria uma lista dos guerreiros lidos | Goblins e Orcs
        int contReiGoblin = 0;

        try (Scanner scanner = new Scanner(new File(arquivo))) {

            while(scanner.hasNext()){ // Verifica se ainda existem caracteres
                String linha = scanner.nextLine();
                Scanner leitor = new Scanner(linha);

                int tipo = leitor.nextInt(); 
                String nome = leitor.next();
                int idade = leitor.nextInt();
                int peso = leitor.nextInt();
                String montaria = null;        

                Guerreiro guerreiro;
                GuerreiroMontador montariaGuerreiro = null;
                
                if(leitor.hasNext()) {
                    montaria = leitor.next();
                }
                
                if("Sim".equalsIgnoreCase(montaria)) { // IgnoreCase é caso não tenha nenhum valor, para não quebrar 
                    montariaGuerreiro = new Warg(nome, idade, peso);
                }

                switch (tipo){

                    case 1:
                        guerreiro = new Comum(nome, idade, peso);
                        break;
                    case 2:
                        guerreiro = new ReiGoblin(nome, idade, peso);
                        if (contReiGoblin >= 1) {
                            throw new ContagemReiGoblin("Mais de um Rei Goblin lido");
                        }
                        contReiGoblin++;
                        break;
                    case 3:
                        guerreiro = new Soldado(nome, idade, peso, montariaGuerreiro);
                        break;
                    case 4:
                        guerreiro = new Acougueiro(nome, idade, peso, montariaGuerreiro);
                        break;
                    case 5:
                        guerreiro = new Warg(nome, idade, peso);
                        break;
                    case 6:
                        guerreiro = new SenhorDasFeras(nome, idade, peso);
                        break;
                    default:
                        System.out.println("Tipo invalido");
                        continue;
                }
                guerreirosGO.add(guerreiro); // adiciona na lista o guerreiro lido
            }

        } catch (FileNotFoundException erro) {
            System.out.println("Erro ao ler arquivo: " + arquivo);
            System.exit(1);
        } catch (ContagemReiGoblin e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
        return guerreirosGO;
    }
    
    
    public static List<Guerreiro> lerGuerreirosLadoEA() {
        String arquivo = "/home/arthur-alves/Poo/trabalho/filaEA.txt";
        List<Guerreiro> guerreirosEA = new ArrayList<>(); // cria uma lista dos guerreiros lidos | Elfos e Anoes
        int contImperador = 0;


        try (Scanner scanner = new Scanner(new File(arquivo))) {

            while(scanner.hasNext()){ // Verifica se ainda existem caracteres
                String linha = scanner.nextLine();
                Scanner leitor = new Scanner(linha);

                int tipo = leitor.nextInt(); 
                String nome = leitor.next();
                int idade = leitor.nextInt();
                int peso = leitor.nextInt();
                String montaria = null;        

                Guerreiro guerreiro;
                GuerreiroMontador montariaGuerreiro = null;
                
                if(leitor.hasNext()) {
                    montaria = leitor.next();
                }
                
                if("Sim".equalsIgnoreCase(montaria)) { // IgnoreCase é caso não tenha nenhum valor, para não quebrar 
                    montariaGuerreiro = new Cavalo(nome, idade, peso);
                }

                switch (tipo){

                    case 1:
                        guerreiro = new Guardiao(nome, idade, peso, montariaGuerreiro);
                        break;
                    case 2: 
                        guerreiro = new Arqueiro(nome, idade, peso);
                        break;
                    case 3:
                        guerreiro = new Superior(nome, idade, peso);
                        break;
                    case 4:
                        guerreiro = new Glutao(nome, idade, peso, montariaGuerreiro);
                        break;
                    case 5:
                        guerreiro = new PorcoDeGuerra(nome, idade, peso);
                        break;
                    case 6:
                        guerreiro = new Imperador(nome, idade, peso);
                        if (contImperador >= 1) {
                            throw new ContagemImperador("Mais de um Imperador lido");
                        }
                        contImperador++;
                        break;
                    default:
                        System.out.println("Tipo invalido");
                        continue;
                }

                guerreirosEA.add(guerreiro); // adiciona na lista o guerreiro lido

            }   
            
            
        } catch (FileNotFoundException erro) {
            System.out.println("Erro ao ler arquivo: " + arquivo);
        } catch (ContagemImperador e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
        return guerreirosEA;
    }
    
}
