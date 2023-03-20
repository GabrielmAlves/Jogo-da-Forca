public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        Character l = new Character(letra);
        for (int i=0; i<this.letrasJaDigitadas.length(); i++) {
            if (l.equals(this.letrasJaDigitadas.charAt(i)))
                return true;
        }
        return false;
    }

    public void registre (char letra) throws Exception
    {
        if (this.isJaDigitada(letra)==true)
            throw new Exception ("Essa letra já foi digitada");
        
        this.letrasJaDigitadas = this.letrasJaDigitadas+letra;
    }

    @Override
    public String toString ()
    {
        String espaco = "";
        for (int i=0; i<this.letrasJaDigitadas.length(); i++){
            espaco+=(this.letrasJaDigitadas.charAt(i)+ ",");
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
        ret = 13*ret+this.letrasJaDigitadas.hashCode();
        if (ret<0)
            return ret=-ret;
        return ret;
    }

    public ControladorDeLetrasJaDigitadas(ControladorDeLetrasJaDigitadas c) throws Exception
    {
        if (c==null)
			throw new Exception ("Controlador vazio");
		
		this.letrasJaDigitadas=c.letrasJaDigitadas;
    }

    public Object clone ()
    {
        ControladorDeLetrasJaDigitadas ret=null;
		try
		{
			ret = new ControladorDeLetrasJaDigitadas(this);
		}
		catch (Exception erro)
		{}
		return ret;
    }
}