import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        long[] salaries = new long[n];
        for (int i = 0; i < n; i++) {
            salaries[i] = scanner.nextLong();
        }
        
        String updatedSalaries = Arrays.stream(salaries)
                .mapToDouble(salary -> salary * 1.10)
                .mapToObj(salary -> String.format("%.0f", salary))
                .collect(Collectors.joining(" "));// 
                
        System.out.println(updatedSalaries);
        
        scanner.close();
    }
}