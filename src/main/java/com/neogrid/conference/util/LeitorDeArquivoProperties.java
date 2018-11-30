package com.neogrid.conference.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class LeitorDeArquivoProperties {
    static Logger logger = LogManager.getLogger(LeitorDeArquivoProperties.class);

	/**
	 * Método estático para abrir arquivos properties, recebendo como argumento o nome do arquivo a ser aberto.
	 *
	 * @param parametro
	 * @return Properties
	 */
	public static Properties getFuncionalProp(String parametro) {
		Properties prop = new Properties();
		
		try {
			InputStream inputStream = LeitorDeArquivoProperties.class.getClassLoader().getResourceAsStream(parametro);
			prop.load(inputStream);
			
		} catch (IOException e) {
            logger.warn(e.getMessage());
		}
		
		return prop;
	}
}
