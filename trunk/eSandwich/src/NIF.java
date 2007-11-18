package src;
/**
* Tiene y nos proporciona la información necesaria de los números de NIF de los trabajadores.
* @author F. Javier Cano Llamas (Ing. Inf. Gestión)
*/

public class NIF extends DNI
{
	/** Contiene la letra del NIF */
	private char lletraNif;

	/** Tabla de letras para cálculo de letra según número de DNI */
	private static char[] taulaLletres = {'T','R','W','A','G',
						'M','Y','F','P','D',
						'X','B','N','J','Z',
						'S','Q','V','H','L',
						'C','K','E'};

	/** 
	* Constructor de la clase NIF con un parámetro,
	* crea una nueva instancia de la clase inicializando el nuevo NIF.
	* {pre: xifres es un entero mayor que cero}
	* {post: devuelve una instáncia de la clase NIF con las
	* condiciones indicadas por la post del constructor de la
	* superclasse(DNI) y cálculo de la lletraNif mediante el método calculaLletra()}.
	* @param xifres representa el número de DNI
	*/          
	public NIF (int xifres)
	{
		super(xifres); 
		lletraNif=calculaLletra();
	}

	/**
	* Método que permite calcular la letra del NIF. 
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
	* Método que permite realizar una copia para un nuevo NIF.
	* {Pre: x es una instancia de la clase NIF}
	* {Post: se crea un nuevo NIF con el mismo valor que el primero}.
	* @return java.lang.Object - Nuevo NIF
	*/
	public Object clone()
	{
                return (Object)(new NIF(getNumDni()));
	}

	/**
	* Facilita una representación en formato texto de la classe,
	* amplía el método toString de la superclasse.
	* {Pre: x es una instancia de la clase NIF}
	* {Post: devuelve una instancia de la classe String que representa a x}.
	* @return java.lang.String - Una representación en formato texto.
	*/
      public String toString()
      {
                return (super.toString()+lletraNif);
      }
}
