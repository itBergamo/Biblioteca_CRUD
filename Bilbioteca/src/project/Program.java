package project;

import project.template.*;

public class Program {

	public static void main (String[] args)
	{
		int cepi = 13276220;
		String cep = cepi + "";
		
		try
        {
            Logradouro logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", cep);
            System.out.println (logradouro);
        }
        catch (Exception erro)
        {
            System.err.println (erro.getMessage());
        }
	}
}
