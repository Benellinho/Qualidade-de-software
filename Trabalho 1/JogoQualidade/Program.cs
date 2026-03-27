namespace JogoQualidade;

class Inicio
{
    public static void Main()
    {
        Partida p = new();
        p.Initialize();
        p.Jogo();
    }
}