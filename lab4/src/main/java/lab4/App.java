/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lab4;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        binPack(20, 8, new int[] {12, 4, 8, 15, 9, 3, 1});
    }

    public static void binPack(int b, int n, int[] items) {
        int numbins = 3;
        //int[][] bins = new int[numbins][b];
        
    }
}
