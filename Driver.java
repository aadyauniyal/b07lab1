package b07lab;

public class Driver {
    public static void main(String[] args) {
        double[] c1 = {6, 0, 0, 5}; 
        int[] p1 = {0, 1, 2, 3}; 
        Polynomial polynomial1 = new Polynomial(c1, p1);
        double[] c2 = {0, -2, 0, 0, -9}; 
        int[] p2 = {0, 1, 2, 3, 4}; 
        Polynomial polynomial2 = new Polynomial(c2, p2); 
        Polynomial sum = polynomial1.add(polynomial2);
        System.out.println("Sum of polynomial1 and polynomial2: " + sum);
        Polynomial product = polynomial1.multiply(polynomial2);
        System.out.println("Product of polynomial1 and polynomial2: " + product);
    }
}
