# 1º Trabalho de Programação Orientada a Objetos I | Prof. Giovany Frossard Teixeira 

## Contextualização

Fomos contratados para desenvolver o jogo “Senhor dos Anéis – A Batalha de
Gundabad”. Nesse jogo, guerreiros são colocados em 2 lados de uma arena. Cada
lado é composto por 1 fila de guerreiros. A cada rodada é feito um sorteio (aleatório)
para definir que lado vai atacar primeiro, cada guerreiro de um lado, por padrão, ataca
apenas uma vez.

Após uma rodada (os guerreiros de ambos lados atacarem), os primeiros
guerreiros vão para o final da fila, os guerreiros seguintes entram no primeiro lugar
na fila e irão lutar na rodada seguinte (repetindo o processo). Se um guerreiro morrer
ele é retirado de sua fila, ou seja, “sai do jogo”. Quando um lado não tiver mais
guerreiros esse lado perdeu.

Alguns tipos de guerreiros podem ter montarias e alguns tipos de montarias
podem atacar.

Nesse jogo orcs e goblins se juntaram para enfrentar elfos e anões, dessa forma
foram definidos 2 lados de batalha:

- **Lado 1:** Orcs e Goblins  
- **Lado 2:** Elfos e Anões  

---

## Desenvolvimento

Primeiramente é necessário definir o que é um Guerreiro. Um Guerreiro é alguém
que luta e possui obrigatoriamente:

- Nome  
- Idade  
- Peso  
- Energia: que deve ser inicializada em 100 no momento da criação do Guerreiro  
  (por padrão os guerreiros possuem energia em 100 unidades)

Guerreiros morrem quando sua energia fica menor ou igual a 0 (nesse caso, por 
padrão são retirados da sua respectiva fila). 

---

## Guerreiros por Povo

### Goblins

1. **Comum:** o Goblin Comum é um Goblin pequeno e frágil (é criado com 50 unidades/pontos
de energia e não com 100 unidades/pontos de energia como um guerreiro padrão), que não
consegue montar e é armado com uma pequena faca. Seu ataque é de apenas 10 pontos de
energia.

2. **Rei Goblin:** o Rei Goblin é uma Goblin grande e resistente (é criado com 300 pontos de
energia). Também não consegue montar e possui um ataque de 100 pontos de energia.
Quando morre ativa sua habilidade especial; a “Convocação dos Globins Comuns Mortos”,
essa habilidade ressuscita os Globins Comuns mortos em rodadas anteriores. O Rei Goblin é
uma unidade única, ou seja, deve existir apenas um indivíduo durante a batalha, se na
entrada de dados for informado mais de um Rei Goblin deve ser feito um tratamento de erro
adequado.

---

### Orcs

3. **Soldado:** unidade de ataque padrão do exército Orc. Possui ataque de 20 pontos de energia e
consegue montar um Warg. Quando montado acaba fazendo 2 ataques, o seu e o ataque do
Warg em que está montado (se o inimigo morrer no ataque do Warg, o Soldado não atacará
nessa rodada e irá para o final da sua fila). Quando morto, libera seu Warg para que possa
ser inserido na fila de guerreiros do seu lado. Uma montaria Warg criada junto com um
Soldado possui os mesmos dados do Soldado (nome, idade e peso) vinculado a ela.

4. **Açougueiro:** unidade devoradora de inimigos. Consegue montar um Warg mas nesse caso o
Warg não ataca, é apenas montaria, se o Açougueiro morre o Warg que ele monta morre
junto com ele. Quando mata alguém, o devora e tem seu ataque aumentado de acordo com a
força de ataque do inimigo. É criado com 200 pontos de energia e possui ataque de 20
pontos de energia. Se estiver com menos de 40 pontos de energia (quase morrendo) devora
seu Warg (se ele tiver um) e recupera 100 pontos de energia. Uma montaria Warg criada
junto com um Açougueiro possui os mesmos dados do Açougueiro (nome, idade e peso)
vinculado a ela.

5. **Warg:** unidade de montaria Orc, similares a lobos gigantes (são os únicos Orcs montáveis).
Possui ataque de 15 pontos de energia, mas ganha mais 5 pontos de energia de ataque para
cada Warg que estiver atrás dele, em sequência na fila (seja um Warg sozinho ou montado
por outro Orc), ou seja, se houver, por exemplo, 3 Wargs em sequência e depois 1 Soldado
(sem montaria), o primeiro vai atacar com 25 pontos, o segundo com 20 pontos e o terceiro,
como não tem atrás dele outro Warg, com 15 pontos de energia.

6. **Senhor das Feras:** consegue gerar uma legião de Wargs. Seu ataque é de 50 pontos de
energia. Ele não monta Wargs, mas cria um para cada inimigo que mata (derrota), ou seja,
quando ele mata alguém ele gera um novo Warg (com seus dados – nome, idade e peso), o
insere no final da fila e se insere logo atrás. O Senhor das Feras é criado com 400 unidades
de energia. 

---

### Elfos

Todo elfo sabe montar e sua montaria é o Cavalo. Cavalos não tem ataque e sofrem o dano
de ataque que seria feito ao Elfo, até que morram. Quando um Cavalo morre, o Elfo que
estava montado nele passa a receber os possíveis ataques (uma vez que não há mais
montaria).  
Um Cavalo é um Guerreiro (apesar de não ter ataque) mas não é um Elfo, se houvessem
humanos no jogo eles também poderiam montar em Cavalos.

1. **Guardião:** unidade padrão no Exército Élfico. Possui ataque de 25 pontos de energia.  
2. **Arqueiro:** unidade de longa distância do Exército Élfico. Acerta todos os inimigos da fila
adversária, mas retira apenas 5 pontos de energia de cada 1.  
3. **Superior:** seu ataque é sempre fatal, independente da quantidade de energia do inimigo.
Possui 500 pontos de energia.  

---

### Anões

4. **Glutão:** anão guerreiro. Possui ataque de 30 pontos de energia. Pode montar um Porco de
Guerra. Uma montaria Porco de Guerra criada junto com um Glutão possui os mesmos
dados do Glutão (nome, idade e peso) vinculado a ela. Quando morto, libera seu Porco de
Guerra para que possa ser inserido na fila de guerreiros do seu lado.  

5. **Porco de Guerra:** o Porco de Guerra não causa dano de ataque, mas quando atacados
espalham a “Praga dos Porcos”, um veneno que retira 5 pontos de energia de cada ataque da
unidade adversária afetada. A “Praga dos Porcos” pode ter seu efeito ampliado em até 3x (se
o adversário atacante atacar 3 Porcos de Guerra), nesse contexto a cada ataque da unidade
adversária ela perderá 15 pontos de energia. Porcos de Guerra são unidades muito
resistentes sendo criados com 250 pontos de energia.  

6. **Imperador:** um Imperador é Glutão Especial tendo ataque e habilidades de montaria
equivalentes (mesmas características), além disso, assim como o Rei Goblin, é uma unidade
única (deve ser feito tratamento de erro adequado se na entrada de dados existirem 2
Imperadores). É criado com 250 pontos de energia. Se for o primeiro a atacar, retira 50
pontos de energia do adversário e o tonteia (não permitindo o contra-ataque).  

---

## Questões

a) (5 pontos) Exiba os dados de ambos lados.  
b) (5 pontos) A soma dos pesos de ambos lados.  
c) (5 pontos) O guerreiro mais velho e sua idade (se houver empate, pode mostrar apenas o primeiro).  
d) (15 pontos) O lado vencedor (“Goblins e Orcs” ou “Elfos e Anões”?).  
e) (5 pontos) Os dados do último membro do lado perdedor.  
f) (5 pontos) Os dados do guerreiro, do lado vencedor, que transferiu o último ataque no último guerreiro do lado perdedor.
