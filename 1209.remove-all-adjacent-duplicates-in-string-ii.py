#
# @lc app=leetcode id=1209 lang=python3
#
# [1209] Remove All Adjacent Duplicates in String II
#

# @lc code=start
class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        #Constraint: 2 <= k <= 10000

        #Approach: use stack of stack to keep track of the number of adjacent duplicates
        #Time complexity: O(n)
        #Space complexity: O(n)
        stack = []
        for c in s:
            if stack and stack[-1][0] == c:
                stack[-1][1] += 1
                if stack[-1][1] == k:
                    stack.pop()
            else:
                stack.append([c,1])
        return ''.join([c * k for c,k in stack])


        
# @lc code=end

