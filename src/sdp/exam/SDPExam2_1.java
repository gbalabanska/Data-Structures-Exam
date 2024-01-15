package sdp.exam;

import java.util.Scanner;

/**
 *
 * @author gabriela.balabanska
 */
public class SDPExam2_1
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    int n;
    double x;

    do
    {
      System.out.print("Enter n (positive and less than 10^6): ");
      n = scanner.nextInt();
    }
    while (n <= 0 || n >= 1000000);

    System.out.print("Enter x: ");
    x = scanner.nextDouble();

    double result = findFunction(n, x);
    System.out.printf("Result for F%d(%f)=%f", n, x, result);
  }

  private static double findFunction(int n, double x)
  {
    if (n < 3 || Math.abs(x) < 1000)
    {
      return Math.sqrt(Math.abs(x));
    }
    else if (n >= 3 && Math.abs(x) >= 1000 && n % 2 != 0)
    {
      return findFunction(n - 1, Math.sqrt(Math.abs(x))) - 5 * Math.sqrt(n);
    }
    else if (n >= 3 && Math.abs(x) >= 1000 && n % 2 == 0)
    {
      double func1 = findFunction(n - 1, Math.sqrt(Math.abs(x)));
      double func2 = findFunction(n - 2, Math.sqrt(Math.abs(x)));
      return Math.sqrt(Math.abs(func1 - func2));
    }
    
    //impossible case
    return 0;
  }
  
  
}
