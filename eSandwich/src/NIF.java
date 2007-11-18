package src;
/**
* Tiene y nos proporciona la informaci�n necesaria de los n�meros de NIF de los trabajadores.
* @author F. Javier Cano Llamas (Ing. Inf. Gesti�n)
*/

public class NIF extends DNI
{
	/** Contiene la letra del NIF */
	private char lletraNif;

	/** Tabla de letras para c�lculo de letra seg�n n�mero de DNI */
	private static char[] taulaLletres = {'T','R','W','A','G',
						'M','Y','F','P','D',
						'X','B','N','J','Z',
						'S','Q','V','H','L',
						'C','K','E'};

	/** 
	* Constructor de la clase NIF con un par�metro,
	* crea una nueva instancia de la clase inicializando el nuevo NIF.
	* {pre: xifres es un entero mayor que cero}
	* {post: devuelve una inst�ncia de la clase NIF con las
	* condiciones indicadas por la post del constructor de la
	* superclasse(DNI) y c�lculo de la lletraNif mediante el m�todo calculaLletra()}.
	* @param xifres representa el n�mero de DNI
	*/          
	public NIF (int xifres)
	{
		super(xifres); 
		lletraNif=calculaLletra();
	}

	/**
	* M�todo que permite calcular la letra del NIF. 
	* {Pre: x es una instancia de la clase NIF}
	* {Post: devuelve la letra (char) de x}.
	* @return char - letra del NIF.
	*/
	private char calculaLletra()
	{
                return (taulaLletres[(getNumDni() % 23)]);
	}

	/**
	* Accessor de lectura de la letra del NIF.
	* {Pre: x es una instancia de la clase NIF}
	* {Post: devuelve el valor del atributo lletraNif de x}.
	* @return char - la letra del NIF
	*/
	public char getLletraNif()
	{
		return (lletraNif);
	}

	/**
	* M�todo que permite realizar una copia para un nuevo NIF.
	* {Pre: x es una instancia de la clase NIF}
	* {Post: se crea un nuevo NIF con el mismo valor que el primero}.
	* @return java.lang.Object - Nuevo NIF
	*/
	public Object clone()
	{
                return (Object)(new NIF(getNumDni()));
	}

	/**
	* Facilita una representaci�n en formato texto de la classe,
	* ampl�a el m�todo toString de la superclasse.
	* {Pre: x es una instancia de la clase NIF}
	* {Post: devuelve una instancia de la classe String que representa a x}.
	* @return java.lang.String - Una representaci�n en formato texto.
	*/
      public String toString()
      {
                return (super.toString()+lletraNif);
      }
}
