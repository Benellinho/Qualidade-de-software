# Resumo das Funcoes do Projeto

Este arquivo resume as funcoes e metodos do projeto `JogoQualidade`, separados por arquivo, com descricao, entrada e saida.

## Arquivo: `JogoQualidade/Arma.cs`

### Classe `Arma`

Este arquivo nao possui funcoes ou metodos. Ele define apenas a estrutura de uma arma:

- `Nome`: nome da arma.
- `Dano`: dano base da arma.
- `Mod`: modificacao aplicada na arma.

## Arquivo: `JogoQualidade/Inimigo.cs`

### `GeraTipos()`

- O que faz: cria e retorna uma lista fixa com tipos de inimigos base do jogo.
- Input: nenhum.
- Output: `List<Inimigo>` com inimigos predefinidos.

### `Ataca(Personagem p1)`

- O que faz: tenta atacar o personagem informado. Se o ataque acertar, reduz a vida do personagem com base no dano do inimigo e nas defesas do personagem e das armas.
- Input: `Personagem p1`, personagem que recebera o ataque.
- Output: nenhum retorno (`void`). O metodo altera o estado de `p1` e escreve mensagens no console.

### `Clone()`

- O que faz: cria uma copia do inimigo atual com os mesmos atributos.
- Input: nenhum.
- Output: `Inimigo` novo, com os mesmos valores do inimigo original.

## Arquivo: `JogoQualidade/Leitor.cs`

### `LeArqGen(string dir)`

- O que faz: metodo reservado para leitura generica de arquivo, mas atualmente esta vazio e nao executa nenhuma acao.
- Input: `string dir`, caminho do arquivo ou diretorio.
- Output: nenhum retorno (`void`).

## Arquivo: `JogoQualidade/Modificacao.cs`

### `GeraRandom()`

- O que faz: gera uma modificacao com valores aleatorios para dano, velocidade, defesa e esquiva.
- Input: nenhum.
- Output: `Modificacao` preenchida com valores aleatorios.

## Arquivo: `JogoQualidade/Partida.cs`

### `Initialize()`

- O que faz: inicializa a partida, gera os tipos de inimigo e cria a masmorra com salas aleatorias.
- Input: nenhum.
- Output: nenhum retorno (`void`). O metodo altera os atributos internos da partida.

### `AndaSala(int direcao)`

- O que faz: move a partida para a proxima sala ou para a sala anterior, dependendo da direcao informada e dos limites da masmorra.
- Input: `int direcao`.
- Output: nenhum retorno (`void`). O metodo altera o indice da sala atual.

### `Combate(Personagem p1)`

- O que faz: controla o fluxo de combate entre o personagem e os inimigos da sala atual, lendo a acao escolhida no console.
- Input: `Personagem p1`, personagem que participara do combate.
- Output: nenhum retorno (`void`). O metodo altera o estado do personagem, dos inimigos e escreve mensagens no console.

### `Decisao(int C, Personagem p1)`

- O que faz: interpreta a escolha do jogador e executa a acao correspondente, como andar, checar status da sala, checar personagem ou iniciar combate.
- Input: `int C`, codigo da acao escolhida; `Personagem p1`, personagem atual.
- Output: nenhum retorno (`void`). Pode alterar o estado da partida e do personagem.

### `Jogo()`

- O que faz: executa o loop principal do jogo. Permite escolher personagem e repetir as acoes ate o jogador desistir.
- Input: nenhum.
- Output: nenhum retorno (`void`). O metodo controla a execucao principal do jogo pelo console.

## Arquivo: `JogoQualidade/Personagem.cs`

### `Checagem()`

- O que faz: mostra no console os atributos atuais do personagem, considerando tambem os bonus das armas e modificacoes.
- Input: nenhum.
- Output: nenhum retorno (`void`). Apenas escreve informacoes no console.

### `PegaDanoTotal()`

- O que faz: calcula o dano total do personagem somando dano base, dano das armas e dano das modificacoes.
- Input: nenhum.
- Output: `int` com o dano total calculado.

### `PegaEsquivaTotal()`

- O que faz: calcula a esquiva total do personagem somando a esquiva base e os bonus das modificacoes equipadas.
- Input: nenhum.
- Output: `int` com a esquiva total calculada.

### `Ataque(Inimigo n1)`

- O que faz: tenta atacar o inimigo informado. Se acertar, reduz a vida do inimigo com base no dano total do personagem e na defesa do inimigo.
- Input: `Inimigo n1`, inimigo alvo do ataque.
- Output: nenhum retorno (`void`). O metodo altera a vida do inimigo e escreve mensagens no console.

### `DefinePersonagem(int s)`

- O que faz: configura os atributos iniciais do personagem com base na opcao escolhida.
- Input: `int s`, identificador da classe/personagem escolhido.
- Output: nenhum retorno (`void`). O metodo altera os atributos do personagem atual.

## Arquivo: `JogoQualidade/Program.cs`

### `Main()`

- O que faz: ponto de entrada do programa. Cria uma partida, inicializa a estrutura do jogo e inicia o loop principal.
- Input: nenhum.
- Output: nenhum retorno (`void`).

## Arquivo: `JogoQualidade/Sala.cs`

### `Checagem()`

- O que faz: mostra no console a quantidade de modificacoes, armas e inimigos presentes na sala.
- Input: nenhum.
- Output: nenhum retorno (`void`). Apenas escreve informacoes no console.

### `MostraInimigos()`

- O que faz: lista no console os inimigos da sala com indice, nome e vida.
- Input: nenhum.
- Output: nenhum retorno (`void`). Apenas escreve informacoes no console.

### `InimigosAtacam(Personagem p1)`

- O que faz: percorre a lista de inimigos da sala e faz cada inimigo vivo atacar o personagem. Inimigos com vida menor ou igual a zero sao removidos.
- Input: `Personagem p1`, alvo dos ataques.
- Output: nenhum retorno (`void`). O metodo altera a lista de inimigos e possivelmente a vida do personagem.

### `GeraSala(List<Inimigo> Tipos, int qtdInimigos, int qtdMods, int qtdArmas)`

- O que faz: cria uma nova sala com uma quantidade aleatoria de inimigos clonados a partir dos tipos recebidos e adiciona modificacoes aleatorias.
- Input: `List<Inimigo> Tipos`, lista de tipos disponiveis; `int qtdInimigos`, quantidade de inimigos; `int qtdMods`, quantidade de modificacoes; `int qtdArmas`, quantidade de armas.
- Output: `Sala` nova, preenchida com os elementos gerados.

### `AvancaIndex(int qual)`

- O que faz: avanca o indice atual de visualizacao de modificacoes ou armas, dependendo do valor recebido.
- Input: `int qual`, indica se o metodo deve avancar em modificacoes ou armas.
- Output: nenhum retorno (`void`). O metodo altera os indices internos da sala.
