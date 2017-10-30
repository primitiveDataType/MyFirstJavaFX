
public class AddOperation implements CalculatorOperation {
	public AddOperation( ) {
		super();
	}
	
	public int calculate(int first, int second) {
		return first + second;
	}
}
