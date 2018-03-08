package primerParcial;



public class PruebaFecha {
	public static void main(String[] args) {
		Fecha fecha1 = new Fecha(28, 2, 2015);
		fecha1.aumentarDia();
		System.out.println(fecha1);
		fecha1.aumentarDia(365);
		System.out.println(fecha1);
		fecha1.restarDia();
		System.out.println(fecha1);
		fecha1.restarDia(365);
		System.out.println(fecha1);
		Fecha fecha2 = new Fecha(12, 5, 2015);
		System.out.println(fecha2);
		System.out.println(fecha1.esMayorQue(fecha2)>0?"Es mayor":"Es menor");
	}
}
