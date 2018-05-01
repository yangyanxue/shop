package util;
import service.RedisToCart;

public class test {
	public static void main(String[] args) {
		test t = new test();
		t.hah();
		
		
	}
	public void hah(){
		RedisToCart.addToCart("yang", 2);
	}

}
