#
# @lc app=leetcode id=844 lang=python3
#
# [844] Backspace String Compare
#

# @lc code=start
class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        list_s = []
        list_t = []
        for i in s:
            if i != '#':
                list_s.append(i)
            else:
                if list_s:
                    list_s.pop()
        for j in t:
            if j != '#':
                list_t.append(j)
            else:
                if list_t:
                    list_t.pop()
        return list_s == list_t

        
# @lc code=end

