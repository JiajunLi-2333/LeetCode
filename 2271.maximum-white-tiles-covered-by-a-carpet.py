#
# @lc app=leetcode id=2271 lang=python3
#
# [2271] Maximum White Tiles Covered by a Carpet
#

# @lc code=start
class Solution:
    def maximumWhiteTiles(self, tiles: list[list[int]], carpetLen: int) -> int:
        tiles.sort()
        tiles_len = tiles[-1][-1] - tiles[0][0] + 1
        tiles_arr = [0] * tiles_len
        num_black = 0
        num_white = 0
        left = 0
        max_white = 0
        for i in range(len(tiles)-1):
            begin = tiles[i][-1]
            end = tiles[i + 1][0]
            for j in range(begin, end):
                tiles_arr[j] = 1
        for i in range(len(tiles_arr)):
            if tiles_arr[i] == 0:
                num_white += 1
            else:
                num_black += 1
            if num_white + num_black > carpetLen:
                if tiles_arr[left] == 0:
                    num_white -= 1
                else:
                    num_black -= 1
                left += 1
            max_white = max(max_white, num_white)
        return max_white + 1 
            


        
        
# @lc code=end

