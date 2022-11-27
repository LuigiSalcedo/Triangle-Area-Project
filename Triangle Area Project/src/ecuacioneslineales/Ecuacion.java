package ecuacioneslineales;

/**
 *
 * @author César Luigi Salcedo Espriella
 */

public class Ecuacion
{
	double xE;
	double yE;
	double ind;

	public Ecuacion()
	{
		// Constructor nulo
	}

	public Ecuacion(String eData)
	{
		yE = 1;
		String [] data = eData.split(",");
		xE = -Double.parseDouble(data[0]);
		ind = Double.parseDouble(data[1]);
	}

	public double calcX(Ecuacion e)
	{
		double interX;
		double eV = this.ind + (-e.ind);
		//System.out.println("I = " + (this.ind - e.ind));
		double xE = this.xE + (-e.xE);
		//System.out.println(xE + "X = " + eV);
		interX = eV / xE;
		//System.out.println("X = " + (eV / xE));
		return interX;
	}

	public double calcY(Ecuacion e)
	{
		double cant = Math.abs(this.xE) / Math.abs(e.xE);
		//System.out.println(e.xE + " cabe " + cant + " veces en " + this.xE);
		double interY;
		double eV; 
		if((this.xE > 0 && e.xE > 0) || (this.xE < 0 && e.xE < 0)) cant = -cant;
		eV = this.ind + (cant * (e.ind));
		double yV = this.yE + (cant * e.yE); 
		//System.out.println(yV + "y = " + eV);
		interY = eV / yV;
		return interY;
	}

	public boolean hasSolution(Ecuacion e)
	{
		//System.out.println("Valor teorico: " + this.xE + "(" + this.calcX(e) + ") + " + this.yE + "(" + this.calcY(e) + ") = " + ind);
		//System.out.println("Valor real:    " + this.xE + "(" + this.calcX(e) + ") + " + this.yE + "(" + this.calcY(e) + ") = " + (this.xE * this.calcX(e) + (this.yE * this.calcY(e))));
		return (double)Math.round(((this.xE * this.calcX(e)) + (this.yE * this.calcY(e))) * 1000) / 1000 == ind;
	}
}
