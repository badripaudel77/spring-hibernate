
public class RandomClass {

	public void thisDemo() {
		System.out.println("this is " + this);

    }
	public static void main(String[] args) {
		
		new RandomClass().thisDemo();
	}
}