package bd.daos;

import java.sql.*;
import java.util.ArrayList;
import bd.*;
import bd.dbo.*;
import bd.core.*;

public class Bibliotecas {
	
	public static Biblioteca consulta (int Id) throws Exception
	{		
		try
		{
			String sql;
			
			sql = "SELECT * FROM Bibliotecas WHERE Id = ?";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setInt   (1, Id);
			
			MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
			
			resultado.first();
			
			Biblioteca biblioteca = new Biblioteca(resultado.getString("Nome"),
					   resultado.getString("Descricao"),
					   resultado.getInt   ("CEP"),
					   resultado.getString("Numero"),
					   resultado.getString("Complemento"));

		biblioteca.setId(resultado.getInt("Id"));
		
		return biblioteca;
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao buscar biblioteca");
		}
	}
	
	public static void create (Biblioteca biblioteca) throws Exception
	{
		if (biblioteca == null)
			throw new Exception ("Nenhum dado digitado.");
		
		try 
		{
			String sql;
			
			sql = "INSERT INTO Bibliotecas" +
			"(Nome, Descricao, CEP, Numero, Complemento)" +
			"VALUES" + 
			"(?, ?, ?, ?, ?)";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
		
			System.out.println(sql);
			
			BDSQLServer.COMANDO.setString(1, biblioteca.getNome());
			BDSQLServer.COMANDO.setString(2, biblioteca.getDescricao());
			BDSQLServer.COMANDO.setInt	 (3, biblioteca.getCEP());
			BDSQLServer.COMANDO.setString(4, biblioteca.getNumero());
			BDSQLServer.COMANDO.setString(5, biblioteca.getComplemento());
			
			BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
		}
		catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao incluir biblioteca. " + erro);
        }
		
	}
	
	public static ArrayList<Biblioteca> read () throws Exception
	{
		Biblioteca biblioteca= null;
		ArrayList<Biblioteca> selecionadas = new ArrayList<Biblioteca>();
		
		try
		{
			String sql;
			
			sql = "SELECT * FROM Bibliotecas";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
							
			MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery(); 
			resultado.first();

			while (!resultado.isAfterLast()) {
					biblioteca = new Biblioteca(resultado.getString("Nome"),
								   resultado.getString("Descricao"),
								   resultado.getInt   ("CEP"),
								   resultado.getString("Numero"),
								   resultado.getString("Complemento"));
		
					biblioteca.setId(resultado.getInt("Id"));
			
					selecionadas.add(biblioteca);	
					
				resultado.next();
			}
	}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao buscar biblioteca");
		}
		
		return selecionadas;
	}
	
	
	public void update (Biblioteca biblioteca) throws Exception
	{
		if (biblioteca == null)
			throw new Exception ("Biblioteca não encontrada.");
		
		try
		{
			String sql;
			
			sql = "UPDATE Bibliotecas " +
				  "SET Nome = ? , " + 
				  "Descricao = ? , " +
				  "CEP = ? , " + 
				  "Numero = ? , " + 
				  "Complemento = ? " + 
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
            throw new Exception("Erro ao atualizar dados bilbioteca." + erro);
		}
	}
	
	public void delete (int Id) throws Exception
	{		
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
