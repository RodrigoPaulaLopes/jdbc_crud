package app;

import java.util.Scanner;

import DAO.UsuarioDAO;
import classes.Usuario;

public class Programa {

	public static void main(String[] args) {

		int escolha;
		Usuario u = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		String resposta = "S";

		Scanner in = new Scanner(System.in);
		
		do {
			
		

		System.out.println("MOSTRAR TODOS OS USUARIOS = 1");
		System.out.println("INSERIR USUARIO = 2");
		System.out.println("ALTERAR USUARIO = 3");
		System.out.println("DELETAR USUARIO = 4");
		System.out.println();
		System.out.println("Escolha uma operação: ");

		escolha = in.nextInt();

		switch (escolha) {
		case 1:

			udao.mostrarUsuarios();
			
			System.out.println("Deseja realizar outra operação? ");
			resposta = in.next();
			break;

		case 2:

			System.out.println("Inserir nome: ");
			u.setNome(in.next());

			System.out.println("Inserir email: ");
			u.setEmail(in.next());

			System.out.println("Inserir senha: ");
			u.setSenha(in.next());

			udao.inserirUsuario(u);

			udao.mostrarUsuarios();
			
			System.out.println("Deseja realizar outra operação? ");
			resposta = in.next();

			break;
		case 3:
			udao.mostrarUsuarios();

			System.out.println("Id do usuario que deseja: ");
			u.setId(in.nextInt());

			System.out.println("Inserir nome: ");
			u.setNome(in.next());

			System.out.println("Inserir email: ");
			u.setEmail(in.next());

			System.out.println("Inserir senha: ");
			u.setSenha(in.next());

			udao.alterarUsuario(u);

			udao.mostrarUsuarios();
			
			System.out.println("Deseja realizar outra operação? ");
			resposta = in.next();
			
			break;
		case 4:
			udao.mostrarUsuarios();
			
			System.out.println("Digite p id do usuario que deseja deletar");
			
			 u.setId(in.nextInt());
			

			udao.deletarUsuario(u.getId());

			udao.mostrarUsuarios();
			
			System.out.println("Deseja realizar outra operação? ");
			resposta = in.next();
			
			
			break;

		default:
			System.out.println("Numero desconhecido!");

		}
		}while(resposta.equals("S") || resposta.equals("s") );

	}

}
