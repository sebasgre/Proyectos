package Lista;

public class Main {
    public static void main(final String[] args) {

        /*ArrayList<String> palabras = new ArrayList();
        palabras.add("Hugo");
        palabras.add("Paco");
        palabras.add("Luis");

        System.out.println(palabras);

        Lista testLista = new Lista();
        testLista.insertar("hugo");
        testLista.insertar("Paco");
        testLista.insertar("Luis");
        System.out.println("Lista2 con Contenedor: " + testLista);

        Lista2<String> a = new Lista2<>();
        a.insertar("hugo");
        a.insertar("Paco");
        a.insertar("Luis");
        System.out.println("Nuestra Lista2: " + a);
        System.out.println("Tamano: " + a.tamano());

        Lista2<String> b = new Lista2<>();
        b.add("Hugo");
        b.add("Paco");
        b.add("Luis");
        b.add("Sebastian");
        b.add("Jose");
        System.out.println("Nuestra Lista2: " + b);
        System.out.println("Tamano: " + b.tamano());*/
        Lista2<String> lista2 = crearLista();
		System.out.println(lista2);

		eliminarUnElemento(lista2);		
		
		System.out.println(lista2);
    }

    public static Lista2<String> crearLista() {
		Lista2<String> lista2 = new Lista2<String>();
		lista2.insertar("hugo");
		lista2.insertar("paco");
		lista2.insertar("luis");
		lista2.insertar("laura");
		
		return lista2;
	}
	
	public static void eliminarUnElemento(Lista2<String> lista2) {
		try {
			lista2.eliminar(2);
		} catch (final Exception e) {
			System.out.println("Mensaje bonito para el cliente: Usó un indice fuera del tamaño de la lista. No se eliminó nada");
		}
	}
}
