package bd.daos;

import java.sql.*;
import bd.*;
import bd.dbo.*;
import bd.core.*;

public class Bibliotecas {
	
	public static boolean cadastrado (int Id) throws Exception
	{
		boolean retorno = false;
		
		try
		{
			String sql;
			
			sql = "SELECT * FROM Bibliotecas WHERE Id = ?";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setInt   (1, Id);
			
			MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
			
			retorno = resultado.first();
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao buscar biblioteca");
		}
		
		return retorno;
	}
	
	public static void create (Biblioteca biblioteca) throws Exception
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
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setInt   (1, biblioteca.getId());
			BDSQLServer.COMANDO.setString(2, biblioteca.getNome());
			BDSQLServer.COMANDO.setString(3, biblioteca.getDescricao());
			BDSQLServer.COMANDO.setInt	 (4, biblioteca.getCEP());
			BDSQLServer.COMANDO.setString(5, biblioteca.getNumero());
			BDSQLServer.COMANDO.setString(6, biblioteca.getComplemento());
			
			BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
		}
		catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao incluir biblioteca.");
        }
		
	}
	
	public static Biblioteca read (int Id) throws Exception
	{
		Biblioteca biblioteca= null;
		
		try
		{
			String sql;
			
			sql = "SELECT * FROM Bibliotecas WHERE Id = ?";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setInt(1, Id);
				
			MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
			
			if (!resultado.first())
				throw new Exception ("Não cadastrado");
			
			biblioteca = new Biblioteca(resultado.getInt   ("Id"),
									   resultado.getString("Nome"),
									   resultado.getString("Descricao"),
									   resultado.getInt   ("CEP"),
									   resultado.getString("Numero"),
									   resultado.getString("Complemento"));
			
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao buscar biblioteca");
		}
		
		return biblioteca;
	}
	
	public static MeuResultSet readAll() throws Exception
	{
		MeuResultSet resultado = null;
		
		try 
		{
			String sql;
			
			sql = "SELECT * FROM Bibliotecas";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro na recuperação das bibliotecas.");
		}
		
		return resultado;
	}
	
	public static void update (Biblioteca biblioteca) throws Exception
	{
		if (biblioteca == null)
			throw new Exception ("Biblioteca não encontrada.");
		
		if (!cadastrado (biblioteca.getId()))
			throw new Exception ("Não cadastrado.");
		
		try
		{
			String sql;
			
			sql = "UPDATE Bibliotecas " +
				  "SET Nome = ? " + 
				  "SET Descricao = ? " +
				  "SET CEP = ? " + 
				  "SET Numero = ? " + 
				  "SET Complemento = ? " + 
				  "WHERE Id = ?";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setString(1, biblioteca.getNome());
			BDSQLServer.COMANDO.setString(2, biblioteca.getDescricao());
			BDSQLServer.COMANDO.setInt	 (3, biblioteca.getCEP());
			BDSQLServer.COMANDO.setString(4, biblioteca.getNumero());
			BDSQLServer.COMANDO.setString(5, biblioteca.getComplemento());
			BDSQLServer.COMANDO.setInt   (6, biblioteca.getId());
			
			BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
		}
		catch (SQLException erro)
		{
			BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao atualizar dados bilbioteca.");
		}
	}
	
	public static void delete (int Id) throws Exception
	{
		if (!cadastrado (Id))
			throw new Exception ("Não cadastrado");
		
		try
		{
			String sql;
			
			sql = "DELETE FROM Bibliotecas WHERE Id = ?";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setInt (1, Id);
			
			BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
		}
		catch(SQLException erro)
		{
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao excluir biblioteca.");
		}
	}
}
