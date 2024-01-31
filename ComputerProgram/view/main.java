
package view;

import controller.ComputerProgram;

public class main {
  public static void main(String[] args) {

    while (true) {
      int choices = ComputerProgram.Menu();
      switch (choices) {
        case 1:
          ComputerProgram.normalCalculator();
          break;
        case 2:
          ComputerProgram.BMICalculator();
          break;
        case 3:
          return;
      }
    }
  }
}
