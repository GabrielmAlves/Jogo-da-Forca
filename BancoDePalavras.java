public class BancoDePalavras
{
    private static String[] palavras = 
    {
		"MESSI",
		"CRISTIANO RONALDO",
		"NEYMAR",
		"HTML",
		"JAVA",
		"LIVERPOOL",
		"BATATA",
		"GABRIEL",
		"MIKE",
		"FACULDADE",
		"HARVEY",
		"SUITS"
    };

    public static Palavra getPalavraSorteada ()
    {
        Palavra palavra = null;

        try
        {
            palavra =
            new Palavra (BancoDePalavras.palavras[
            (int)(Math.random() * BancoDePalavras.palavras.length)]);
        }
        catch (Exception e)
        {}

        return palavra;
    }
}
