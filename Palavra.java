public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
        if (texto==null)
            throw new Exception ("String vazia"); //provavelmente vou trocar isso
        
        this.texto=texto;
    }

    public int getQuantidade (char letra)
    {
        int qtdLetras=0;
        Character l= new Character(letra);
        for (int i=0; i<this.texto.length(); i++) {
            if (l.equals(this.texto.charAt(i)))
                qtdLetras= ++qtdLetras;
        }
        return qtdLetras;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        int qtdOcorrencias=0;
        int vetPosicoes[] = new int [this.texto.length()];
        int index = this.texto.indexOf(letra);
        for (int j=0; j<this.texto.length(); j++) {
            if(this.texto.charAt(j)==letra)
                 qtdOcorrencias++;
               	 vetPosicoes[j] = index;
               	 for(int k = 0;k<this.texto.length();k++) {
               		 if(vetPosicoes[j] == index) {
               			index = this.texto.indexOf(letra, index + 1);
               		 }
               	 }
            	
        }
        
        if ((i+1)>qtdOcorrencias) //coloquei pq o usuário pode colocar 0; e o contador inicia com 1
            throw new Exception ("Entrada inválida");
        return vetPosicoes[i];
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
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
    
    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}