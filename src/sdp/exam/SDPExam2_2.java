package sdp.exam;

import java.util.ArrayList;
import java.util.Collections;
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

    //г)
    List<List<Integer>> diagonals;
    diagonals = findDiagonals(array, r, c);

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

  public static List<List<Integer>> findDiagonals(int[][] array, int row, int col)
  {
    List<List<Integer>> diagonals = new ArrayList<>();
    int offsetFromMainDiagonal; //отстояние от главния диагонал
    
    // diagonals above the main diagonal, starting from the main diagonal
    // count of diagonals above the main diagonal = columns count.
    for (offsetFromMainDiagonal = 0; offsetFromMainDiagonal < col; offsetFromMainDiagonal++)
    {
      // start finding the elements of the first diagonal
      List<Integer> currentDiagonal = new ArrayList<>();
      for (int i = 0; i < row; i++)
      {
        for (int j = 0; j < col; j++)
        {
          if (i == j - offsetFromMainDiagonal)
          {
            currentDiagonal.add(array[i][j]);
            break;
          }
        }
      }
      diagonals.add(currentDiagonal);
    }

    // reverse the order of the list
    Collections.reverse(diagonals);

    // diagonals below the main diagonal
    // count of diagonals below the main diagonal = rows count - 1
    for (offsetFromMainDiagonal = 1; offsetFromMainDiagonal < row; offsetFromMainDiagonal++)
    {
      List<Integer> currentDiagonal = new ArrayList<>();
      for (int i = offsetFromMainDiagonal; i < row; i++)
      {
        for (int j = 0; j < col; j++)
        {
          if (i == j + offsetFromMainDiagonal)
          {
            currentDiagonal.add(array[i][j]);
            break;
          }
        }
      }
      diagonals.add(currentDiagonal);
    }
    return diagonals;
  }

}
