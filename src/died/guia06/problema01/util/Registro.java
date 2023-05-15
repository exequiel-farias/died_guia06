package died.guia06.problema01.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import died.guia06.problema01.Curso;

public class Registro {

	private final String FILE_PATH = "registro.log";
	
	public void registrar(Curso c,String operacion,String detalle) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
		writer.append("["+LocalDateTime.now().toString()+"]se registro la operacion: "+ operacion+" en el curso"+ c.toString());
		writer.append("Detalle"+ detalle);
		writer.write(System.getProperty( "line.separator" ));
		writer.close();
	}
	
}
