#
# @lc app=leetcode id=735 lang=python3
#
# [735] Asteroid Collision
#

# @lc code=start
from typing import List
class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:

        # stack to store the asteroids
        # Really same as before and very stupid question 

        #have to figure out how the asteroids will collide
        stack = []
        for a in asteroids:
            if not stack:
                stack.append(a)
            else: 
                while stack and stack[-1] > 0 and a < 0:
                    a1 = stack[-1]
                    a2 = -a 
                    if a1 == a2:
                        stack.pop()
                        break
                    elif a1 < a2:
                        stack.pop()
                    else:
                        break
                else:
                    stack.append(a)                                 
        return stack


        #todo programming technique to replace the uncommon while - else loop 
        # stk = []
        # for t in ats: # asteroids --> ats
        #     ok = True
        #     while ok and stk and stk[-1] > 0 and t < 0:
        #         a, b = stk[-1], -t
        #         if a <= b:
        #             stk.pop(-1)
        #         if a >= b:
        #             ok = False
        #     if ok:
        #         stk.append(t)
        # return stk
           
            
        
# @lc code=end

