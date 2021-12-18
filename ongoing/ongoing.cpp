#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

// string solution(vector<string> participant, vector<string> completion);
bool solution(vector<string> phone_book);
void print_vector(vector<string> &v);

int main() {
    bool isExist;

    vector<string> phone_book = {"123","456","789"};

    isExist = solution(phone_book);

    std::cout << "answer :" << isExist << std::endl;

    system("pause");
    return 0;
}

bool solution(vector<string> phone_book) {
    bool answer = true;
    
    /**
     * 방법 : 전화번호의 길이가 짧은 원소로 포함된 문자열이 있는지 탐색하여 존재한다면, false를 반환하도록한다. 
     *      1. 정렬하여 길이가 짧은 순으로 나열한다. 
     *      2. 자기 자신부터 뒤의 원소들만과 문자열이 포함되었는확인한다. 
     */
    std::cout << "1 " ;
    print_vector(phone_book);
    sort(phone_book.begin(), phone_book.end());
    // print_vector(phone_book);

    for (int i = 0; i < phone_book.size(); i++) {
        for (size_t j = i+1; j < phone_book.size(); j++) {
            
            // 문자열 포함 여부 확인 
            if (phone_book[j].find(phone_book[i], 0) == 0) {
                return false;
            }
        }
    }

    return answer;
}

void print_vector(vector<string> &v) {
    std::cout << "2 " ;
    // vector<string> vec1 = v;
    std::cout << "3 : " << v[0];
    std::cout << std::endl;
    std::cout << "3 : " << v[1];
    std::cout << std::endl;
    std::cout << "3 : " << v[2];
    std::cout << std::endl;

    std::cout << "3 : " << v.size();
    std::cout << std::endl;

    // for (size_t i = 0; i < v.size(); i++)
    // {
    //     std::cout << "백터 정렬 상태 출력 : " << v[i];
    // }
    

    for (auto str : v) {
        std::cout << "대박이다진짜로 : " << str;
    }
    std::cout << std::endl;
}






