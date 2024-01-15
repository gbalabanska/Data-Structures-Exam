package sdp.exam;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author gabriela.balabanska
 */
public class SDPExam2_2
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    //а) въвежда брой на редове r и брой на колони c, като контролира 1≤r≤12 и 1≤c≤9;
    int r, c;
    do
    {
      System.out.print("Enter r, 1≤r≤12: ");
      r = scanner.nextInt();
    }
    while (1 > r || r > 12);
    System.out.println("r = " + r);
    for (int i = r - 1; i >= 0; i--)
    {
      System.out.println("i=" + i);
    }
    do
    {
      System.out.print("Enter c, 1≤c≤9: ");
      c = scanner.nextInt();
    }
    while (1 > c || c > 9);
    System.out.println("c = " + c);
    
    //б) създава масив, съответен на таблица с r реда и c колони, 
    //и записва в елементите му случайно избрани цели числа от интервала [−12;22];
    int[][] array = new int[r][c];
    Random random = new Random();

    for (int i = 0; i < r; i++)
    {
      for (int j = 0; j < c; j++)
      {
        // random integer in [-12, 22]
        array[i][j] = random.nextInt(22 + 12) - 12;
      }
    }

    //в) извежда табулирано масива;
    for (int i = 0; i < array.length; i++)
    {
      for (int j = 0; j < array[i].length; j++)
      {
        System.out.print(array[i][j] + "\t");
      }
      System.out.println();
      System.out.println();
    }

    //г) print diagonals
    printDiagonals(array, r, c);
  }

  public static void printDiagonals(int[][] matrix, int row, int col)
  {
    if (matrix == null || row <= 0 || col <= 0)
    {
      System.out.println("Invalid matrix");
      return;
    }

    System.out.println("Diagonals:");

    // diagonals above the main diagonal
    for (int k = 0; k < col; k++)
    {
      for (int i = 0; i < row; i++)
      {
        for (int j = 0; j < col; j++)
        {
          if (i == j - k && i >= 0 && j < col)
          {
            System.out.print(matrix[i][j] + " ");
          }
        }
      }
      System.out.println();
    }

    // diagonals below the main diagonal
    for (int k = 1; k < row; k++)
    {
      for (int i = k; i < row; i++)
      {
        for (int j = 0; j < col; j++)
        {
          if (i == j + k && i < row && j < col)
          {
            System.out.print(matrix[i][j] + " ");
          }
        }
      }
      System.out.println();
    }
  }

}
