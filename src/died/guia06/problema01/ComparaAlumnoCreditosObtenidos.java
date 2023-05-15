package died.guia06.problema01;

import java.util.Comparator;

public class ComparaAlumnoCreditosObtenidos implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		return o1.creditosObtenidos().compareTo(o2.creditosObtenidos());
	}
}