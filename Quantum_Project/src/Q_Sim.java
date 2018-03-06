//Prady Niraula

import java.util.Scanner;

public class Q_Sim{

	private static Scanner in;

	public static void main(String [] args){
			Q[] q = new Q[128];
			int i=0;
			int index = -1, index2 = -1, beta = 0;
			in = new Scanner(System.in);
			System.out.println("Welcome to Q-Sim. Please input data. Press '?' for a list of commands");
			String str = "";
			while(true){
				str = in.nextLine();
				String[] cmd = str.split(" ");
				
				switch(cmd[0]) {
				
				case "?":
					System.out.println("'new [n]'\t\t\tCreates new qubit with beta value n (1 or 0)\n"
							+ "'pauli-x [k]'\t\t\tInverses the the qubit of index k\n"
							+ "'pauli-y [k]'\t\t\tRotates the qubit of index k around the y-axis\n"
							+ "'pauli-z [k]'\t\t\tRotates the qubit of index k around the z-axis\n"
							+ "'hadamard [k]'\t\t\tRotates the qubit of index k around the (x+z)/sqrt(2) axis\n"
							+ "'read [k]'\t\t\tUnsuperposes qubit of index k & Displays its value\n"
							+ "'swap [k] [l]'\t\t\tSwaps value of qubits of index k & l\n"
							+ "'check [j] [operation]'\t\tReads qubit of index j & performs operation based on outcome\n");
					break;
				
				case "new":
					beta = Integer.parseInt(cmd[1]);
					if(beta==1||beta==0){
						q[i++] = new Q(1-beta, beta);
						System.out.printf("New qubit q%d = "+q[i-1], i-1);
					}
					break;
				
				case "pauli-x":
					index = Integer.parseInt(cmd[1]);
					q[index].NOT();
					System.out.printf("Qubit q%d = "+q[index], index);
					break;
				
				case "pauli-y":
					index = Integer.parseInt(cmd[1]);
					q[index].PauliY();
					System.out.printf("Qubit q%d = "+q[index], index);
					break;
				
				case "pauli-z":
					index = Integer.parseInt(cmd[1]);
					q[index].PauliZ();
					System.out.printf("Qubit q%d = "+q[index], index);
					break; 
				
				case "hadamard":
					index = Integer.parseInt(cmd[1]);
					q[index].Hadamard();
					System.out.printf("Qubit q%d = "+q[index], index);
					break;
				
				case "read":
					index = Integer.parseInt(cmd[1]);
					q[index].Read();
					System.out.printf("Qubit q%d = "+q[index], index); 
					break;
				
				case "swap":
					index = Integer.parseInt(cmd[1]);
					index2 = Integer.parseInt(cmd[2]);
					q[index].Swap(q[index2]);
					System.out.printf("Qubit q%d = "+q[index], index);
					System.out.printf("Qubit q%d = "+q[index2], index2);
					break;
					
				case "check": int c = Integer.parseInt(cmd[1]);
					q[c].Read(); System.out.printf("Qubit q%d = "+q[c], c);
					switch(cmd[2]){
					
					case "pauli-x":
						index = Integer.parseInt(cmd[3]);
						q[index].cNOT(q[c]);
						System.out.printf("Qubit q%d = "+q[index], index);
						break;
					
					case "pauli-y":
						index = Integer.parseInt(cmd[3]);
						q[index].cY(q[c]);
						System.out.printf("Qubit q%d = "+q[index], index);
						break;
					
					case "pauli-z":
						index = Integer.parseInt(cmd[3]);
						q[index].cZ(q[c]);
						System.out.printf("Qubit q%d = "+q[index], index);
						break;
					
					case "hadamard":
						index = Integer.parseInt(cmd[3]);
						q[index].cHadamard(q[c]);
						System.out.printf("Qubit q%d = "+q[index], index);
						break;
					
					case "read":
						index = Integer.parseInt(cmd[3]);
						q[index].cRead(q[c]);
						System.out.printf("Qubit q%d = "+q[index], index);
						break;
					
					case "swap":
						index = Integer.parseInt(cmd[3]);
						index2 = Integer.parseInt(cmd[4]);
						q[index].cSwap(q[index2], q[c]);
						System.out.printf("Qubit q%d = "+q[index], index);
						System.out.printf("Qubit q%d = "+q[index2], index2);
						break;
					}
					break;
					
				case "exit":
					System.exit(0);
					break;
			}
		}
	}
}
