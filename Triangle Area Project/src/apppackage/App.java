package apppackage;

import java.io.*;
import ecuacioneslineales.Ecuacion;
import ecuacioneslineales.Punto;

/**
 *
 * @author César Luigi Salcedo Espriella
 */

public class App
{
	public static Double solucion(String e1, String e2, String e3)
	{
		Ecuacion E1 = new Ecuacion(e1);
		Ecuacion E2 = new Ecuacion(e2);
		Ecuacion E3 = new Ecuacion(e3);

		/*System.out.println(E1.xE + "x + y = " + E1.ind);
		System.out.println(E2.xE + "x + y = " + E2.ind + "\n*******************************");
		System.out.println("\n¿Tiene solución?: " + E1.hasSolution(E2));
		if(E1.hasSolution(E2))
		{
			System.out.println("(" + E1.calcX(E2) + ", " + E1.calcY(E2) + ")");
		}*/
		if(!E1.hasSolution(E2))
		{
			System.out.println("No es posible");
			return null;
		}
		if(!E1.hasSolution(E3))
		{
			System.out.println("No es posible");
			return null;
		}
		if(!E2.hasSolution(E3))
		{
			System.out.println("No es posible");
			return null;
		}

		Punto A = new Punto(E1.calcX(E2), E1.calcY(E2));
		Punto B = new Punto(E1.calcX(E3), E1.calcY(E3));
		Punto C = new Punto(E2.calcX(E3), E2.calcY(E3));

		double ladoA = A.getDistance(B);
		double ladoB = A.getDistance(C);
		double ladoC = B.getDistance(C);

		double s = (ladoA + ladoB + ladoC) / 2;
		return (double)Math.round((Math.sqrt(s*(s-ladoA)*(s-ladoB)*(s-ladoC))) * 10000) / 10000;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(new File("data\\area.txt")));
		int a = Integer.parseInt(br.readLine());
		String e1;
		String e2;
		String e3;
		for(int i = 0; i < a; i++)
		{
			e1 = br.readLine();
			e2 = br.readLine();
			e3 = br.readLine();
			System.out.println(solucion(e1, e2, e3) != null ? solucion(e1, e2, e3) : "");
		}
	}
}

