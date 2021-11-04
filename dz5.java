package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class dz5<Final> {
    //6)Крестики-нолики
    //> Разработать консольную игру крестики-нолики. В игре участвуют 2 игрока. Они
    //> по очереди вводят координаты клетки в которую хотят сделать ход. После
    //> каждого хода, в консоли выводится игровое поле с текущим состоянием.
    //> Игра продолжается до победы одного из игроков или ничьи.
    public static final String pustoe = "   ", krestik = " Х ", nulik = " O ";
  public static String aktivnyIgrok;
    public static final int ryadu = 3, stroki = 3;
   public static String[][] pole = new String[ryadu][stroki];
    public static int statusGame;
   public static final int status_Game_idet = 0, status_nichyya = 1, status_pobeda_X = 3, status_pobeda_O = 4;
    public static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
    nachatGame();
   do {
        viborPolya();
       analizPolya();
     viborPolya();
          if (statusGame == status_pobeda_X) {
              System.out.println("Поздравляем ! Победа - Х !");
        } else if (statusGame == status_pobeda_O) {
               System.out.println("Поздравляем! Победа - О !");
          } else if (statusGame == status_nichyya) {
            System.out.println("Ничья!");
           }
        aktivnyIgrok = (aktivnyIgrok == krestik ? nulik : krestik);
      }
     while (statusGame == status_Game_idet);
   }

   public static void nachatGame() {
      for (int ryad = 0; ryad < ryadu; ryad++) {
           for (int str = 0; str < stroki; str++) {
               pole[ryad][str] = pustoe;
          }
   }
      aktivnyIgrok = krestik;
    vivestiPole();
  }

   public static void viborPolya() {
       boolean znachenieVerno = false;
      do {
           System.out.println("Игрок" + aktivnyIgrok + " ввести ряд(1-3) через пробел");
           int ryad = in.nextInt() - 1;
         int str = in.nextInt() - 1;
          if (ryad >= 0 && ryad < ryadu && str >= 0 && str < stroki && pole[ryad][str] == pustoe) {
              pole[ryad][str] = aktivnyIgrok;
              znachenieVerno = true;
            } else {
              System.out.println("Выбранное поле ( " + (ryad + 1) + " , " + (str + 1) + " ) не может быть выбран . " +
                     "Попробуйте еще раз..");
           }
       }
       while (!znachenieVerno);
   }
   public static void analizPolya() {
        String pobeditel = naitiPobeditelya();
       if (pobeditel.equals(krestik)) {
           statusGame = status_pobeda_X;
       } else if (pobeditel.equals(nulik)) {
           statusGame = status_pobeda_O;
       } else if (kletkiZapolneni()) {
          statusGame = status_nichyya;
       } else {
           statusGame = status_Game_idet;
       }
   }
   public static boolean kletkiZapolneni() {
       for (int ryad = 0; ryad < ryadu; ryad++) {
          for (int str = 0; str < stroki; str++) {
               if (pole[ryad][str] == pustoe) {
                  return false;
             }
        }
      }
       return true;
   }

   public static String naitiPobeditelya() {
       int iNumberOfSimilar = 0;
       for (int ryad = 0; ryad < ryadu; ryad++) {
           for (int str = 0; str < stroki; str++) {
              if (!pole[ryad][0].equals(pustoe) && pole[ryad][0].equals(pole[ryad][str])) {
                   iNumberOfSimilar++;
              }
           }
           if (iNumberOfSimilar == 3) {
              return pole[ryad][0];
           }
       }
      for (int column = 0; column < ryadu; column++) {
           iNumberOfSimilar = 0;
          for (int ryad = 0; ryad < ryadu; ryad++) {
              if (!pole[0][column].equals(pustoe) && pole[0][column].equals(pole[ryad][column])) {
                   iNumberOfSimilar++;
              }
        }
     if (iNumberOfSimilar == 3) {
               return pole[0][column];
          }
      }
      if (!pole[0][0].equals(pustoe) && pole[0][0].equals(pole[1][1]) && pole[0][0].equals(pole[2][2])) {
          return pole[0][0];
      }
     if (!pole[0][2].equals(pustoe) && pole[1][1].equals(pole[0][2]) && pole[2][0].equals(pole[0][2])) {
       return pole[0][2];
       }
      return pustoe;
   }

  public static void vivestiPole(){
       for (int ryad = 0; ryad < ryadu; ryad++) {
          for (int str = 0; str < stroki; str++) {
               System.out.print(pole[ryad][str]);
              if (str != stroki - 1) {
                  System.out.print("|");
               }
           }
          System.out.println();
          if (ryad != ryadu - 1) {
               System.out.println("-----------");
           }
       }
       System.out.println();
   }
}

