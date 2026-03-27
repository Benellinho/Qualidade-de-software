public class Personagem
{
    // Personagem do jogador. Guarda dados base e da arma equipada
    string ?Nome{get; set;}
    public int Vida{get; set;} = 0;
    public int Defesa{get; set;} = 0;
    public int Dano{get; set;} = 0;
    public int Energia{get; set;} = 0;
    public int Esquiva{get; set;} = 0;
    public Arma Primaria{get;set;} = new();
    public Arma Secundaria{get;set;} = new();

    public void Checagem()
    {
        Console.WriteLine("Vida: {0}\nDefesa: {1}\nDano: {2}\nEnergia: {3}\nEsquiva: {4}\n", this.Vida, this.Defesa+this.Primaria.Mod.Defesa+this.Secundaria.Mod.Defesa, this.Dano+this.Primaria.Mod.Dano+this.Secundaria.Mod.Dano+this.Primaria.Dano+this.Secundaria.Dano, this.Energia, this.Esquiva+this.Primaria.Mod.Esquiva+this.Secundaria.Mod.Esquiva);
    }

    public int PegaDanoTotal()
    {
        return this.Dano+this.Primaria.Dano+this.Secundaria.Dano+this.Primaria.Mod.Dano+this.Secundaria.Mod.Dano;
    }

    public int PegaEsquivaTotal()
    {
        return this.Esquiva+this.Primaria.Mod.Esquiva+this.Secundaria.Mod.Esquiva;
    }

    public void Ataque(Inimigo n1)
    {
        Random teste = new();
        if(teste.Next(1, 10) >= n1.Esquiva)
        {
            Console.WriteLine("Acertou!");
            n1.Vida -= this.PegaDanoTotal()-n1.Defesa;
            Console.WriteLine("Causou {0} de dano à {1}. Sobram {2} pontos de vida", this.PegaDanoTotal()-n1.Defesa, n1.Nome, n1.Vida);
            
        }
        else
        {
            Console.WriteLine("Errou!");
        }
    }
    public void DefinePersonagem(int s)
    {
        if(s == 1)
        {
            this.Nome = "O Necrótico";
            this.Vida = 40;
            this.Defesa = 0;
            this.Dano = 5;
            this.Energia = 50;
            this.Esquiva = 1;
            this.Primaria = new Arma{Nome = "Espada folhada", Dano = 5, Mod = new Modificacao()};
        } 
        else if(s == 2)
        {
            this.Nome = "A Niilista";
            this.Vida = 45;
            this.Defesa = 2;
            this.Dano = 10;
            this.Energia = 30;
            this.Esquiva = 2;
            this.Primaria = new Arma{Nome = "Rapieira", Dano = 7, Mod = new Modificacao()};
        } 
        else
        {
            this.Nome = "O Cruel";
            this.Vida = 60;
            this.Defesa = 5;
            this.Dano = 15;
            this.Energia = 20;
            this.Esquiva = 2;
            this.Primaria = new Arma{Nome = "Flambérgia", Dano = 9, Mod = new Modificacao()};
        }
    }
}