#
# @lc app=leetcode id=3170 lang=python3
#
# [3170] Lexicographically Minimum String After Removing Stars
#

# @lc code=start
from itertools import chain
from sortedcontainers import SortedDict
class Solution:
    def clearStars(self, s: str) -> str:
        #track the smallest non star character on the left of the 
        mp = SortedDict()  

        #Record the index of elements to be deleted
        st = set()
        
        for i, c in enumerate(s):
            if c == '*':
                key, indices = mp.peekitem(0)
                st.add(indices.pop())
                if not indices:
                    del mp[key]
            else:
                if c not in mp:
                    mp[c] = []
                mp[c].append(i)
        ans_chars = [c for i, c in enumerate(s) if i not in st and c != '*']
        return ''.join(ans_chars)

        #todo use 26 stacks to store the index of each of the characters
        # stacks = [[] for _ in range(26)]
        # for i, c in enumerate(s):
        #     if c != '*':
        #         stacks[ord(c) - ord('a')].append(i)
        #         continue
        #     for stack in stacks:
        #         if stack:
        #             stack.pop()
        #             break
        # return ''.join(s[i] for i in sorted(chain.from_iterable(stacks)))
# @lc code=end

