#include <stdio.h>

int main(void){
    printf("Hello World!");
    //Variables are like Java variables i.e. "varType varName"
    int age;
    age = 10;

    printf("Enter your age:\n");

    scanf("%i", &age);
    printf("Your age is %i\n", age);
}