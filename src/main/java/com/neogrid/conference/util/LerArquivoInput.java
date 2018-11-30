package com.neogrid.conference.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.neogrid.conference.model.Conference;
import org.springframework.beans.factory.annotation.Value;


/**
 * Classe util para ler arquivos.
 */
public class LerArquivoInput {

    private static String input;

    /**
	 * Método criado para capturar caminho do arquivo txt a ser lido.
	 * O caminho deve estar incluído no arquivo application.properties, na propriedade input.url.
	 * o Caminho deve ser completo.
     *
     * Para leitura é chamado o método estático getFuncionalProp da classe LeitorDeArquivoProperties, passando como
     * argumento o nome do arquivo a ser aberto e lido suas propriedades.
     *
	 * @return String
	 */
	private static String gerUrlInput() {
		Properties urlInputProp = LeitorDeArquivoProperties.getFuncionalProp("application.properties");
		return urlInputProp.getProperty("input.url");
	}


    /**
	 * Método estático para abrir e ler o arquivo txt, montando uma lista com todos os titulos das conferencias
	 * e seus respectivos tempos.
	 *
	 * O arquivo é aberto e lido linha a linha, criando um objeto do tipo Conference, para criar uma lista
	 * deste objeto.
	 *
	 * Linha a linha é convertido para uma array de string, onde o último index é o tempo da palestra e
	 * este é convertido para o tipo Integer(removendo o termo "min"). Este dado convertido é o tempo da palestra.
	 * Após leitura do arquivo é fechado o arquivo, com a Lista montada é retornado como resposta.
	 * @return List<Conference>
	 */
	public static List<Conference> lerArquivoInput(){
		BufferedReader lerArq = null;
		List<Conference> conferences = new ArrayList<>();
		try {
		FileReader arq = new FileReader(new File(gerUrlInput()));
		lerArq = new BufferedReader(arq);
	 
	    String linha = lerArq.readLine();
	    
	    while (linha != null) {
	        String[] linhaSplit = linha.split(" ");
	        String duracao = linhaSplit[linhaSplit.length-1].replace("min","");
	        Integer tempo;
	        if (duracao.equalsIgnoreCase("lightning")) {
	        	tempo = 5;
	        } else {
	        	tempo = Integer.parseInt(duracao); 
	        }
	        conferences.add(new Conference(linha,tempo));
	        linha = lerArq.readLine(); // lê da segunda até a última linha
	      }
	 
	      arq.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				lerArq.close();
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return conferences;
	}
	
}
