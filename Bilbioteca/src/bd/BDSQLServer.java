package bd;

import java.sql.DriverManager;
import bd.core.*;

public class BDSQLServer
{
    public static final MeuPreparedStatement COMANDO;

    static
    {
    	MeuPreparedStatement comando = null;

    	try
        {
            comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://regulus.cotuca.unicamp.br:1433;databasename=BD20676",
            "BD20676", "BD20676");
            System.out.println("FUNCIONOU!!");
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD: " + erro);
            System.exit(0); //Abort program
        }
        
        COMANDO = comando;
    }
}