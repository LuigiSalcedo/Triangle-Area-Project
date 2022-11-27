package ecuacioneslineales;

/**
 *
 * @author César Luigi Salcedo Espriella
 */

public class Punto
{
	double x;
	double y;

	public Punto()
	{
		// Constructor nulo
	}

	public Punto(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getDistance(Punto o)
	{
		return Math.sqrt(Math.pow(this.y - o.y, 2) + Math.pow(this.x - o.x, 2));
	}
}
