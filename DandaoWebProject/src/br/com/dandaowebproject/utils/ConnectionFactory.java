package br.com.dandaowebproject.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 
 * Classe responsável por conter os atributos e metodos para criar conexão com banco de dados
 *
 * @author Genilson Ferreira <gr.ferreira@live.com>
 * @since 21/03/2014 
 * @version 1.0
 * 
 */


public class ConnectionFactory {

	// Caminho do banco de dados.
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dbDandao";
	private static final String USUARIO = "dba_gferreira";
	private static final String SENHA = "123456";

	
public Connection criarConexao(){
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		} catch (Exception e) {
			System.out.println("Erro ao criar conexão com o banco: " + URL);
			e.printStackTrace();
		}
		return conexao;
	}


public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs){
	
	try {
		
		if(conexao != null){
			conexao.close();
		}
		if(pstmt != null){
			pstmt.close();
		}
		if(rs != null){
			rs.close();
		}
				
	} catch (Exception e) {
		System.out.println("Erro ao fechar conexão com o banco: " + URL);
	}
}

	
	
}
