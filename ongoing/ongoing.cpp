#include <iostream>
#include <vector>
#include <string>

using namespace std;

/**
 * 백준알고리즘 문제 연습장
 * 
 **/

void divideNumPosition(int num, int arry[], int size);

int main() {
    int a = 0;
    int b = 0;
    int res1, res2, res3, res4 = 0;

    int arry_a[] = { 0, 0, 0 };
    int arry_b[] = { 0, 0, 0 };

    std::cin >> a ;
    std::cin >> b ;

    divideNumPosition(b, arry_b, sizeof(arry_b));

    res1 = a * arry_b[2];
    std::cout << res1 << std::endl;

    res2 = (a * arry_b[1]);
    std::cout << res2 << std::endl;

    res3 = (a * arry_b[0]);
    std::cout << res3 << std::endl;

    res4 = res1 + res2*10 + res3*100;
    std::cout << res4 << std::endl;

    // system("pause");
    return 0;
}

void divideNumPosition(int num, int arry[], int size){
    arry[0] = num / 100;
    arry[1] = (num - (arry[0] * 100) ) / 10;
    arry[2] = (num - ((arry[0] * 100) + (arry[1] * 10)));
}