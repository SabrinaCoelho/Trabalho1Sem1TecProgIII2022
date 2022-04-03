package br.edu.univas.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import vo.Player;
import vo.Titulo;

public class StartApp {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Player> players = new ArrayList();
		ArrayList<Titulo> titulos = new ArrayList();
		
		int op;
		do {
			op = menu(in);
			
			switch(op) {
				case 1:{
					cadastroPlayer(in, players);
					break;
				}
				case 2:{
					cadastroTitulo(in, titulos, players);
					break;
				}
				case 3:{
					buscar(in, titulos, players);
					break;
				}
				case 4:{
					recomendacao(in, titulos, players);
					break;
				}
			}
		}while(op != 9);
		for(Titulo t: titulos) {
			System.out.println(t.toString());
		}
		
		System.out.println("At�!");
	}
	
	public static int menu(Scanner in) {
		System.out.print("---------------Menu---------------\n"
				+ "	[1] Cadastrar player\n"
				+ "	[2] Cadastrar t�tulo\n"
				+ "	[3] Buscar\n"
				+ "	[4] Recomenda��o\n"
				+ "	[9] Sair\n>>");
		int op = lerInt(in);
		return op;
	}
	public static void cadastroPlayer(Scanner in, ArrayList<Player> players) {
		System.out.println("----------Cadastro player-----------");
		System.out.print("Nome: ");
		String nome = lerString(in);
		System.out.print("Site: ");
		String site = in.nextLine().toLowerCase();
		Player p = new Player(nome, site);
		boolean key = true;
		//
		if(players.contains(p)) {
			System.out.println("Plataforma j� cadastrada.");
			key = false;
		}else {
			players.add(p);
		}
		
	}
	public static void cadastroTitulo(Scanner in, ArrayList<Titulo> titulos, ArrayList<Player> players) {
		ArrayList<String> elenco = new ArrayList();
		ArrayList<String> genero = new ArrayList();
		ArrayList<String> plataformas = new ArrayList();
		int op;
		String tipo = "";
		System.out.println("----------Cadastro t�tulo-----------");
		do {
			System.out.print("Tipo:\n"
					+ "	[1] Filme\n"
					+ "	[2] S�rie\n"
					+ ">>");
			
		 
			op = lerInt(in);
		}while(op > 2 || op < 1);
		
		switch(op) {
			case 1:{
				tipo = "Filme";
				break;
			}
			case 2:{
				tipo = "S�rie";
				break;
			}
		}
		System.out.print("T�tulo: ");
		String titulo = lerString(in);
		System.out.print("Elenco: \n"
				+ "	ATEN��O: Os nomes devem ser inseridos separados com v�rgula.\n>>");
		String nomesElenco;
		do {
			nomesElenco = in.nextLine();
		}while(nomesElenco.length() == 0);
		TratamentoArrayListString(in, nomesElenco, elenco);
		
		System.out.print("Descri��o:");
		String descricao = in.nextLine();
		
		System.out.print("G�nero: \n"
				+ "	ATEN��O: Os nomes devem ser inseridos separados com v�rgula.\n>>");
		String generos;
		do {
			generos = in.nextLine();
		}while(generos.length() == 0);
		TratamentoArrayListString(in, generos, genero);
		
		System.out.print("Diretor: ");
		String diretor = in.nextLine();
		
		
		String classificacaoEtaria;
		boolean key = true;
		do {
			System.out.print("Classifica��o et�ria:\n"
					+ "	[L] \n"
					+ "	[10]\n"
					+ "	[12]\n"
					+ "	[14]\n"
					+ "	[16]\n"
					+ "	[18]\n"
					+ ">>");
			classificacaoEtaria = in.nextLine().toUpperCase();
			if(classificacaoEtaria.equals("L") || classificacaoEtaria.equals("10") || classificacaoEtaria.equals("12") || classificacaoEtaria.equals("14") || classificacaoEtaria.equals("14") || classificacaoEtaria.equals("16") || classificacaoEtaria.equals("18")) {
				key = false;
			}
			
		}while(key);
		
		
		System.out.print("Plataformas: \n"
				+ "	ATEN��O: Os nomes devem ser inseridos separados com v�rgula.\n>>");
		String nomePlataformas;
		do {
			nomePlataformas = lerString(in);
		}while(nomePlataformas.length() == 0);
		TratamentoArrayListString(in, nomePlataformas, plataformas);
		ArrayList<Player> playersConferidos = pesquisaPlataformaCadastrada(plataformas, players, in);
		
		Titulo novoTitulo = new Titulo(tipo, titulo, elenco, descricao, genero, diretor, classificacaoEtaria, playersConferidos);
		if(!verificaTituloExistente(in, novoTitulo, titulos)) {
			titulos.add(novoTitulo);
		}else {
			System.out.println("T�tulo n�o adicionado, pois j� encontrado existente.");
		}
		
	}
	
	public static int lerInt(Scanner in){
		int leitura = in.nextInt();
		in.nextLine();
		return leitura;
	}
	public static String lerString(Scanner in){
		String leitura = in.nextLine();
		String leituraTratada = leitura.substring(0, 1).toUpperCase() + leitura.substring(1).toLowerCase();
		return leituraTratada;
	}
	
	public static void TratamentoArrayListString(Scanner in, String generico, ArrayList<String> genericoArrayList){
		String[] genericoHost = generico.split(",");
		for(int i = 0; i < genericoHost.length;i++) {
			genericoArrayList.add(genericoHost[i].strip());
		}
		
	}
	public static ArrayList<Player> pesquisaPlataformaCadastrada(ArrayList<String> plataformas, ArrayList<Player> players, Scanner in) {
		ArrayList<Player> conferidos = new ArrayList();
		for(int i = 0; i < plataformas.size();i++) {
			for(int j = 0; j < players.size(); j++) {
				if(plataformas.get(i).equalsIgnoreCase(players.get(j).getNome())) {
					conferidos.add(players.get(j));
					plataformas.remove(i);//remove os encontrados
					i--;
					break;
					
				}
			}
			
		}
		
		if(plataformas.size() != 0){
			System.out.println("N�o encontrado o(s) seguinte(s) player(s) no cadastro:");
			for(int i = 0; i < plataformas.size();i++) {
				System.out.println("	"+plataformas.get(i));
			}
			System.out.print("Gostaria de cadastr�-lo(s)?\n"
					+ "	[1] Sim\n"
					+ "	[2] N�o\n>>");
			int op = 0;
			do {
				op = lerInt(in);
				switch(op) {
					case 1:{
						cadastroPlayer(in, players);
						plataformas.clear();
						System.out.println("Continuando cadastro de t�tulo.\n"
								+ "Plataformas:\n"
								+ "	ATEN��O: Os nomes devem ser inseridos separados com v�rgula.");
						String nomePlataformas;
						do {
							nomePlataformas = in.nextLine();
						}while(nomePlataformas.length() == 0);
						TratamentoArrayListString(in, nomePlataformas, plataformas);
						return pesquisaPlataformaCadastrada(plataformas, players, in);
					}
					case 2:{
						plataformas.clear();
						System.out.println("Continuando cadastro de t�tulo.\n"
								+ "Plataformas:\n"
								+ "	ATEN��O: Os nomes devem ser inseridos separados com v�rgula.");
						String nomePlataformas;
						do {
							nomePlataformas = in.nextLine();
						}while(nomePlataformas.length() == 0);
						TratamentoArrayListString(in, nomePlataformas, plataformas);
						return pesquisaPlataformaCadastrada(plataformas, players, in);
					}
					default:{
						System.out.print("Insira uma op��o do menu.\n>>");
						break;
					}
				}
			}while(op > 2 || op < 1);
			
			
		}
		return conferidos;
	}
	
	public static boolean verificaTituloExistente(Scanner in, Titulo novoTitulo, ArrayList<Titulo> titulos) {
		
		if(titulos.size() == 0) {
			return false;
		}else {
			for(int i = 0; i < titulos.size();i++) {
				Titulo tituloExistente = null;
				if(novoTitulo.equals(titulos.get(i))) {
					System.out.println("Encontrado t�tulo existente.");
					return true;
				}else if(novoTitulo.equalsSemPlayer(titulos.get(i))) {
					tituloExistente = titulos.get(i);
					for(int j = 0;j < novoTitulo.getPlataforma().size(); j++) {
						
						for(int k = 0;k < tituloExistente.getPlataforma().size(); k++) {
							if(novoTitulo.getPlataforma().get(j).equals(tituloExistente.getPlataforma().get(k))) {
								novoTitulo.getPlataforma().remove(j);
								j--;
								break;
							}
						}
						
					}
					if(novoTitulo.getPlataforma().size() != 0 ) {
						System.out.println("T�tulo cadastrado nas demais plataformas menos em: ");
						for(Player p: novoTitulo.getPlataforma() ){
							System.out.println("	"+p.getNome());
						}
						System.out.println("T�tulo atualizado para tamb�m estar cadastrado nesta(s) plataforma(s).");
						for(Player p: novoTitulo.getPlataforma() ){
							tituloExistente.getPlataforma().add(p);
						}
						return true;
					}else {
						return true;
					}
				}
			}
		
		}
		return false;
	}
	
	public static void buscar(Scanner in, ArrayList<Titulo> titulos, ArrayList<Player> players ) {
		System.out.print("Buscar por...\n>>");
		String pesquisa = in.nextLine().toUpperCase();
		boolean naoEncontrado = true;
		for(int i = 0; i < titulos.size(); i++) {
			if(titulos.get(i).toString().toUpperCase().contains(pesquisa)) {
				System.out.println(titulos.get(i));
				naoEncontrado = false;
			}
			
		}
		if(naoEncontrado) {
			System.out.println("N�o encontrado t�tulos ou informa��es relacionadas ao que procura.");
		}
	}
	public static void recomendacao(Scanner in, ArrayList<Titulo> titulos, ArrayList<Player> players ) {
		int op;
		do { 
			System.out.print("--------Recomenda��o---------\n"
					+ "	[1] Aleat�ria\n"
					+ "	[2] G�nero\n"
					+ ">>");
			op = lerInt(in);
		}while(op > 2 || op < 1);
		switch(op) {
			case 1:{
				recomendacaoAleatoria(titulos);
				
				break;
			}
			case 2:{
				recomendacaoGenero(in, titulos);
				break;
			}
		}
	}
	
	public static void recomendacaoAleatoria(ArrayList<Titulo> titulos) {
		if(titulos.size() > 0) {
			Random r = new Random();
			int max = titulos.size();
			int numeroR = r.nextInt(max);
			System.out.println("Recomendado:\n"+titulos.get(numeroR).toString());
		}else {
			System.out.println("N�o h� t�tulos cadastrados ainda.");
		}
		
	}
	public static void recomendacaoGenero(Scanner in, ArrayList<Titulo> titulos) {
		ArrayList<Titulo> recomendados = new ArrayList();
		System.out.println("Deseja a recomenda��o em qual g�nero? ");
		String genero = in.next();
		for(int i = 0; i < titulos.size(); i++) {
			Titulo tituloHost = titulos.get(i);
			for(int j = 0; j < tituloHost.getGenero().size(); j++) {
				if(genero.equalsIgnoreCase(tituloHost.getGenero().get(j))) {
					recomendados.add(tituloHost);
				}
			}
			
		}
		if(recomendados.size() != 0) {
			System.out.println("Recomendado(s):");
			for(Titulo t: recomendados) {
				System.out.println(t);
			}
		}else {
			System.out.println("N�o encontrado t�tulos correspondentes.");
		}
		
	}
	
}

