using System.Formats.Asn1;
using System.Security.Cryptography;

namespace JogoQualidade;

public class Partida
{
    // Responsável por criar uma partida. É a partir dessa classe que todos os inimigos e salas serão inicializados.
    // Para inimigos, seus tipos são aqui inicializados
    // Para salas, aqui elas são inicializadas e guardadas na masmorra, que representa o progresso do jogador.
    int Pontuacao{get; set;}
    int SalaAtual{get; set;}
    List<Inimigo> Tipos{get; set;} = [];
    List<Sala> Masmorra{get;set;} = [];

    public void Initialize()
    {
        Tipos = Inimigo.GeraTipos();
        Random random = new(); 
        for(int i = 0 ; i < random.Next(3, 5); i++)
        {
            int qtdInimigos = random.Next(3,5);
            int qtdMods = random.Next(1,3);
            int qtdArmas = random.Next(0,2);
            Masmorra.Add(new Sala().GeraSala(this.Tipos, qtdInimigos, qtdMods, qtdArmas));
            //Masmorra[i].GeraSala(this.Tipos, random.Next(0,3), random.Next(0,2), random.Next(1, 3));
        }
    }

    public void AndaSala(int direcao)
    {
        if(direcao == 1 && this.SalaAtual+1 < this.Masmorra.Count)
        {
            this.SalaAtual++;
        } 
        else if (this.SalaAtual-1 >= 0)
        {
            this.SalaAtual--;
        }
    }

    public void Combate(Personagem p1)
    {
        int Acao;
        do
        {
            Console.WriteLine("Em combate\n1- Atacar\n2- Defender\n3- Fugir");
            Acao = Convert.ToInt32(Console.ReadLine());
            switch (Acao)
            {
                case 1:
                    this.Masmorra[this.SalaAtual].MostraInimigos();
                    Acao = Convert.ToInt32(Console.ReadLine());
                    
                    if(Acao > this.Masmorra[this.SalaAtual].Inimigos.Count)
                    {
                        Acao = this.Masmorra[this.SalaAtual].Inimigos.Count-1;
                    } else if(Acao < 0)
                    {
                        Acao = 0;
                    }

                    p1.Ataque(this.Masmorra[this.SalaAtual].Inimigos[Acao]);
                    this.Masmorra[this.SalaAtual].InimigosAtacam(p1);
                    break;
                case 2:
                    p1.Defesa *= 2;
                    this.Masmorra[this.SalaAtual].InimigosAtacam(p1);
                    break;
                case 3:
                    Console.WriteLine("Você recua temporariamente");
                    Acao = -1;
                    break;
                default:
                    break;
            }
            // Se não houver mais inimigos vivos, encerrar o combate e garantir que não possa ser iniciado novamente.
        }while(Acao != -1 && this.Masmorra[this.SalaAtual].Inimigos.Count > 0);
        Console.WriteLine("Sala Limpa!");
    }

    public void Decisao(int C, Personagem p1)
    {
        switch (C)
        {
            case 0:
                Console.WriteLine("Você pode fugir da masmorra, mas eu sei que você vai voltar em breve");
                Console.WriteLine("Fim de jogo");
                break;
            case 1:
                if(this.Masmorra[this.SalaAtual].Inimigos.Count > 0)
                {
                    Console.WriteLine("Vá lutar!");
                }else
                {
                    AndaSala(1);
                }
                break;
            case 2:
                AndaSala(0);
                break;
            case 3:
                p1.Checagem();
                break;
            case 4:
                this.Masmorra[this.SalaAtual].Checagem();
                break;
            case 5:
                this.Combate(p1);
                break;
            default:
                Console.WriteLine("Escolhe uma ação que exista, nmrl");
                break;                
        }
    }

    public void Jogo()
    {
        Console.WriteLine("Iniciando...\nEscolha seu personagem (1 - 3): ");
        int C = Convert.ToInt32(Console.ReadLine());
        Personagem p1 = new();
        p1.DefinePersonagem(C);

        do
        {
            Console.WriteLine("Vida: {0} Energia: {1}", p1.Vida, p1.Energia);
            Console.WriteLine("0- Desistir\n1- Próxima Sala\n2- Voltar Sala\n3- Checagem Pessoal\n4- Checagem da Sala\n5- Combate");
            C = Convert.ToInt32(Console.ReadLine());
            //Console.WriteLine("Aqui: {0}", C);
            this.Decisao(C, p1);
        }while(C != 0);
    }
}