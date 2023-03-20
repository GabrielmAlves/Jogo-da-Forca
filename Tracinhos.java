public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
		if(qtd<0)
		    throw new Exception ("Valor inválido");
		this.texto = new char [qtd];
		for (int i=0; i< this.texto.length; i++) {
		    this.texto[i]='_';
		}
    }

    public void revele (int posicao, char letra) throws Exception
    {
        if (posicao<0 || posicao>= this.texto.length)
            throw new Exception ("Posicao inválida");
        
        this.texto[posicao]=letra;
    }

    public boolean isAindaComTracinhos ()
    {
        for (int i=0; i<this.texto.length; i++) {
            if (this.texto[i]=='_')
                return true;
        }
        return false;
    }

    @Override
    public String toString ()
    {
        String espaco = "";
        for (int i=0; i<this.texto.length; i++){
            espaco+=(this.texto[i]+ " ");
        }
        return espaco;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
			return true;
		
		return false;
    }

    @Override
    public int hashCode ()
    {
        int ret = 10;
        ret = 13*ret+this.texto.hashCode();
        if (ret<0)
            return ret=-ret;
        return ret;
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de cópia
    {
        if (t==null)
			throw new Exception ("Vetor vazio");
		this.texto= new char [t.texto.length];
		this.texto= t.texto;
    }

    public Object clone ()
    {
        Tracinhos ret=null;
		try
		{
			ret = new Tracinhos(this);
		}
		catch (Exception erro)
		{}
		return ret;
    }
}