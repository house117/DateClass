package primerParcial;
//Tarea ver pelicula Mente Indomable
//the good wild hunting
//cada comportamiento como ua entidad separada
//sobre carga de metodos diferente lista de parametros 
public class Fecha {
	private Integer mes;  //Variable de instancia de numero de d�as.
	private Integer dia;  //Variable atributo que indica el mes
	private Integer anio; //Variable atributo que indica el a�o
	public Fecha(Integer dia, Integer mes, Integer anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;  	
	}
	public void setDia(int dia) { //metodo para establecer dia
		this.dia = dia;
	}
	public Integer getDia() {   //metodo para obtener dia
		return dia;
	}
	public void setMes(int mes) {  //metodo para establecer mes
		this.mes = mes;

	}
	public Integer getMes() {       //metodo para obtener mes
		return mes;
	}
	public void setAnio(int anio) { //metodo para establecer a�o
		this.anio = anio;
	}
	public Integer getAnio() {        //metodo para obtener a�o
		return anio;
	}
	public String toString() {
		String cadena = String.format("%d/%d/%d\n", dia, mes, anio);
		return cadena;
	}
	/*M�todo esAnioBisiesto
	 * Verifica si el a�o en cuesti�n es bisiesto
	 */
	public boolean esAnioBisiesto() { //metodo boolean para verificar si el a�o es bisiesto
		 return (anio % 4 == 0) && (anio % 100 != 0 || anio % 400 == 0);
	}
	/*M�todo diasDelMes
	 * Obtiene la cantidad de d�as en el mes en cuesti�n
	 */
	private Integer diasDelMes() {
		switch(mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if(esAnioBisiesto()) {
				return 29;
			}
			if(!esAnioBisiesto()) {
				return 28;
			}
		default: return 0;
		}
	}
	/*M�todo diasMesAnterior
	 * Obtiene la cantidad de d�as del 
	 * mes anterior al actual en la
	 * variable de instacia mes */
	private Integer diasMesAnterior() {
		switch(mes) {
		case 5:
		case 7:
		case 10:
		case 12:
			return 30;
		case 9:
		case 4:
		case 6:
		case 11:
		case 1:
		case 2:
		case 8:
			return 31;
		case 3:
			if(esAnioBisiesto()) {
				return 29;
			}
			if(!esAnioBisiesto()) {
				return 28;
			}
		default: return 0;
		}
	}
	/*M�todo que aumenta un dia
	 * a la fecha actual*/
	public void aumentarDia() { 
		dia++;
		if(dia > diasDelMes()) {
			dia = 1;
			mes++;
			if(mes > 12) {
				mes = 1;
				anio++;
			}
		}
	}
	/*M�todo que aumenta N dias 
	 * a la fecha actual
	 */
	public void aumentarDia(Integer cantDias) {
		for(int i=0; i<cantDias; i++) {
			aumentarDia();
		}
	}
	/*M�todo que resta un dia
	 * a la fecha actual
	 */
	public void restarDia() {
		dia--;
		if(dia < 1) {
			dia = diasMesAnterior();
			mes--;
			if(mes < 1) {
				mes = 12;
				anio--;
			}
		}
	}
	/*M�todo que resta N dias 
	 * a la fecha actual
	 */
	public void restarDia(Integer cantDias) {
		for(int i=0; i<cantDias; i++) {
			restarDia();
		}
	}
	/*M�todo esMayorQue, verifica si una fecha dada
	 * es mayor a la fecha en cuesti�n, seg�n el resultado
	 * que devuelve:
	 * Devuelve positivo: la fecha en cuesti�n es mayor
	 * Devuelve 0: las fechas son iguales
	 * Devuelve negativo: la fecha en cuesti�n es menor
	 */
	public Integer esMayorQue(Fecha fechita) {
		Integer resultado = this.anio-fechita.getAnio();
		if(resultado == 0) {
			resultado = this.mes-fechita.getMes();
					if(resultado == 0) {
						resultado = this.dia-fechita.getDia();
					}
		}
		return resultado;
	}
}