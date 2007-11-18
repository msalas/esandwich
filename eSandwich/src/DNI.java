package src;
/**
* Tiene y nos proporciona la informaci�n necesaria de los n�meros de 
* DNI de los trabajadores.
* @author F. Javier Cano Llamas (Ing. Inf. Gesti�n)
*/

public class DNI
{
	/** Contiene el n�mero de DNI */
      private int numDni;

	/**
	* Constructor de clase DNI, con un par�metro.
	* {pre: xifres es un entero m�s grande que cero}
	* {post: se crea una instancia de la clase DNI donde numDNI = 
	* xifres}.
	* @param xifres representa el n�mero de DNI.
	*/
	public DNI (int xifres)
	{
		numDni = xifres;
	}

	/**
	* Accessor de lectura del n�mero de DNI.
	* {Pre: x es una instancia de la clase DNI}
	* {Post: devuelve el valor del atributo numDni de x}.
	* @return int - el n�mero de DNI
	*/
	public int getNumDni()
	{
		return (numDni);
	}


	/**
	* M�todo que permite evaluar la igualdad de dos objetos
	* en concreto los n�meros de DNI.
	* {Pre: x es una instancia de la clase DNI y
	* obj es un objeto}
	* {Post: si los n�meto de DNI son iguales 
	* x ser� cierta (true)
	* sino
	* x ser� falsa (false)}.
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
	* M�todo que permite realizar una copia para un nuevo DNI.
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
	* Facilita una representaci�n en formato texto de la clase.
	* {Pre: x es una instancia de la clase DNI}
	* {Post: devuelve una instancia de la clase String que 
	* representa a x}.
	* @return java.lang.String - Una representaci�n en formato texto.
	*/
	public String toString()
	{
		return (Integer.toString(getNumDni()));
	}
}
