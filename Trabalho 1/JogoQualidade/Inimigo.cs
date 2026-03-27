public class Inimigo
{
    // Inimigo. Vai aparecer em masmorras. 
    public string? Nome{get;set;}
    public int Dano{get;set;}
    public int Vida{get;set;}
    public int Defesa{get;set;}
    public int Esquiva{get;set;}
    public int Pontos{get; set;}

    public static List<Inimigo> GeraTipos()
    {
        List<Inimigo> l1 = [new Inimigo{Nome = "Night Lurker Dog", Dano = 5, Vida = 30, Defesa = 5, Esquiva = 1, Pontos = 10}, new Inimigo{Nome = "KoroKoro", Dano = 10, Vida = 70, Defesa = 10, Esquiva = 0, Pontos = 25}, new Inimigo{Nome = "Transtornado", Dano = 20, Vida = 40, Defesa = 7, Esquiva = 2, Pontos = 35}];
        return l1;
    }

    public void Ataca(Personagem p1)
    {
        Random teste = new();
        if(teste.Next(1, 10) >= p1.PegaEsquivaTotal())
        {
            Console.WriteLine("Atingido!");
            p1.Vida -= this.Dano-p1.Defesa-p1.Primaria.Mod.Defesa-p1.Secundaria.Mod.Defesa;
            Console.WriteLine("Você recebeu {0} pontos de dano. Restam {1} pontos de vida", this.Dano-p1.Defesa-p1.Primaria.Mod.Defesa-p1.Secundaria.Mod.Defesa, p1.Vida);
            
        } else
        {
            Console.WriteLine("Esquivou!");
        }
    }

    public Inimigo Clone()
    {
        Inimigo copia = new Inimigo
        {
            Nome = this.Nome, 
            Dano = this.Dano, 
            Vida = this.Vida, 
            Defesa = this.Defesa, 
            Esquiva = this.Esquiva, 
            Pontos = this.Pontos
        };
        return copia;
    }
}