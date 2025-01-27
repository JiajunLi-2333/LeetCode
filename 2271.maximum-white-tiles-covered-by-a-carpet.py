#
# @lc app=leetcode id=2271 lang=python3
#
# [2271] Maximum White Tiles Covered by a Carpet
#

# @lc code=start
class Solution:
    def maximumWhiteTiles(self, tiles: list[list[int]], carpetLen: int) -> int:
        #Sort the tiles according to the beginning index of each tile
        tiles.sort(key=lambda x: x[0])
        right = ans = cover = 0
        n = len(tiles)
        for left in range(n):
            while right < n and tiles[right][1] < tiles[left][0] + carpetLen - 1:
                cover += tiles[right][1] - tiles[right][0] + 1
                right += 1
            if right < n and tiles[right][0] <= tiles[left][0] + carpetLen - 1:
                ans = max(ans, cover + tiles[left][0] + carpetLen - tiles[right][0])
            else:
                ans = max(ans, cover)
            cover -= tiles[left][1] - tiles[left][0] + 1
        return ans
# @lc code=end

