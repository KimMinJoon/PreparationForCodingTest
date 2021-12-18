
#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

// https://programmers.co.kr/learn/courses/30/lessons/42577

bool solution(vector<string> phone_book) {
    bool answer = true;
    
    /**
     * 방법 1 : 전화번호의 길이가 짧은 원소로 포함된 문자열이 있는지 탐색하여 존재한다면, false를 반환하도록한다. 
     *      1. 정렬하여 길이가 짧은 순으로 나열한다. 
     *      2. 자기 자신부터 뒤의 원소들만과 문자열이 포함되었는확인한다. 
     * 결과 :
     *      통과했지만 효율성테스트에서 통과하지 못함. 
     * 
     * 효율성 개선 방법 :
     *      
     */

    // 정렬 효율성 문제 1
    
    sort(phone_book.begin(), phone_book.end());


    // 이중 포문 효율성 문제 2
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