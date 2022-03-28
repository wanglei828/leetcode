/*

Given a list accounts, each element accounts[i] is a list of strings, 
where the first element accounts[i][0] is a name, 
and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. 
Two accounts definitely belong to the same person if there is some email that is common to both accounts. 
Note that even if two accounts have the same name, they may belong to different people as people could have the same name. 
A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: 
the first element of each account is the name, and the rest of the elements are emails in sorted order. 
The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].

*/

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> roots = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        for(List<String> account: accounts) {
            String user = account.get(0);
            for(int i=1; i<account.size(); i++) {
                roots.put(account.get(i), account.get(i));
                owner.put(account.get(i), user);
            }
        }
        
        for(List<String> account: accounts) {
            String root = findRoot(roots, account.get(1));
            for(int i=1; i<account.size(); i++) {
                roots.put(findRoot(roots, account.get(i)), root);
            }
        }
        
        Map<String, Set<String>> emails = new HashMap<>();
        for(String cur: roots.keySet()) {
            String root = findRoot(roots, cur);
            if(!emails.containsKey(root)) {
                emails.put(root, new HashSet<String>());
            }
            emails.get(root).add(cur);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(String email: emails.keySet()) {
            List<String> list = new ArrayList<>();
            for(String str: emails.get(email)) {
                list.add(str);
            }
            Collections.sort(list);
            list.add(0, owner.get(email));
            res.add(list);
        }
        return res;
    }
    
    private String findRoot(Map<String, String> roots, String root) {
        while(!roots.get(root).equals(root)) {
            root = roots.get(roots.get(root));
        }
        return root;
    }
}
