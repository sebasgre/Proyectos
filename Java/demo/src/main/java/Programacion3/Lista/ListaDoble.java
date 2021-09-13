package Java.demo.src.main.java.Programacion3.Lista;

import java.util.Iterator;

public class ListaDoble<T> implements Iterable<T> {

	protected Contenedor<T> raiz;
	protected Contenedor<T> cola;
	protected int tamano;
	
	public ListaDoble() {
		raiz = null;
		cola = null;
		tamano = 0;
	}
	
	public Contenedor<T> getCola() {
		return cola;
	}

	public void setCola(Contenedor<T> cola) {
		this.cola = cola;
	}
	
	public Contenedor<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Contenedor<T> raiz) {
		this.raiz = raiz;
	}
	
	public void insertar(T o) {
		Contenedor<T> nuevo = new Contenedor<T>(o);
		
		if (tamano == 0) {
			raiz = nuevo;
			cola = nuevo;
			return;
		}
		
		raiz.setAnterior(nuevo);
		nuevo.setSiguiente(raiz);
		raiz = nuevo;
		tamano++;
	}
	
	public int tamano() {
		
		return tamano;
		/*int resultado = 0;
		Contenedor<T> actual = raiz;
		
		while(actual != null) {
			resultado++;
			actual = actual.getSiguiente();
		}
		
		return resultado;*/
	}
	
	public void sort() {
		Contenedor<T> actual1 = raiz;
		int i = 0;
		int maxWhile = tamano - 1;
		
		while(maxWhile > 0) {
			i = 0;
			actual1 = raiz;
			
			while(i < maxWhile) {
				
				T obj1 = actual1.getContenido();
				T obj2 = actual1.getSiguiente().getContenido();
				
				Comparable<T> cobj2 = (Comparable<T>)obj2;
				
				if (cobj2.compareTo(obj1) <= 0) {
					actual1.setContenido(obj2);
					actual1.getSiguiente().setContenido(obj1);
				}
				
				actual1 = actual1.getSiguiente();
				i++;
			}
			maxWhile--;
		}
	}
	
	public void vaciar() {
		raiz = null;
	}
	
	public void eliminar(int pos) {
		
		if (pos < 0)
			throw new IndexOutOfBoundsException();
		if (pos >= tamano)
			throw new IndexOutOfBoundsException();
		
		if (pos == 0) {
			raiz = raiz.getSiguiente();
			return;
		}
		
		Contenedor<T> actual = raiz;
		int i = 0;
		while((i+1) < pos && actual.getSiguiente() != null) {
			actual = actual.getSiguiente();
			i++;
		}
		
		actual.setSiguiente(actual.getSiguiente().getSiguiente());
	}
	
	public void add(T o) {
		Contenedor<T> nuevo = new Contenedor<T>(o);
		
		if (tamano == 0) {
			raiz = nuevo;
			cola = nuevo;
			return;
		}
		
		cola.setSiguiente(nuevo);
		nuevo.setAnterior(cola);
		cola = nuevo;
		tamano++;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Contenedor<T> actual = raiz;
		while(actual !=null) {
			sb.append("[" + actual.getContenido().toString() + "]---");
			actual = actual.getSiguiente();
		}
		
		return sb.toString();
	}
	

	@Override
	public Iterator<T> iterator() {
		return new IteradorListaDoble<T>(raiz);
	}
	
	class IteradorListaDoble<T> implements Iterator<T> {

		private Contenedor<T> actual;

		public IteradorListaDoble(Contenedor<T> inicio) {
			actual = inicio;
		}
		@Override
		public boolean hasNext() {
			return actual != null;
		}

		@Override
		public T next() {
			T result = actual.getContenido();
			actual = actual.getSiguiente();
			return result;
		}
		
	}

	class Contenedor<T> {
		private T contenido;
		private Contenedor<T> siguiente;
		private Contenedor<T> anterior;
		
		public Contenedor(T c) {
			contenido = c;
			siguiente = null;
			anterior = null;
		}
		public T getContenido() {
			return contenido;
		}
		public void setContenido(T contenido) {
			this.contenido = contenido;
		}
		public Contenedor<T> getSiguiente() {
			return siguiente;
		}
		public void setSiguiente(Contenedor<T> siguiente) {
			this.siguiente = siguiente;
		}
		
		public Contenedor<T> getAnterior() {
			return anterior;
		}
		public void setAnterior(Contenedor<T> anterior) {
			this.anterior = anterior;
		}
	}

}
