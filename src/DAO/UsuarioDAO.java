package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Usuario;
import conexao.Conexao;

public class UsuarioDAO{
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement stm = null;
	
	public Connection conn = Conexao.criarConexao();
	
	

	public UsuarioDAO() {
	
		this.conn = conn;
	}




	public void mostrarUsuarios() {

		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM usuario");
			System.out.println("-------------- USUARIOS --------------------");
			while(rs.next()) {
				System.out.println("Id: " + rs.getInt("id"));
				System.out.println("Nome: " + rs.getString("nome"));
				System.out.println("Nome: " + rs.getString("email"));
				System.out.println("Nome: " + rs.getString("senha"));
				System.out.println();
			}
			System.out.println("-------------- USUARIOS --------------------");
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}	
		
	}
	

	public void inserirUsuario(Usuario u) {
		
		try {
			stm = conn.prepareStatement("INSERT INTO usuario(nome,email,senha) VALUES (?,?,?)");
			
			stm.setString(1, u.getNome());
			
			stm.setString(2, u.getEmail());
			
			stm.setString(3, u.getSenha());
			
			int row = stm.executeUpdate();
			
			if(row > 0) {
				System.out.println("Inserido com sucesso!");
			}else {
				System.out.println("Erro ao inserir!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public void alterarUsuario(Usuario u) {
		try {
			stm = conn.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?");
			
			stm.setString(1, u.getNome());
			
			stm.setString(2, u.getEmail());
			
			stm.setString(3, u.getSenha());
			
			stm.setInt(4, u.getId());
			
			int row = stm.executeUpdate();
			
			if(row > 0) {
				System.out.println("Alterado com sucesso!");
			}
				
		}catch(SQLException e) {
			System.out.println("erro: " + e.getMessage());
		}
		
		
	}
	public void deletarUsuario(int id) {
		try {
			stm = conn.prepareStatement("DELETE FROM usuario WHERE id = ?");
			
			
			stm.setInt(1, id);
			
			int row = stm.executeUpdate();
			
			if(row > 0) {
				System.out.println("Deletado com sucesso!");
			}
				
		}catch(SQLException e) {
			System.out.println("erro: " + e.getMessage());
		}
		
		
	}

}
