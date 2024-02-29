import java.util.Scanner;

public class MotorPH {
  static void displayUpperBorder(int menuInput) {
    System.out.println("================================");
    switch (menuInput) {
      case 1:
        System.out.println("|     Employee Information     |");
        break;
      case 2:
        System.out.println("|          Gross Wage          |");
        break;
      case 3:
        System.out.println("|           Net Wage           |");
        break;
      case 0:
        System.out.println("|           Logged out         |");
        break;
    }
    System.out.println("================================");
  }

  static void displayMenu() {
    System.out.println("================================");
    System.out.println("|   Motor PH Payroll System    |");
    System.out.println("================================");
    System.out.println("|   1:  Search Employee        |");
    System.out.println("|   2:  Generate Gross Wage    |");
    System.out.println("|   3:  Generate Net Wage      |");
    System.out.println("|                              |");
    System.out.println("|   0:  Exit Menu              |");
    System.out.println("================================");
  }

  static void clearConsole() {
    for (int i = 0; i < 1000; i++) {
      System.out.println("\n");
    }
  }

  static void showEmployeeInfo(int employeeNumInput) {
    EmployeeInfo info = new EmployeeInfo();

    System.out.println("Last Name: " + info.lastName[employeeNumInput]);
    System.out.println("First Name: " + info.firstName[employeeNumInput]);
    System.out.println("Birthdate: " + info.birthdate[employeeNumInput]);
    System.out.println("Address: " + info.address[employeeNumInput]);
    System.out.println("Phone Number: " + info.phoneNumber[employeeNumInput]);
    System.out.println("SSS #: " + info.sssNumber[employeeNumInput]);
    System.out.println("PhilHealth #: " + info.philhealthNumber[employeeNumInput]);
    System.out.println("TIN #: " + info.tinNumber[employeeNumInput]);
    System.out.println("Pag-IBIG #: " + info.pagIbigNumber[employeeNumInput]);
    System.out.println("Status: " + info.status[employeeNumInput]);
    System.out.println("Position: " + info.position[employeeNumInput]);
    System.out.println("Immediate Supervisor: " + info.immediateSupervisor[employeeNumInput]);
    System.out.println("Basic Salary: " + info.basicSalary[employeeNumInput]);
    System.out.println("Rice Subsidy: " + info.riceSubsidy[employeeNumInput]);
    System.out.println("Phone Allowance: " + info.phoneAllowance[employeeNumInput]);
    System.out.println("Clothing Allowance: " + info.clothingAllowance[employeeNumInput]);
    System.out.println("Gross Semi-monthly Rate: " + info.grossSemimonthlyRate[employeeNumInput]);
    System.out.println("Hourly Rate: " + info.hourlyRate[employeeNumInput]);
  }

  static void showEmployeeGrossWage(int employeeNumInput) {
    EmployeeInfo info = new EmployeeInfo();

    System.out.println("Last Name: " + info.lastName[employeeNumInput]);
    System.out.println("First Name: " + info.firstName[employeeNumInput]);
    System.out.println("Position: " + info.position[employeeNumInput]);

    grossWageCalculation grossWage = new grossWageCalculation();

    double doubledGrossWage = Double.parseDouble(grossWage.calculateGrossWage(employeeNumInput));

    String formattedGrossWage = String.format("%,.2f", doubledGrossWage);
    System.out.println("Gross Wage: ₱" + formattedGrossWage);
  }

  static void showEmployeeNetWage(int employeeNumInput) {
    EmployeeInfo info = new EmployeeInfo();

    System.out.println("Last Name: " + info.lastName[employeeNumInput]);
    System.out.println("First Name: " + info.firstName[employeeNumInput]);
    System.out.println("Position: " + info.position[employeeNumInput]);

    netWageCalculation netWage = new netWageCalculation();

    double doubledNetWage = Double.parseDouble(netWage.calculateNetWage(employeeNumInput));

    String formattedNetWage = String.format("%,.2f", doubledNetWage);
    System.out.println("Net Wage: ₱" + formattedNetWage);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    displayMenu();

    System.out.print("Choose your option: ");
    int menuInput = scanner.nextInt();

    if (menuInput >= 1 && menuInput <= 3) {
      clearConsole();

      // Display upper border based on menu input
      displayUpperBorder(menuInput);

      System.out.print("Employee ID: ");
      // Start the array at 1
      int employeeNumInput = scanner.nextInt() - 1;

      EmployeeInfo info = new EmployeeInfo();

      if (employeeNumInput <= info.totalEmployees) {
        if (menuInput == 1) {
          // Show the employee's information based on inputted number
          showEmployeeInfo(employeeNumInput);
        } else if (menuInput == 2) {
          // Show the employee's gross wage based on inputted number
          showEmployeeGrossWage(employeeNumInput);
        } else if (menuInput == 3) {
          // Show the employee's net wage based on inputted number
          showEmployeeNetWage(employeeNumInput);
        }
      } else {
        System.out.println("\n" + "Employee not found");
      }
    } else if (menuInput == 0) {
      clearConsole();

      displayUpperBorder(menuInput);
    } else {
      System.out.println("\n" + "Invalid input");
    }
  }
}