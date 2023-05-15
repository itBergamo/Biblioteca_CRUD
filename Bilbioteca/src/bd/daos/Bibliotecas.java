package bd.daos;

import java.sql.*;
import bd.*;
import bd.dbo.*;

public class Bibliotecas {

	public static void incluir (Biblioteca biblioteca) throws Exception
	{
		if (biblioteca == null)
			throw new Exception ("Nenhum dado digitado.");
		
		try 
		{
			String sql;
			
			sql = "INSERT INTO Bibliotecas" +
			"(Id, Nome, Descricao, CEP, Numero, Complemento)" +
			"VALUES" + 
			"(?, ?, ?, ?, ?, ?)";
			
		}
		catch(Exception e)
		{}
		
	}
}
