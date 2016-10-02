package Actividad4;

import java.util.ArrayList;
import java.util.List;

public class ListaArticulos {

	private List<articulo> lista = new ArrayList<articulo>();

	public ListaArticulos() {
	}

	public void add(articulo per) {
		lista.add(per);
	}

	public List<articulo> getListaPersonas() {
		return lista;
	}

}