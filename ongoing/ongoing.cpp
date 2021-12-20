#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

// https://programmers.co.kr/learn/courses/30/lessons/42577

// string solution(vector<string> participant, vector<string> completion);
bool solution(vector<string> phone_book);
void print_vector(vector<string> &v);

int main() {
    bool isExist;

    vector<string> phone_book = {"456","123","789", "12344"};

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


    
    print_vector(phone_book);
    sort(phone_book.begin(), phone_book.end());
    print_vector(phone_book);

    // 이중 for문을 개선해야함....
    for (size_t i = 0; i < phone_book.size()-1; i++) {
        // 문자열 포함 여부 확인 
            if (phone_book[i+1].find(phone_book[i], 0) == 0) {
                return false;
            }
    }
    
    

    // for (int i = 0; i < phone_book.size(); i++) {
    //     for (size_t j = i+1; j < phone_book.size(); j++) {
            
    //         // 문자열 포함 여부 확인 
    //         if (phone_book[j].find(phone_book[i], 0) == 0) {
    //             return false;
    //         }
    //     }
    // }

    return answer;
}

void print_vector(vector<string> &v) {
    std::cout << "------- vector print  " << std::endl; 
    for (auto str : v) {
        std::cout << str << std::endl;
    }
    std::cout << std::endl;
}






