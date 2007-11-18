package src;
/**
* Tiene y nos proporciona la información necesaria de los números de 
* DNI de los trabajadores.
* @author F. Javier Cano Llamas (Ing. Inf. Gestión)
*/

public class DNI
{
	/** Contiene el número de DNI */
      private int numDni;

	/**
	* Constructor de clase DNI, con un parámetro.
	* {pre: xifres es un entero más grande que cero}
	* {post: se crea una instancia de la clase DNI donde numDNI = 
	* xifres}.
	* @param xifres representa el número de DNI.
	*/
	public DNI (int xifres)
	{
		numDni = xifres;
	}

	/**
	* Accessor de lectura del número de DNI.
	* {Pre: x es una instancia de la clase DNI}
	* {Post: devuelve el valor del atributo numDni de x}.
	* @return int - el número de DNI
	*/
	public int getNumDni()
	{
		return (numDni);
	}


	/**
	* Método que permite evaluar la igualdad de dos objetos
	* en concreto los números de DNI.
	* {Pre: x es una instancia de la clase DNI y
	* obj es un objeto}
	* {Post: si los númeto de DNI son iguales 
	* x será cierta (true)
	* sino
	* x será falsa (false)}.
	* @param obj representa DNI.
	* @return boolean - Los DNI's son iguales
	*/
	public boolean equals(Object obj)
	{
                DNI altreDni;
                altreDni = (DNI) obj;
                return(altreDni.getNumDni() == getNumDni());
        }

	/**
	* Método que permite realizar una copia para un nuevo DNI.
	* {Pre: x es una instancia de la clase DNI}
	* {Post: se crea una nuevo DNI con el mismo valor que el
 	* primero}.
	* @return java.lang.Object - Nuevo DNI
	*/
	public Object clone()
	{
		return (Object)(new DNI(numDni));
	}

	/**
	* Facilita una representación en formato texto de la clase.
	* {Pre: x es una instancia de la clase DNI}
	* {Post: devuelve una instancia de la clase String que 
	* representa a x}.
	* @return java.lang.String - Una representación en formato texto.
	*/
	public String toString()
	{
		return (Integer.toString(getNumDni()));
	}
}
