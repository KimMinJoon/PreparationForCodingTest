#include <iostream>
#include <vector>
#include <string>

using namespace std;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 * 
 **/

string solution(vector<string> participant, vector<string> completion);

int main() {

    string answer = "";
    // 1. ["leo", "kiki", "eden"], ["eden", "kiki"]
    // 2. ["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]
    vector<string> participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
    vector<string> completion= {"josipa", "filipa", "marina", "nikola"};

    answer.assign(solution(participant, completion));

    std::cout << "answer :" << answer << endl;

    system("pause");
    return 0;
}

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";

    vector<string> temp = participant;

    for (size_t i = 0; i < participant.size(); i++)
    {
        for (size_t j = 0; j < completion.size(); j++)
        {
            if (participant[i].compare(completion[j]) == 0) {
                std::cout << "participant :" << participant[i] << ", "<< "completion : "<<  completion[j] << endl;
                
                // std::cout << "temp.begin()+i  :: " << temp.begin() << std::endl;
                temp.erase(temp.begin() + i);
                continue;
            }
        }
    }
    
    for (size_t i = 0; i < temp.size(); i++)
    {
        std::cout << "participant : " << temp[i]   << std::endl;
    }
    
    // participant.resize(1);
    // answer.assign(participant[0]);

    
    return answer;
}

