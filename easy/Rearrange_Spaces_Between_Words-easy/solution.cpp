class Solution {
public:
    string reorderSpaces(string text) {
        stringstream ss(text);
        vector<string> words;
        string word;
        while (ss >> word) {
            words.push_back(word);
        }
        int cnt = 0;
        if (words.size() == 1) {
            cnt = text.length() - words[0].length();
            string res = "";
            res += words[0];
            for (int i = 0; i < cnt; i++) {
                res.append(" ");
            }
            return res;
        }
        for (string word : words) {
            cnt += word.length();
        }
        cnt = text.length() - cnt;
        string res = "";
        int inspace = cnt / (words.size() - 1);
        int extra = cnt % (words.size() - 1);
        for (int i = 0; i < words.size(); i++) {
            res.append(words[i]);
            if (i != words.size() - 1) {
                for (int j = 0; j < inspace; j++) {
                    res.append(" ");
                }
            }
        }
        for (int j = 0; j < extra; j++) {
            res.append(" ");
        }
        return res;
    }
};
