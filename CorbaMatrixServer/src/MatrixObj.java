
/**
 *
 * @author imed
 */
import MatrixApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Arrays;
import java.util.Properties;

class MatrixObj extends MatrixPOA {
	private ORB orb;

	public void setORB(ORB orb_val) {
		orb = orb_val;
	}

	// implement matrix() method
	public String mat(int t, int[][] matriz) {
		
		int i, j, inferior, superior;
		String res = null;
		inferior = 0;
		superior = 0;

		int dprincipal[] = new int[t];

		System.out.printf("\n");
		for (i = 0; i < t; i++) {
			System.out.printf("%da. linha: ", (i + 1));
			for (j = 0; j < t; j++) {
				System.out.printf("%d ", matriz[i][j]);

				if (i == j) {
					dprincipal[i] = matriz[i][j];
				}

				if (i < j && matriz[i][j] == 0) {

					inferior++;
				}

				if (i > j && matriz[i][j] == 0) {

					superior++;
				}
			}

			System.out.printf("\n");

		}

		System.out.println("Diagonal Principal: " + Arrays.toString(dprincipal));

		if (inferior > 0 && superior == 0) {
			res = "Matriz triangular inferior";
		}

		if (inferior == 0 && superior > 0) {
			res = "Matriz triangular superior";
		}
		
		return res;

	}

	// implement shutdown() method
	public void shutdown() {
		orb.shutdown(false);
	}

}