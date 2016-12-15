package padrao;

/**
*
* @author imed
*/
import MatrixApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;
import java.util.*;

public class StartClient {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			Matrix matobj = (Matrix) MatrixHelper.narrow(ncRef.resolve_str("ABC"));

			System.out.println("informe o tamanho da matriz");
			Scanner tmatriz = new Scanner(System.in);
			int tamanho = tmatriz.nextInt();
			int i, j, m[][] = new int[tamanho][tamanho];

			Scanner ler = new Scanner(System.in);

			for (i = 0; i < tamanho; i++) {
				System.out.printf("Informe os elementos %da. linha:\n", (i + 1));
				for (j = 0; j < tamanho; j++) {
					System.out.printf("m[%d][%d] = ", i, j);
					m[i][j] = ler.nextInt();
				}
				System.out.printf("\n");
			}
				String resultado = matobj.mat(tamanho, m);
				System.out.println(resultado);
				System.out.println("-----------------------------------");
			
		} catch (Exception e) {
			System.out.println("Hello Client exception: " + e);
			e.printStackTrace();
		}

	}

}
