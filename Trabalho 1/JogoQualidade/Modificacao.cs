public class Modificacao
{
    // Corresponde às modificações de uma arma. Ela modifica os valores aplicados sem alterar os valores da arma originalmente. Também pode aumentar atributos do jogador.
    public int Dano{get; set;} = 0;
    public int Velocidade{get; set;} = 0;
    public int Defesa{get; set;} = 0;
    public int Esquiva{get; set;} = 0;

    public static Modificacao GeraRandom()
    {
        Modificacao Mod = new();
        Random random = new();
        Mod.Dano = random.Next(1, 10);
        Mod.Velocidade = random.Next(1, 3);
        Mod.Defesa = random.Next(1, 10);
        Mod.Esquiva = random.Next(1, 3);
        return Mod;
    }
}