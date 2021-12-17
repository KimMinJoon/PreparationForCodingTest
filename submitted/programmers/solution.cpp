#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;


// https://programmers.co.kr/learn/courses/30/lessons/42576

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";

/**
 * 방법 1 : 
 *      2중 for문을 사용하여 참가자와 완주자를 비교하여 배열에서 지워가는 방법을 생각함.
 * 문제점 : 
 *      1. 참가자를 모두 탐색해야한다는 단점이 있음.
 *      2. 마지막에 남은 배열의 이름을 리턴할 때 에러가 존재함.
 */
    // for (size_t i = 0; i < participant.size(); i++) {
    //     for (size_t j = 0; j < completion.size(); j++) {
    //         if (participant[i].compare(completion[j]) == 0) {
    //             participant[i].erase();
    //             continue;
    //         } 
    //     }
    // }


    /**
     * 방법 2 : 
     *      map을 활용하여 찾는다. 
     * 특징 : 
     *      1. 포문을 두번 돌아야한다. 
     */

    // map<string, int> m;


    // for (auto c : completion) {
    //     m[c] += 1;
    // }

    // for(auto p : participant) {
    //     m[p] -= 1;

    //     if (m[p] < 0) {
    //         return p;
    //     }
        
    // }
    


    /**
     * 방법 3 : 
     *      참가자와 완주자의 배열을 정렬하여 동일한 순서로 나열한다. 이후에 비교하며 다른경우 리턴하도록한다. 
     * 특징 : 
     *      1. 정렬을 둘다 해야한다. 
     *      2. 비교 탐색 시, 모두 탐색하지 않아도 된다. 
     */

    sort(completion.begin(), completion.end());
    sort(participant.begin(), participant.end());

    for (size_t i = 0; i < participant.size(); i++) {
        if(participant[i] != completion[i]) {
            return participant[i];
        }
    }
}