package died.guia06.problema01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.problema01.excepciones.CreditosRequeridosInsuficientesException;
import died.guia06.problema01.excepciones.LimiteCupoException;
import died.guia06.problema01.excepciones.LimiteMateriasCursadoRegularException;
import died.guia06.problema01.excepciones.RegistroAuditoriaException;
import died.guia06.problema01.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso(String nombre, Integer cicloLectivo, Integer cupo, Integer creditos, Integer creditosRequeridos) {
		super();
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		boolean tieneCreditosRequeridos = a.creditosObtenidos() >= creditosRequeridos;
		boolean hayCupo = cupo > inscriptos.size();
		boolean menosDeTresCursosMismoCicloLectivo = a.cantCursosMismoCicloLectivo(cicloLectivo) < 3;
		if(tieneCreditosRequeridos && hayCupo && menosDeTresCursosMismoCicloLectivo) {
			inscriptos.add(a);
			a.inscripcionAceptada(this);
			try {
				log.registrar(this, "inscribir ",a.toString());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			return true;
		}else return false;
	}
	
	public void inscribirAlumno(Alumno a)  throws CreditosRequeridosInsuficientesException, LimiteCupoException,
			LimiteMateriasCursadoRegularException, RegistroAuditoriaException{
		boolean tieneCreditosRequeridos = a.creditosObtenidos() >= creditosRequeridos;
		boolean hayCupo = cupo > inscriptos.size();
		boolean menosDeTresCursosMismoCicloLectivo = a.cantCursosMismoCicloLectivo(cicloLectivo) < 3;
		if(tieneCreditosRequeridos) {
			if(hayCupo) {
				if(menosDeTresCursosMismoCicloLectivo) {
					inscriptos.add(a);
					a.inscripcionAceptada(this);
					try {
						log.registrar(this, "inscribir ",a.toString());
					} catch (IOException e) {
						throw new RegistroAuditoriaException("Excepción de entrada salida de la clase registro");
					}
				}else throw new LimiteMateriasCursadoRegularException("El alumno está cursando todas las materias de cursado regular");
			}else throw new LimiteCupoException("El curso ha alcanzado el limite de cupo");
		}else throw new CreditosRequeridosInsuficientesException("El alumno no tiene los creditos requeridos");
	}
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		Collections.sort(inscriptos);
		System.out.println(inscriptos.toString());
	}
	
	public void imprimirInscriptosPorNroLibreta() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		Collections.sort(inscriptos, new ComparaAlumnoNroLibreta());
		System.out.println(inscriptos.toString());
	}
	
	public void imprimirInscriptosPorCreditosObtenidos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		Collections.sort(inscriptos, new ComparaAlumnoCreditosObtenidos());
		System.out.println(inscriptos.toString());
	}

	public Integer getCreditos() {
		return creditos;
	}

	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}
	
	public Integer getCupo() {
		return cupo;
	}
	
	public void aprobarAlumno(Alumno a) {
		try {
			log.registrar(this, "aprobar ",a.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		inscriptos.remove(a);
	}
	
	public Integer getCicloLectivo() {
		return cicloLectivo;
	}
}