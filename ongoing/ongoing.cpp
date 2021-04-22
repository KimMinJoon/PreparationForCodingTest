#include <iostream>
#include <vector>
#include <string>

using namespace std;

/**
 * 백준알고리즘 문제 연습장
 * 
 **/

int main() {
    int a = 0;
    int b = 0;
    int res = 0;
    int cnt = 0 ;

    std::cin >> a ;
    std::cin >> b ;

    res = a + b;
    std::cout << res << std::endl;

    res = a - b;
    std::cout << res << std::endl;

    res = a * b;
    std::cout << res << std::endl;

    res = a / b;
    std::cout << res << std::endl;

    res = a % b;
    std::cout << res << std::endl;
    
    system("pause");
    return 0;
}