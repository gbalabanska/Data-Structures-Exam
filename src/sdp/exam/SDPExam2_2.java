package sdp.exam;

import java.util.ArrayList;
import java.util.List;
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

    do
    {
      System.out.print("Enter c, 1≤c≤9: ");
      c = scanner.nextInt();
    }
    while (1 > c || c > 9);

    //б) създава масив, съответен на таблица с r реда и c колони, 
    //и записва в елементите му случайно избрани цели числа от интервала [−12;22];
    int[][] array = new int[r][c];
    Random random = new Random();

    for (int i = 0; i < r; i++)
    {
      for (int j = 0; j < c; j++)
      {
        // random integer in [-12, 22]
        array[i][j] = random.nextInt(23 + 12) - 12;
      }
    }

    //в) извежда табулирано масива;
    System.out.println("-------------- Tabulated array --------------");
      for (int[] elements : array) {
          for (int element : elements) {
              System.out.printf("%7d", element);
          }
          System.out.println();
          System.out.println();
      }

    //г)диагонали
    List<List<Integer>> diagonals = getDiagonals(c, r, array);

    System.out.println("-------------- All diagonals --------------");

    for (List<Integer> diagonal : diagonals)
    {
      for (Integer element : diagonal)
      {
        System.out.print(element + " ");
      }
      System.out.println();
    }

    //г) извежда онези диагонали, в които сумата от елементите в диагонала е нечетна
    System.out.println("-------------- Odd sum diagonals --------------");
    for (List<Integer> diagonal : diagonals)
    {
      int sum = 0;
      for (Integer element : diagonal)
      {
        sum += element;
      }
      if (sum % 2 != 0)
      {
        for (Integer element : diagonal)
        {
          System.out.print(element + " ");
        }
        System.out.print(" (sum = " + sum + ")");
        System.out.println();
      }
    }
  }

  private static List<List<Integer>> getDiagonals(int c, int r, int[][] array) {
    List<List<Integer>> diagonals = new ArrayList<>();
    for (int row = 0, column = c - 1; row < r;)
    {
      List<Integer> currentDiagonal = new ArrayList<>();
      for (int currentRow = row, currentColumn = column; currentRow < r && currentColumn < c; currentRow++, currentColumn++)
      {
        currentDiagonal.add(array[currentRow][currentColumn]);
      }
      diagonals.add(currentDiagonal);
      if (column > 0)
      {
        column--;
      }
      else
      {
        row++;
      }
    }
    return diagonals;
  }
}
