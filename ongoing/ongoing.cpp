#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

// https://programmers.co.kr/learn/courses/30/lessons/42577

int solution(vector<vector<string>> clothes);

void print_vector(vector<string> &v);

int main() {
    int answer;
    // [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]
    vector<vector<string>> clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

    answer = solution(clothes);

    std::cout << "answer :" << answer << std::endl;

    system("pause");
    return 0;
}

int solution(vector<vector<string>> clothes) {
    int answer = 0;
    
    /**
     *   방법 : 
     *      의상의 종류 당 한가지만 입을 수 있지만 의상의 종류가 다른 것들의 조합은 다양하게 입을 수 있다. 
     *      
     *      1. 각각의 의상의 종류들 마다 하나 씩 착용햇을 경우 
     * 
     *      2. 다른 의상의 종류들의 조합의 경우 
     * 
     *      3. 이를 총합을 구하여 리턴한다.
     * 
     */
    

    map<string, int> m; // 옷의 종류와 해당 옷의 종류의 개수를 위한 맵 변수

    for (size_t i = 0; i < clothes.size(); i++) {
        for (auto clo : clothes[i]) {
            m[clo] += 1;
        }
    }

    int sum = 0;

    for (size_t i = 0; i < m.size(); i++)
    {
        sum += m[i];
    }

    for (size_t i = 0; i < m.size(); i++)
    {
        sum += m[i]
        sdfadfs
    }
    

    sdfsdf
    return answer;
}


void print_vector(vector<string> &v) {
    std::cout << "------- vector print  " << std::endl; 
    for (auto str : v) {
        std::cout << str << std::endl;
    }
    std::cout << std::endl;
}






