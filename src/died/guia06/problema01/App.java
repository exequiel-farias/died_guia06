package died.guia06.problema01;

import died.guia06.problema01.excepciones.CreditosRequeridosInsuficientesException;
import died.guia06.problema01.excepciones.LimiteCupoException;
import died.guia06.problema01.excepciones.LimiteMateriasCursadoRegularException;
import died.guia06.problema01.excepciones.RegistroAuditoriaException;

public class App {

	public static void main(String[] args) {
		Curso am1 = new Curso("AM1",1,2,1,0);
		Curso fisica = new Curso("Fisica",1,2,1,0);
		Curso algebra = new Curso("Algebra",1,2,1,0);
		Curso arquitectura = new Curso("Arquitectura",1,3,1,0);
		Curso am2 = new Curso("AM2",2,3,1,1);
		Alumno a1 = new Alumno("Exequiel",1);
		Alumno a2 = new Alumno("Carolina",2);
		Alumno a3 = new Alumno("Federico",3);
		System.out.println("El alumno a1 se pudo inscribir a Am1?:");
		try {
			am2.inscribirAlumno(a1);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El alumno a1 se pudo inscribir a Am1?:");
		try {
			am1.inscribirAlumno(a1);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El alumno a2 se pudo inscribir a Am1?:");
		try {
			am1.inscribirAlumno(a2);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El alumno a3 se pudo inscribir a Am1?:");
		try {
			am1.inscribirAlumno(a3);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El alumno a1 se pudo inscribir a Fisica?:");
		try {
			fisica.inscribirAlumno(a1);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El alumno a3 se pudo inscribir a Fisica?:");
		try {
			fisica.inscribirAlumno(a3);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El alumno a1 se pudo inscribir a Algebra?:");
		try {
			algebra.inscribirAlumno(a1);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El alumno a2 se pudo inscribir a Algebra?:");
		try {
			algebra.inscribirAlumno(a2);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El alumno a1 se pudo inscribir a Arquitectura?:");
		try {
			arquitectura.inscribirAlumno(a1);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		a1.aprobar(am1);
		a2.aprobar(am1);
		a1.aprobar(fisica);
		a3.aprobar(fisica);
		a1.aprobar(algebra);
		a2.aprobar(algebra);
		System.out.println("El alumno a1 se pudo inscribir a Am2?:");
		try {
			am2.inscribirAlumno(a1);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El alumno a2 se pudo inscribir a Am2?:");
		try {
			am2.inscribirAlumno(a2);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El alumno a3 se pudo inscribir a Am2?:");
		try {
			am2.inscribirAlumno(a3);
		} catch (CreditosRequeridosInsuficientesException | LimiteCupoException | LimiteMateriasCursadoRegularException
				| RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Imprimir inscriptos por orden alfabetico");
		am2.imprimirInscriptos();
		System.out.println("Imprimir inscriptos por nro. de libreta");
		am2.imprimirInscriptosPorNroLibreta();
		System.out.println("Imprimir inscriptos por creditos obtenidos");
		am2.imprimirInscriptosPorCreditosObtenidos();
	}
}