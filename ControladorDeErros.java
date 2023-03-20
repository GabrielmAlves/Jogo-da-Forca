public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
		if (qtdMax<0) 
			throw new Exception ("A quantidade fornecida não é válida");
		
		this.qtdMax = qtdMax;
    }

    public void registreUmErro () throws Exception
    {
		if (this.qtdErr==this.qtdMax)
			throw new Exception ("Atingido o nivel maximo de erros");
		else
			this.qtdErr = ++this.qtdErr;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
		if (this.qtdErr==this.qtdMax)
			return true;
		return false;
    }
    
    @Override
    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
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
        
        ret = 13*ret + new Integer (this.qtdMax).hashCode();
        ret = 13*ret + new Integer (this.qtdErr).hashCode();
        
        if (ret<0)
            ret = - ret;
        return ret;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de cópia
    {
		if (c==null)
			throw new Exception ("Controlador vazio");
		this.qtdMax=c.qtdMax;
		this.qtdErr=c.qtdErr;
    }

    public Object clone ()
    {
		ControladorDeErros ret=null;
		try
		{
			ret = new ControladorDeErros(this);
		}
		catch (Exception erro)
		{}
		return ret;
    }
}