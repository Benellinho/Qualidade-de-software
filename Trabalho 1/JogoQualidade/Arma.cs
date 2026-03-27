public class Arma
{
    public string ?Nome{get;set;}
    public int Dano {get; set;}
    public Modificacao Mod {get; set;} = new();
}
