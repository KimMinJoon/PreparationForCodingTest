
#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    
    /**
     * 방법 : 전화번호의 길이가 짧은 원소로 포함된 문자열이 있는지 탐색하고 있으면 false를 반환하도록한다. 
     *      1. 정렬하여 길이가 짧은 순으로 나열한다. 
     *      2. 자기 자신부터 뒤의 원소들만과 문자열이 포함되었는확인한다. 
     * 
     *
     */
    map<string, int> m;

    sort(phone_book.begin(), phone_book.end());
    
    for (auto pb : phone_book) {
        // m[pb] += pb.length();

    }

    for (int i = 0; i < phone_book.size(); i++) {
        for (auto ph : phone_book) {
            if (phone_book[i].compare(ph) < 0) {
                return true;
            }
        }
        
    }


    
    
    
    return answer;
}