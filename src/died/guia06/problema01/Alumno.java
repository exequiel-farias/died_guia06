package died.guia06.problema01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	public Alumno(String nombre, Integer nroLibreta) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}

	public Integer creditosObtenidos() {
		int sum = 0;
		for(Curso unCurso : aprobados)
			sum += unCurso.getCreditos();
		return sum;
	}

	public void aprobar(Curso c) {
		aprobados.add(c);
		cursando.remove(c);
		c.aprobarAlumno(this);
	}

	public void inscripcionAceptada(Curso c) {
		cursando.add(c);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nroLibreta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nroLibreta, other.nroLibreta);
	}

	@Override
	public int compareTo(Alumno o) {
		return nombre.compareTo(o.nombre);
	}
	
	public int cantCursosMismoCicloLectivo(int cicloLectivo ) {
		int sum = 0;
		for(Curso unCurso : cursando)
			if(unCurso.getCicloLectivo() == cicloLectivo) sum++;
		return sum;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nroLibreta=" + nroLibreta + "]";
	}
	
	public Integer getNroLibreta() {
		return nroLibreta;
	}
}