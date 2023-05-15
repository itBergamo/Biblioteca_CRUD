package bd.dbo;

public class Biblioteca implements Cloneable {

	private int id;
	private String nome;
	private String descricao;
	private int cep;
	private String numero;
	private String complemento;
	
	public void setId (int id)throws Exception
	{
		if (id <= 0) 
			throw new Exception("Id inválido.");
		
		this.id = id;
	}
	
	public void setNome (String nome) throws Exception
	{
		if (nome == null || nome.equals(""))
			throw new Exception ("Digite um nome.");
		
		this.nome = nome;
	}
	
	public void setDescricao (String descricao) throws Exception
	{
		if (descricao == null || descricao.equals(""))
			throw new Exception ("Digite uma descrição, se não houver coloque --");
		
		this.descricao = descricao;
	}
	
	public void setCEP (int cep) throws Exception
	{
		if (cep <= 0) 
			throw new Exception("Número inválido");
		
		this.cep = cep;
	}
	
	public void setNumero (String numero) throws Exception
	{
		if (numero == null || numero.equals(""))
			throw new Exception ("Digite um numero, se não houver coloque --");
		
		this.numero = numero;
	}
	
	public void setComplemento (String complemento) throws Exception
	{
		if (complemento == null || complemento.equals(""))
			throw new Exception ("Digite um complemento, se não houver coloque --");
		
		this.complemento = complemento;
	}
	
	public int getId ()
	{
		return this.id;
	}
	
	public String getNome ()
	{
		return this.nome;
	}
	
	public String getDescricao ()
	{
		return this.descricao;
	}
	
	public int getCEP ()
	{
		return this.cep;
	}

	public String getNumero ()
	{
		return this.numero;
	}
	
	public String getComplemento ()
	{
		return this.complemento;
	}
	
	public Biblioteca (int id, String nome, String descricao, int cep, String numero, String complemento) throws Exception
	{
		this.setId		   (id);
		this.setNome	   (nome);
		this.setDescricao  (descricao);
		this.setCEP		   (cep);
		this.setNumero	   (numero);
		this.setComplemento(complemento);
	}
	
	public String toString ()
	{
		String ret = "";
		
		ret += "Id.........: " + this.id        + "\n";
		ret += "Nome.......: " + this.nome 		+ "\n";
		ret += "Descrição..: " + this.descricao + "\n";
		ret += "CEP........: " + this.cep 		+ "\n";
		ret += "Nº.........: " + this.numero 	+ "\n";
		ret += "Complemento: " + this.complemento;
		
		return ret;
	}
	
	//Add restante métodos obrigatórios
}
 
