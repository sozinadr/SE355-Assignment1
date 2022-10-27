#include <iostream> // input/output stream
#include <math.h>
#include <iomanip> // used to manipulate output
#include <unistd.h>
#include <term.h>
#include <list>
#include <vector>


// TEST CLEAR SCREEN CROSS PLATFORM //
/*void clearScreen()
{
	if (!cur_term)
	{
		int result;
		setupterm(NULL, STDOUT_FILENO, &result);
		if (result <= 0)
			return;
	}

	putp(tigetstr("clear"));
}*/

// DIVE INTO CPP //
/*int main() {

	float annualSalary = 0; // cannot store other data types other than float, also cannot be changed after creating.
	std::cout << "What's your annual salary??? ";
	std::cin >> annualSalary;
	float monthlySalary = annualSalary/12; // result of division is usually decimal.
	std::cout << "Your monthly salary is " << monthlySalary << "\nbruh you rich!!!" << std::endl;
	std::cout << "In 10 years, you will earn " << annualSalary*10 << std::endl; // no container made for 10 year salary.

	// character variable, needs single quotation marks, don't use special signs in a variable unless it's "_"
	char character = 'a';
	float firstMonthSalary; //cammel casing
}*/

// BASIC VARIABLES //
/*int main() {

	int yearOfBirth = 2000; // 4 bytes
	char gender = 'M'; // 1 byte
	bool isOlderThan18 = true; // 1 byte
	float averageGrade = 3.4; // 4 bytes
	double accountBalance = 45675474667; // double float / 8 bytes

	std::cout << "Size of int is " << sizeof(int) << " bytes." << std::endl;

	// -1, -2, -3,..., -2147483648
	std::cout << "Int min value is " << INT_MIN << std::endl;

	// 0, 1, 2, 3,..., 2147483647
	std::cout << "Int max value is " << INT_MAX << std::endl;

	std::cout << "Size of Unsigned Int is " << sizeof(unsigned int) << std::endl;
	std::cout << "Unsigned Int max value is " << UINT_MAX << std::endl;

	long long bruh = 2000; // 8 bytes
	std::cout << sizeof(long long);
	return 0;
}*/

// DATA TYPE OVERFLOW //
/*int main() {

	int intMax = INT_MAX;

	std::cout << intMax << std::endl;
	std::cout << intMax+1 << std::endl; // Data type overflow / will output INT_MIN
	return 0;
}*/

// ASCII TABLE //
/*int main() {

	std::cout << (int)'a' << std::endl; // casting operator / forces a data type to convert into another.
	std::cout << int('a') << std::endl; // telling the computer what is 'a' as a number.
	std::cout << int('A') << std::endl;

	std::cout << (char)99 << std::endl;
	std::cout << char(67) << std::endl;

	return 0;
}*/

// PLAY WITH ASCII //
/*int main () {

	char c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0;

	std::cout << "Enter 5 letters: ";
	std::cin >> c1 >> c2 >> c3 >> c4 >> c5;
	std::cout << "ASCII message: " << int(c1) << " " << int(c2) << " " << int(c3) << " " << int(c4) << " " << int(c5) << std::endl;
	std::cout << "ASCII message: " << (int)c1 << " " << (int)c2 << " " << (int)c3 << " " << (int)c4 << " " << (int)c5 << std::endl; //casting

	int i1, i2, i3, i4, i5;

	std::cout << "Enter 5 letter numbers: ";
	std::cin >> i1 >> i2 >> i3 >> i4 >> i5;
	std::cout << "ASCII message: " << char(i1) << char(i2) << char(i3) << char(i4) << char(i5) << std::endl;
	std::cout << "ASCII message: " << (char)i1 << (char)i2 << (char)i3 << (char)i4 << (char)i5; // casting

	return 0;
}*/

////////////////////////////////// SELECTION, SEQUENTIAL AND ITERATIONS //////////////////////////////////

// SELECTION / SIMPLE IF STATEMENTS //
/*int main() {

	int userInput = 0;

	std::cout << "Enter a whole number to see if it's even or odd: ";
	std::cin >> userInput;

	if (userInput % 2 == 0) {
		std::cout << userInput << " is even." << std::endl;
	} else {
		std::cout << userInput << " is odd." << std::endl;
	}

	std::cout << "Your welcome, bye!" << std::endl;
	return 0;
}*/

// IF STATEMENT EXAMPLE //
/*int main() {

	float baseInput, heightInput, widthInput;

	std::cout << "Enter 3 whole numbers for  a triangle: ";
	std::cin >> baseInput >> heightInput >> widthInput;

	if (baseInput == heightInput && heightInput == widthInput) {
		std::cout << "it's a meee equilateral triangle." << std::endl;
	}
	// else if ((baseInput == heightInput && heightInput != widthInput) || (baseInput != heightInput && heightInput == widthInput) || (baseInput == widthInput && widthInput != heightInput)) {
	// 	std::cout << "it's a meee isosceles triangle." << std::endl;
	// }
	else if (baseInput != heightInput && heightInput != widthInput && baseInput != widthInput) {
		std::cout << "it's a meee scalene triangle." << std::endl;
	} else {
		std::cout << "it's a meee isosceles triangle." << std::endl;
	}
	
	std::cout << "Your welcome, bye!" << std::endl;
	return 0;
}*/

// SOME BASIC INCREMENT AND DECREMENT STUFF //
/*int main() {

	int num = 10;
	std::cout << num++ << std::endl; //output 10 then add 1 (post increment)
	std::cout << num << std::endl; // 11

	int num2 = 10;
	std::cout << ++num2 << std::endl; // add 1 and then output 11 (pre increment)
	std::cout << num2 << std::endl; // 11

	int num3 = 10;
	std::cout << (num3 + 1) << std::endl; // 11 (doesn't store 11 in num3 tho, it just adds 1 to the output)
	std::cout << num3 << std::endl; // 10
	// num++ and ++num != (num + 1) but they equal (num = num + 1)

	int num4 = 10;
	std::cout << (num4+=1) << std::endl; // num4 = num4 + 1 = 11
	std::cout << num4 << std::endl; // 11

	int num5 = 10;
	int num6 = 10;
	std::cout << num5 + (num6++) << std::endl; // num5 + num6 and then add 1 to num6
	std::cout << num6 << std::endl; // 11

	int num7 = 10;
	int num8 = 10;
	std::cout << (num7++) + num8 << std::endl; // add num7 to num8 and then add 1 to num7
	std::cout << num7 << std::endl; // 11

	return 0;
}*/

// SWAPPING VALUES OF TWO VAR USING A THIRD VAR//
/*int main () {

	int a = 20;
	int b = 10;
	int c;

	c = a;
	a = b;
	b = c;

	std::cout << a << std::endl; // 10
	std::cout << b << std::endl; // 20

	return 0;
}*/

// SWAPPING VALUES OF TWO VAR WITHOUT USING A THIRD VAR //
/*int main () {

	int a = 20;
	int b = 10;

	a = a + b; //30
	b = a - b; //20
	a = a - b; //10

	std::cout << a << std::endl; // 10
	std::cout << b << std::endl; // 20

	return 0;
}*/

// REMOVE FIRST DIGIT OF A NUMBER //
/*int main () {
	int input2 = 0;
	std::cout << "Enter a number: ";
	std::cin >> input2;

	if (input2 == 0)
	{
		std::cout << "bruh your number is 0" << std::endl;
	}
	else
	{
		input2 %= static_cast<int>(pow(10, static_cast<int>(log10(input2)))); //size_t 
	}
	std::cout << input2 << std::endl;

	return 0;
}*/

// BMI Calculator //
/*int main () {

	float bmi = 0, weightKg = 0, height = 0;
	float underWeight = 18.5; //bmi
	float overWeight = 25; //bmi

	std::cout << "What is your weight fatso? in KG: ";
	std::cin >> weightKg;

	std::cout << "What is your height short stuff? in Meters: ";
	std::cin >> height;
	bmi = weightKg / (height*height);

	if (bmi < underWeight) {
		std::cout << "Bro, Eat something, you'll die as a stickman..." << std::endl;
		 std::cout << "Your Body mass index is " << bmi << std::endl;
	} else if (bmi > overWeight) {
		std::cout << "Dude, Go out, touch some grass and move some muscles, you fat bitch..." << std::endl;
		std::cout << "Your Body mass index is " << bmi << std::endl;
	} else {
		std::cout << "Good stuff my dude, good stuff" << std::endl;
		std::cout << "Your Body mass index is " << bmi << std::endl;
	}

	return 0;
}*/

// BASIC CALCULATOR USING SWITCHES/SELECTION //
/*int main () {

	float num1 = 0, num2 = 0, result = 0;
	char operationSign;
	std::cout << "**SpaceGoat Calculator**";
	std::cin.ignore();
	std::cout << "Hey broski, enter a number, followed by what operation (+, -, *, /, %) you wanna do and a second number: ";
	std::cin >> num1 >> operationSign >> num2;

	switch (operationSign) {
		case '-': 
				result = num1 - num2;
				std::cout << "The answer to your question is " << result << std::endl;
				break;
		case '+': 
				result = num1 + num2;
				std::cout << "The answer to your question is " << result << std::endl;
				break;
		case '*': 
				result = num1 * num2;
				std::cout << "The answer to your question is " << result << std::endl;
				break;
		case '/': 
				result = num1 / num2;
				std::cout << "The answer to your question is " << result << std::endl;
				break;
		case '%': 
				bool isNum1Int, isNum2Int;
				
				isNum1Int = (num1 == static_cast<int>(num1)); // if the num1 is .0 then true
				isNum2Int = (num2 == static_cast<int>(num2)); // if the num2 is .0 then true

				if (isNum1Int && isNum2Int) {
					result = static_cast<int>(num1) % static_cast<int>(num2);
					std::cout << "The answer to your question is " << result << std::endl;
				} else {
					std::cout << "one or more of your inputs is not an integer, operation cannot be performed..." << std::endl;
				}

				break;
		default: std::cout << "Incorrect input..." << std::endl;
	}

	return 0;
}*/

// PROGRAM TO CHECK THE NUMBER OF DAYS IN A MONTH USING SWITCHES/SELECTION //
// (inYear % 4 = 0, and inYear % 100 != 0 or inYear % 400 == 0) //
/*int main() {

	int inYear, inMonth;
	std::cout << "Enter year and month: ";
	std::cin >> inYear >> inMonth;

	switch (inMonth) {
		case 2: 
				if ((inYear % 4 == 0 && inYear % 100 != 0) || inYear % 400 == 0) {
					std::cout << "There are 29 days in this month!" << std::endl;
				} else {
					std::cout << "There are 28 days in this month!" << std::endl;
				}
				break;
		case 4: 
		case 6: 
		case 9: 
		case 11:
			// to minimize writing a lot of code and since 4 months out of the year have 30 days in them
			std::cout << "There are 30 days in this month!" << std::endl;  
			break;
		case 1:
		case 3:
		case 5: 
		case 7: 
		case 8: 
		case 10: 
		case 12:
			// to minimize writing a lot of code and since 7 months out of the year have 31 days in them
			std::cout << "There are 31 days in this month!" << std::endl;
			break;
		default: std::cout << "Invalid month!" << std::endl;
	}

	return 0;
}*/

// CHECK IF THE NUMBERS BTW 100-500 ARE DIVISBLE BY 3 and 5 USING WHILE LOOP/ITERATIONS //
/*int main() {

	int counter = 100;
	while (counter <= 500) {
		if (counter % 3 == 0 && counter % 5 == 0) {
			std::cout << counter << " is divisible by 3 and 5." << std::endl; //
		}
		counter++;
	}

	return 0;
}*/

// COUNT THE DIGITS OF A NUMBER USING WHILE LOOP/ITERATIONS //
/*int main() {

	long long input = 0;
	std::cout << "Enter a number: ";
	std::cin >> input;

	if (input == 0) {
		std::cout << "bruh your number is 0." << std::endl;
	} else {
		// to check for negative numbers too
		if (input < 0) {
			// input *= -1;
			//OR
			input = -input; // -(-input) basically
		}

		int counter = 0;
		while (input > 0) {
			input /= 10;
			counter++;
		}
		std::cout << counter << std::endl;
	}

	return 0;
}*/

// REVERSING DIGITS OF A NUMBER USING WHILE LOOP/ITERATIONS //
/*int main() {

	long long input = 0, reversedInput = 0, lastDigit = 0;
	std::cout << "Enter a number: ";
	std::cin >> input;

	while (input != 0) {
		lastDigit = input % 10; //getting last digit from input
		reversedInput = reversedInput*10 + lastDigit; // reversing the input one by one
		input /= 10; //taking out last digit from input
	}

	std::cout << "Reversed: " << reversedInput << std::endl;

	return 0;
}*/

// PIN VALIDATION USING DO WHILE LOOP/ITERATIONS //
/*int main() {

	int usersPin = 6969, inputPin = 0, allowedAttempts = 3;

	std::cout << allowedAttempts << " Attempts are allowed." <<std::endl;
	do { //still executes at least once even if the condition is false
		std::cout << "PIN: ";
		std::cin >> inputPin;
		if (inputPin != usersPin) {
			std::cout << "Incorrect PIN brainlet :| \t";
			allowedAttempts--;
			if (allowedAttempts > 0)
			{
				std::cout << allowedAttempts << " Attempts left..." << std::endl;
			} else {
				std::cout << "\nYou fucked up bro, enjoy the lock." << std::endl;
			}
		} else {
			std::cout << "Voila, enjoy the trip!" << std::endl;
		}

	} while (allowedAttempts > 0 && inputPin != usersPin);

	return 0;
}*/

// CALCULATING THE FACTORIAL OF A NUMBER USING FOR LOOP/ITERATIONS //
/*int main() {

	int input = 0;
	std::cout << "Enter a number to find its factorial: ";
	std::cin >> input; // 6
	if (input > 0) {
		//6! = 1*2*3*4*5*6
		long int factorial = 1; // equalize factorial to 1
		for (int i = 1; i <= input; i++) {
			// 1*1 so factorial = 1, 1*2 so factorial = 2, 2*3 so factorial = 6, 6*4 so factorial = 24 and so on ... 24*5, 120*6
			factorial = factorial * i; 
		}

		std::cout << "The factorial is " << factorial << std::endl;
		
		// OR 
		//6! = 6*5*4*3*2*1
		factorial = 1;
		for (int i = input; i >= 1; i--) {
		// 1*6 so factorial = 6, 6*5 so factorial = 30, 30*4 so factorial = 120, 120*3 so factorial = 360 and so on ... 360*2, 720*1
			factorial = factorial * i; 
		}

		std::cout << "The factorial is " << factorial << std::endl;
	} else {
		std::cout << "Man, ur such an idiot, enter something more than 0..." << std::endl;
	}

	return 0;
}*/

// NESTED LOOPS/FOR AND DO WHILE LOOPS //
/*int main() {
	//grades entered that vary from 1 to 5 range
	float grade = 0, sum = 0;
	int gradeNumbers = 0;
	std::cout << "Enter how many grades you want to calculate the average for: ";
	std::cin >> gradeNumbers;

	for (int i = 1; i<=gradeNumbers; i++) {

		do {
			std::cout << "Enter grade " << i << ": ";
			std::cin >> grade;

		// OR while (grade < 1 || grade > 5)
		} while (!(grade >= 1 && grade <= 5)); // repeat if the grade is something out of range (1-5)
		sum += grade;

	}

	std::cout << "Your average grade is: " << sum/gradeNumbers << std::endl;

	return 0;
}*/

// MULTIPLICATION TABLE USING NESTED FOR LOOPS //
/*int main() {

	for (int i = 1; i <= 2000; i++) { // +1 to i each time the inner loop goes through j from 1 to 10
		for (int j = 1; j <= 2000; j++) {
			std::cout << i << " x " << j << " = " << i*j << std::endl;
		}
		std::cout << std::endl;
	}

	return 0;
}*/

// DRAWING RECTANGLES USING NESTED FOR LOOPS //
/*int main() {

	int row, column; // row from left to right, column from top to bottom
	char symbol;
	std::cout << "Row: ";
	std::cin >> row;
	std::cout << "Column: ";
	std::cin >> column;
	std::cout << "Symbol: ";
	std::cin >> symbol;
	std::cout << std::endl;

	for (int r = 0; r < row; r++) { // +1 to r each time the inner loop goes through c from the column input
		for (int c = 0; c < column; c++) {
			std::cout << std::setw(3) << symbol; // setw sets field width
		}
		std::cout << std::endl; // next row
	}

	return 0;
}*/

// DRAWING A RIGHT TRIANGLE USING NESTED FOR LOOPS //
/*int main() {

	int length;
	char symbol;
	std::cout << "Length: ";
	std::cin >> length;
	std::cout << "Symbol: ";
	std::cin >> symbol;
	std::cout << std::endl;

	for (int h = 1; h <= length; h++) { // +1 to h each time the inner loop goes through w from h
		for (int w = 1; w <= h; w++) {
			std::cout << std::setw(2) << symbol; // setw sets field width
		}
		std::cout << std::endl; // next row
	}
	std::cout << std::endl;

	for (int h = length; h >= 1; h--)
	{
		for (int w = 1; w <= h; w++)
		{
			std::cout << std::setw(2) << symbol; // setw sets field width
		}
		std::cout << std::endl; // next row
	}

	return 0;
}*/

// FUNCTIONS //
/*void func(); // declaration of function

int main() {

	std::cout << "Hello from main()" << std::endl;
	func(); //calling func()
	func();

	return 0;
}

void func() { // definition of function, void doesn't return anything
	std::cout << "Hello from func()" << std::endl;
}*/

/*
A function with default parameters, can be called with 2, 3 or 4 arguments.
int sum(int, int, int, int);

nt main() {

	sum(22, 25); // 2 args
	sum(23, 28, 30); // 3 args
	sum(29, 35, 44, 55); // 4 args

	return 0;
}

default parameters can only be specified at the end of the parameter list
int sum(int x, int y, int z = 0, int w = 0) { 
	return (x + y + z + w);
}
*/

// FUNCTIONS WITH PARAMETERS/ARGUMENTS //

// returnType functionName(dataType1, dataType2, ...);
/*void introduceMe(std::string, int, int, std::string); // for declaration, we only specify parameter types

int main() {

	std::string userName, userCity;
	int userAge, userSalary;
	
	std::cout << "Name: ";
	std::cin >> userName;
	std::cout << "Age: ";
	std::cin >> userAge;
	std::cout << "Annual Salary: ";
	std::cin >> userSalary;
	std::cout << "City: ";
	std::cin >> userCity;
	std::cout << std::endl;
	introduceMe(userName, userAge, userSalary, userCity);

	//when we call a function, we can pass arguments into its paramters
	// introduceMe("SpaceGoat", 21, 65000, "Sulaymaniyah");
	// introduceMe("Nini", 22, 75000, "Erbil");


	return 0;
}

void introduceMe(std::string name, int age, int salary, std::string city) {
	std::cout << "My name is " << name << std::endl;
	std::cout << "I'm " << age << " years old" <<std::endl;
	std::cout << "My annual salary is $" << salary << std::endl;
	std::cout << "I live in " << city << " city" <<std::endl;
}*/

// RETURN STATEMENT OF FUNCTIONS/CHECKING FOR PRIME NUMBERS //
// a function can only return a value once.

/*bool primeNums(int);

int main() {

	// int input;
	// std::cout << "Enter a number: ";
	// std::cin >> input;
	// if (isPrimeNum(input)) {
	// 	std::cout << "The number is a prime number." << std::endl;
	// } else {
	// 	std::cout << "The number is not a prime number." << std::endl;
	// }

	bool isPrime = false;
	int primeCount = 0;
	int counter = 0;
	for (int i = 1; i <= 1000000; i++) {
		isPrime = isPrimeNum(i);
		if (isPrime) {
			std::cout << i << " is a prime number." << std::endl;
			primeCount++;
		} else {
			std::cout << i << " is not a prime number." << std::endl;
		}
		counter++;
	}
	std::cout << "There are " << primeCount << " prime numbers among " << counter << " numbers."<< std::endl;

	return 0;
}

bool isPrimeNum(int num) {

	if (num <= 1) { // 1 and smaller aren't prime numbers.
		return false;
	}

	// loop to check if they are divisible by numbers other than itself.
	// the loop runs only if 'i' (denominator/divisor) was smaller than 'num'.
	// since a number isn't divisible by the denominator if the denominator is greater.
	// denominator 'i' starts from 2 cuz every number is divisible by 1
	// (i < num) and not (i <= num) since every number is divisible by itself.
	for (int i = 2; i < num; i++) {
		if (num % i == 0) { // to check if they are divisible by other numbers.
			return false;
		}
	}

	return true; // after checking the facts and they were prime numbers, then return true.
}*/

// FUNCTION OVERLOADING/SAME FUNCTION NAME WITH DIFFERENT PARAMETER DATATYPES //
/*double sum(double); // no issue
int sum(int, int); // no issue
int sum(int, int, int); // no issue
int sum(double, double); // no issue but will always return an integer
double sum(int, double); // no issue as long as first argument passed is an int and second argument is a double
double sum(double, double, double);

// issue, Overloaded functions may or may not have different return types but they must have different parameters!!!
// double sum(double, double)
// 2 same named funcs with different return types and same parameters gives error.
// however, same return type and different parameters or different number of parameters are good.

int main() {

	std::cout << sum(1.1, 1.1, 1.2) << std::endl;
	return 0;
}

double sum(double a, double b, double c) {
	return a + b + c;
}*/


// ATM APP //
/*void showMenu();
void menuSettings();
double balance = 500; //global variable
int option; //global variable

int main() {

	// check balance, deposit, withdraw, show menu

	// showMenu();
	// menuSettings();

	// OR
	do {
		showMenu();

		std::cout << "Option: ";
		std::cin >> option;
		std::system("clear");

		switch (option)
		{
		case 1:
			std::cout << "Your balance is " << balance << "$\n" << std::endl;
			std::cout << "Press Enter to continue..." << std::endl;
			break;
		case 2:
			std::cout << "Deposit amount: ";
			double depositAmount;
			std::cin >> depositAmount;
			balance += depositAmount;
			std::cout << "New balance is " << balance << "$\n" << std::endl;
			std::cout << "Press Enter to continue..." << std::endl;
			break;

		case 3:
			std::cout << "Withdraw amount: ";
			double withdrawAmount;
			std::cin >> withdrawAmount;
			if (balance >= withdrawAmount)
			{
				balance -= withdrawAmount;
				std::cout << "New balance is " << balance << "$\n" << std::endl;
				std::cout << "Press Enter to continue..." << std::endl;
			}
			else
			{
				std::cout << "bro, u broke, balance hasn't changed.\n" << std::endl;
				std::cout << "Press Enter to continue..." << std::endl;
			}
			break;
		default:
			std::cout << "uh uh, fuck you...\n" << std::endl;
			std::cout << "Press Enter to Exit..." << std::endl;
		}
		std::cin.ignore(); // ignores the enter after inputting so the "press enter to continue" works properly.
		getchar();
	} while (option != 4);
	
	return 0;
}

void showMenu() {
	std::cout << "**********MENU**********\n" << std::endl;
	std::cout << "1. Check balance" << std::endl;
	std::cout << "2. Deposit" << std::endl;
	std::cout << "3. Withdraw" << std::endl;
	std::cout << "4. Exit\n" << std::endl;
	std::cout << "************************" << std::endl;
}*/

/*void menuSettings() {

	int option;

	std::cout << "Option: ";
	std::cin >> option;

	switch (option)
	{
	case 1:
		std::cout << "Your balance is " << balance << "$" << std::endl;
		break;
	case 2:
		std::cout << "Deposit amount: ";
		double depositAmount;
		std::cin >> depositAmount;
		balance += depositAmount;
		std::cout << "New balance is " << balance << "$" << std::endl;
		break;

	case 3:
		std::cout << "Withdraw amount: ";
		double withdrawAmount;
		std::cin >> withdrawAmount;
		if (balance >= withdrawAmount)
		{
			balance -= withdrawAmount;
			std::cout << "New balance is " << balance << "$" << std::endl;
		}
		else
		{
			std::cout << "bro, u broke, balance hasn't changed." << std::endl;
		}
		break;
	default:
		std::cout << "uh uh, fuck you..." << std::endl;
		return;
	}
	showMenu();
	menuSettings();
}*/


// PASS BY REFERENCE AND VALUE //

/*void swapVar(int, int);
void swapVar2(int &, int &);

// passing by value copies the argument's value into the callee (where it is put on the callee's stack). 
// passing by reference passes the address of the argument into the callee
int main() {

	int num1 = 900, num2 = 200;

	// pass by value and pass by reference both give same results, however first only passes the values,
	// second passes the references of the variables (addresses), thus whatever the called function does, 
	// will be pointed to the passed addresses, and that'll be reflected inside the function where 
	// we have called the other function using pass by reference, main() here.

	swapVar(900,200);  // the values of 900 and 200 are passed as arguments
	swapVar(num1, num2); // the values of num1 and num2 are passed as arguments
	// since when pass by value, the called function only gets the values and use them inside itself
	// the actual variables inside main() aren't modified
	std::cout << num1 << " - " << num2 << std::endl; // outputs 900 and 200

	swapVar2(num1, num2); // the reference of num1 and num2 variables are passed as arguments (addresses of num1 and num2)
	// when passed by reference, the called function gets the addresses, and any work done on the variables 
	// of that function, will be pointed to the passed addresses, hence working on the actual variables inside main()
	std::cout << num1 << " - " << num2 << std::endl; // outputs 200 and 900
	// swapVar2(900, 200); we cannot pass hardcoded values by reference since they aren't stored on any addresses

	return 0;
}

// pass by value
void swapVar(int a, int b) {
	a = a + b; // if a = 10 and b = 20, now a = 30
	b = a - b; // b = 30 - 20, so b = 10
	a = a - b; // a = 30 - 10, so a = 20
	std::cout << "First variable is " << a << ", second is " << b << std::endl;
}

// pass by reference
// we use & to denote that the function accepts addresses as parameters
// so the function modifies the actual addresses of the variables in main()
void swapVar2(int &a, int &b) { 
	int temp = a;
	a = b;
	b = temp;
	std::cout << "First variable is " << a << ", second is " << b << std::endl;
}*/


// GENERIC FUNCTIONS AND TEMPLATES //

/*template <typename T> // creating a generic datatype, here T
// OR template <class T>
void swapVar(T &a, T &b) { // T is a generic datatype, thus changes based on the type of variable reference you pass in
	T temp = a;
	a = b;
	b = temp;
}


int main() {

	int a = 5, b = 10;
	std::cout << a << " - " << b << std::endl;

	swapVar<int>(a, b); // swapVar is called with an int datatype and int references are passed in as arguments
	std::cout << a << " - " << b << std::endl;

	char c = 'c', d = 'd';
	std::cout << c << " - " << d << std::endl;

	swapVar<char>(c, d); // swapVar is called with a char datatype and char references are passed in as arguments
	std::cout << c << " - " << d << std::endl;


	return 0;
}*/


// RECURSION AND RECURSIVE FUNCTIONS //
// SUM OF NUMBERS BETWEEN m-n INCLUDING and m-n

/*int sumOfNumsBtw(int, int);
int factorial(int);

int main() {

	int m = 1, n = 4;

	// int sum = 0;
	// for (int i = m; i <= n; i++) {
	// 	sum += i;
	// }
	// std::cout << sum << std::endl;
	std::cout << sumOfNumsBtw(m, n) << std::endl;
	std::cout << factorial(0) << std::endl;

	return 0;
}

int sumOfNumsBtw(int a, int b) { // a=1 becomes a=2 becomes a=3 becomes a=4, b=4
	if (a == b) {
		return a;
	}

	return a + sumOfNumsBtw(a + 1, b); // 1 + (2+(3+(4))) each () is a recursion
}

int factorial(int a) { // factorial of a number using recursion
	if (a > 1) {
		// if a = 6, 6*(5*(4*(3*(2)))) = 720
		return a*(factorial(a-1)); 
	} else if (a == 1) { // factorial of 1 is just 1
		return a;
	}
	return 0; // factorial of 0 and below is always 0
}*/


/*class Account {
	public:
		std::string Name;
		double Balance;
		double WithdrawAmount;
		double DepositAmount;
		//std::list<std::string> FamilyNames;
};

int main() {

	Account acc1;
	Account acc2;

	acc1.Name = "George";
	acc2.Name = "John";

	return 0;
}*/



/*class ClassA {
	public:
		int x = 10;

};

int main() {

	// 2 pointers pointing to the same object??
	// ClassA cls1, cls2;
	// cls2 = cls1;
	// std::cout << cls1.x << std::endl;
	// std::cout << cls2.x << std::endl;

	//creating object cls1 and cls2, and pointing cls2 to cls1
	// ClassA cls1, cls2;
	// cls2 = cls1;
	// std::cout << cls1.x << std::endl;
	// std::cout << cls2.x << std::endl;



	return 0;
}*/

// OOP - represent real life objects in programming together with their attributes(properties) and behaviors(features) //
// Class: template, blueprint to be used when we create an object from it
// Object: an instance of a class.
// We create a class to only specify and describe any object, and only an object created from that class allocates memory
// variables declared inside a class are called data members
// Functions declared inside a class are called member functions
// by default functions and variables are private when declared inside a class thus only accessible by the class itself

// class youtubeChannel
// { // user-defined data type (to represent a real life object)
// public:
// 	std::string Name;
// 	std::string OwnerName;
// 	int SubscribersCount;
// 	std::list<std::string> PublishedVideoTitles;
// };

// int main()
// {

// 	youtubeChannel ytChannel;
// 	ytChannel.Name = "CinnamonToastKen";
// 	ytChannel.OwnerName = "Ken";
// 	ytChannel.SubscribersCount = 5000000;
// 	ytChannel.PublishedVideoTitles = {"90 days fiance Video 1", "90 days fiance Video 2", "90 days days fiance Video 3"};

// 	return 0;
// }

// std::string str = "test";

// void someFunc(std::string s) { std::cout << s << std::endl; }

// void someFunc2(std::string &s) {
//   std::cout << s << std::endl;
//   s = "test2";
// }

// void someFunc3(const std::string &s) { std::cout << s << std::endl; }

// int main() {

//   someFunc(str); // s is a copy of str as it was passed by value
//   someFunc2(str); // s is str as it was passed by reference, str is also modified
//   someFunc3(str); // s is str as it was passed by reference but it cannot be
//                   // modified because marked const
//   return 0;
// }

