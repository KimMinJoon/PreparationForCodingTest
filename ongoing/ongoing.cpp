#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

// string solution(vector<string> participant, vector<string> completion);
bool solution(vector<string> phone_book);

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
     * 방법 : 전화번호의 길이가 짧은 원소로 포함된 문자열이 있는지 탐색하고 있으면 false를 반환하도록한다. 
     *      1. 정렬하여 길이가 짧은 순으로 나열한다. 
     *      2. 자기 자신부터 뒤의 원소들만과 문자열이 포함되었는확인한다. 
     * 
     *
     */
    // map<string, int> m;

    sort(phone_book.begin(), phone_book.end());

    for (int i = 0; i < phone_book.size(); i++) {
        for (size_t j = i+1; j < phone_book.size(); j++) {
            
            if (phone_book[i].find(phone_book[j])) {
                return false;
            }
        }
    }

    return answer;
}






