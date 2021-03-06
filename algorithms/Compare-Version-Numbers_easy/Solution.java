/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1 == null && version2 != null) {
            return -1;
        } else if (version1 != null && version2 == null) {
            return 1;
        } else if (version1 == null && version2 == null) {
            return 0;
        }
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int len = Math.min(str1.length, str2.length);
        for(int i = 0; i < len; i++) {
            int v1 = Integer.valueOf(str1[i]);
            int v2 = Integer.valueOf(str2[i]);
            if ( v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }
        for(int i = len; i < str1.length; i++) {
            if(Integer.valueOf(str1[i]) != 0) {
                return 1;
            }
        }
        for(int i = len; i < str2.length; i++) {
            if(Integer.valueOf(str2[i]) != 0) {
                return -1;
            }
        }
        return 0;

    }
}
