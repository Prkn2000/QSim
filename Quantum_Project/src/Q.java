//Prady Niraula

public class Q {
	
	private double alpha, beta;
	
	public Q(double zero, double one){
		alpha = zero;
		beta = one;
	}
	
	public boolean getValue(){
		return Math.random()<(Math.pow(beta, 2));
	}
	
	public void NOT(){
		double holder = alpha;
		alpha = beta;
		beta = holder;
	}
	
	public void Hadamard(){
		double betaPrime = (alpha-beta)/Math.sqrt(2);
		double alphaPrime = (alpha+beta)/Math.sqrt(2);
		alpha = alphaPrime;
		beta = betaPrime;
	}
	
	public void PauliY(){
		alpha*=Math.sqrt(-1);
		beta*=-Math.sqrt(-1);
	}
	
	public void PauliZ(){
		beta*=-1;
	}
	
	public void Swap(Q qubit){
		double bHold = beta;
		double aHold = alpha;
		this.alpha = qubit.alpha;
		this.beta = qubit.beta;
		qubit.alpha = aHold;
		qubit.beta = bHold;
	}
	
	public boolean Read(){
		if(getValue()){
			beta = 1;
			alpha = 0;
			return true;
		}
			beta = 0;
			alpha = 1;
			return false;
	}
	
	
	public void cNOT(Q qubit){
			if(qubit.Read())
				this.NOT();
	}
	
	
	public void cHadamard(Q qubit){
		if(qubit.Read())
			this.Hadamard();
	}
	
	
	public void cY(Q qubit){
		if(qubit.Read())
			this.PauliY();
	}
	
	
	public void cZ(Q qubit){
		if(qubit.Read())
			this.PauliZ();
	}
	
	
	public void cSwap(Q qs, Q qubit){
		if(qubit.Read())
			this.Swap(qs);
	}
	
	public void cRead(Q qubit){
		if(qubit.Read())
			this.Read();
	}
	
	public String toString(){
		return String.format("%.2f|0> + %.2f|1>\n", alpha, beta);
		}
	
}
