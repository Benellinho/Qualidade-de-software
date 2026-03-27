using System;
public class Sala
{
    // Mantém informações sobre a próxima sala e loot.
    public int IdxMods = 0;
    public int IdxArmas = 0;
    public List<Inimigo> Inimigos{get;set;} = new();
    public List<Modificacao> Modificacoes{get;set;} = new();
    public List<Arma> Armas{get;set;} = new();

    public void Checagem()
    {
        Console.WriteLine("No Mods: {0}\nNo Armas: {1}\nNo Inimigos: {2}\n", this.Modificacoes.Count, this.Armas.Count, this.Inimigos.Count);
    }

    public void MostraInimigos()
    {
        //Console.WriteLine("{0}", this.Inimigos.Count);
        
        for( int i = 0 ; i < this.Inimigos.Count ; i++)
        {
            Console.Write("{0}- {1} ({2}) ",i, this.Inimigos[i].Nome, this.Inimigos[i].Vida);
            Console.Write("\n");
        }
        
        Console.Write("\n");
    }

    public void InimigosAtacam(Personagem p1)
    {
        for(int i = 0 ; i < this.Inimigos.Count ; i++)
        {
            if(this.Inimigos[i].Vida > 0)
            {
                this.Inimigos[i].Ataca(p1);
            } else
            {
                Inimigos.Remove(this.Inimigos[i]);
            }
        }
    }

    public Sala GeraSala(List<Inimigo> Tipos, int qtdInimigos, int qtdMods, int qtdArmas)
    {
        Sala s = new Sala();
        Random random = new();

        for( int i = 0 ; i < qtdInimigos ; i++)
        {
            s.Inimigos.Add(Tipos[random.Next(Tipos.Count)].Clone());
        }
        //Console.WriteLine("Aqui qtdMods é {0}", qtdMods);
        //Console.WriteLine("Aqui qtdArmas é {0}", qtdArmas);
        //Console.WriteLine("Aqui qtdInimigos é {0}", qtdInimigos);
        for( int i = 0 ; i < qtdMods ; i++)
        {
            s.Modificacoes.Add(Modificacao.GeraRandom());
        }
    
        return s;
    }

    private void AvancaIndex(int qual)
    {
        if(qual == 0 && this.IdxMods+1 < this.Modificacoes.Count)
        {
            this.IdxMods++;
            Console.WriteLine($"Olhando para a modificacao nO {this.IdxMods+1}");
        }

        else if(this.IdxArmas+1 < this.Armas.Count)
        {
            this.IdxArmas++;
            Console.WriteLine($"Olhando para a arma nO {this.IdxArmas+1}");
        }
    }

    //private void 
}