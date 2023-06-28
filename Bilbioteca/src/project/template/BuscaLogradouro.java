package project.template;

public class BuscaLogradouro 
{
	public static Logradouro getLogradouroByCep(String cep) 
	{
		try 
		{
			Logradouro logradouro = (Logradouro) ClienteWS.getObjeto(Logradouro.class,
					"https://api.postmon.com.br/v1/cep/" + cep);

			return logradouro;
		} 
		catch (Exception erro) 
		{
			erro.printStackTrace();
		}
		return null;
	}
}
