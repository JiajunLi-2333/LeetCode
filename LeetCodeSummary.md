# *LeetCode Summary*

**Use h2 for each topics and line breaks to separate them**

**Use h3 for each question lines**

**Include the code for the question**

**Write out organized thinking process with proof and reasoning* **



## Iterate the right & Maintain the left

**利用数据结构来增加每一步的信息量 总而为之后的操作埋下伏笔, 这个伏笔需要等价关系和载体来记录**

**嵌套循环只能让答案每次增加1，但是这个技巧是让答案每次多个增加**

### 1. 两数之和

题目简述：在数组中找到两个和为target的数，并且返回两个数的index(顺序任意)

题目特质：有唯一答案

题目限制： 

`-10^9 <= nums[i] <= 10^9`

`-109 <= target <= 109`

`2 <= nums.length <= 104`

**解析：**

自然的可以想到，在已知一个数x的情况下，可以嵌套一个for loop找到target - x， 这样返回的结果就是外循环的index和内循环的index。这样既找到了和为target的两个数，也解决了下标问题。

```java
for(int i = 0; i < nums.length -1; i++){
    for(int j = i + 1; j < nums.length; j++){
          if(nums[i] + nums[j] == target){
                return new int[] {i, j};
           }
     }
}
return new int[] {};
```



**优化方案：**

前一种做法的弊端在于时间复杂度太高，几乎达到了O(n^2).  **造成这一结果的是我们每次都在从0开始找到符合要求的组合**

更好的办法是**利用各种数据结构或者设计技巧** 来帮我们记住遍历的内容，从而让我们可以利用已经处理过的内容来更快的找到答案。

首先，

`x + y = target`  等价于 `y = target - x`

具体的，对于每个数x，我们都可以求出满足条件所对应的数y。

利用哈希表的特点，我们可以在记录补足数的时候同时记录下对应的下标。

```java
 HashMap<Integer, Integer> map = new HashMap<>();
 for( int i = 0; i < nums.length; i++){
     int complement = target - nums[i];
     if(map.containsKey(complement))
         return new int[] {map.get(complement), i};
     map.put(nums[i], i);
 }
 return new int[] {0, 0};
```



### 2441. 对应负数同时存在的最大正整数

**题目简述**：找到正整数k，满足-k同时也存在于数组中

**题目特质:**  0 不存在于数组中

**题目限制：**

`1 <= nums.length <= 1000`

``-1000 <= nums[i] <= 1000`

`nums[i] != 0`

不需要运用哈希表，运用一个简单的set或者list来记录在当前index下，已经出现过的数，如果-nums[i]存在于set或者list当中，更新答案最大值。

```java
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        for(int num: nums){
            if (set.contains(-num)){
                ans = Math.max(ans, Math.abs(num));
            }
            set.add(num);
        }
        return ans;
```



### 2001. 可互换矩形的组数

**题目简述**: 找到数组中可互换矩形的对数，可互换矩形满足：

```text
width_i/height_i == width_j/height_j
```

**题目特质：** 很直白，没有什么特别需要主义的edge case

**题目限制：**也很直白

首先，怎样记录总共的个数？

假设当前矩形的长宽比为x，那么在数组中但凡再出现另外一个x，都可以组成一对。那么就出现了一个数学问题，假设有四个相同的x，两两组成一对且顺序不重要，能出现多少对？

答案显而易见的是4C2 = 6，这也正好对应了示例1的答案。

那么有一种做法自然就是可以利用哈希表记录一下每种长宽比出现的次数，然后相加总数。

```java
        Map<Double, Long> map = new HashMap<>();
        long ans = 0;
        for(int[] rec: rectangles){
            double ratio = (double) rec[0] / rec[1];
            map.put(ratio, map.getOrDefault(ratio, 0L) + 1);
        }
        for(long count: map.values()){
            if(count > 1){
                ans += count * (count - 1) / 2; // n choose 2
            }
        }
        return ans;
```

当然，4C2 这个过程也可以拆开，6 = 1 + 2 + 3

利用同样的哈希表，在单次循环中就可以累加起所有长宽比相容的矩形的个数，在遍历结束时找到正确答案。

### 121. 买股票的最佳时机

**题目简述**：在某一天买入股票，在未来的某有一天卖出，算取最大利润

**题目特质：**给定数组为乱序，并且不能改变数组顺序

**题目限制**：price >= 0

贪心的想，要获取最大利润，购入的价格应该尽可能的小，而卖出的价格应该是购入当天之后最大的，这样才能达到利益最大化。因此，单纯的记录数组的最大值和最小值是不对的，因为最大值可能出现在最小值的前面。

假设当前的值为x，我们需要知道在x之前的最小值是多少，那么就能在循环中不断更新答案，最后找到最大利润。

利用一个变量来记录index之前的最小值，用先更新答案再更新最小值的方式来确保正确的位置。



```java
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        for(int price : prices){
            min = Math.min(min, price);
            ans = Math.max(ans, price - min); 
        }
        return ans;
    }
}

```



### 1128.等价多米诺骨牌对的数量

**题目简述：**domino[i] = [a , b] 找到数组中其余[a,b] 或者 [b,a] 的对数

直观的，可以用一个hashmap记录每个数组出现的次数，在遍历的同时增加相同的对数，最后得出正确答案。但是哈希表不能以int[] 作为key，所以不能用哈希表作为记录。 

于是，利用`1 <= dominoes[i] <= 9` 这个特性， 可以用一个嵌套数组

```int[10][10]```来记录数组出现的次数。

```java
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[][] cnt = new int[10][10];
        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]); // 保证 a <= b
            ans += cnt[a][b]++;
        }
        return ans;
    }
}

```



### 2815.数组中最大的数对和

**简述：**在数组中找到所有数位上最大的数相同的两个元素称为对数，找到最大的对数和



首先要解决的问题是怎么找到每个数所有数位上最大的数？

最直观的方法是额外一个function，返回每个数的数位最大值。

根据题目，我们要找的是对数的最大值。假设现在有四个符合要求的数，那么我们怎么找到最大对数和呢？

答案就是用hashmap，key为最大值，定义value为当前最大值下，最大的数。

或者，这个最大值必然是大于0而小于10的，这并不难发现，我们也可以用一个长度为10的数组，将最大值直接对应为数组的下标，也可以得出结果

```java
class Solution {
    public int maxSum(int[] nums) {
        int ans = -1;
        int[] maxVal = new int[10];
        Arrays.fill(maxVal, Integer.MIN_VALUE); // 表示不存在最大值
        for (int v : nums) {
            int maxD = 0;
            for (int x = v; x > 0; x /= 10) {
                maxD = Math.max(maxD, x % 10);
            }
            ans = Math.max(ans, v + maxVal[maxD]);
            maxVal[maxD] = Math.max(maxVal[maxD], v);
        }
        return ans;
    }
}
```

### 1010. 总持续时间可以被60整除的数组

**问题简述：**找到times[i], times[j] such that (times[i] + times[j]) % 60 == 0;

对于任意一个数 x （可以不是10的倍数），我怎么得到另外一个正整数 y 使得 

```text
(x + y) % 60 = 0
```

那这就自然成了一个数学问题，并且不难发现，y就是 x % 60的余数

但是这样想显然是有问题的，因为比如说x = 160， 160 % 60 = 40，但这代表的并不是160 + 40 可以被 60 整除，它代表是160 - 40 可以被60 整除

同时，还需要解决一个问题，x = 160， y = 20，80 ..... 都可以满足和为60的倍数，如果他们同时出现在数组里，我们不能漏掉所有的选择。

那么对于x和y， 我们可以把它们写成如下的形式：

`x = a * 60 + b`

`y = m * 60 + n`

`x + y = (a + m) * 60 + (b + n)`

要使得x + y 是60的倍数，那么`b + n`也必须是60的倍数，由此，我们可以得出数学关系

`(60 - x mod 60) % 60 = n` 我们只要用哈希表记录n出现的次数就找到了所有符合要求的对数，相加即使答案

```java
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int t : time){
            int mod = t % 60;
            int comp = (60 - mod) % 60;//应对 t 本身就是60的倍数的情况
            ans += map.getOrDefault(comp, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
}
```

**关系是一步步找出来的，不是一下子能够想出来的**



### 2748. 美丽下标对的数目

**题目简述：**nums[i]的第一个数字和 nums[j]的最后一个数字互质， 且i < j 被认为是一组美丽下标对，找出总对数

那么这道题的难点有两个，第一个是怎么找到美丽下标对，第二个是怎么统计到总对数。

那对于美丽下标对来说，单独写一个获得first digit的function 和一个gcd function就可以解决。

更大的问题在于，对一个数x并且其个位数为y，数组中可能存在不止一个和y互质的数，根据前面的知识，统计这些数的个数是一个简单的工作，一个哈希表就可以解决，最重要的问题是怎么找到这些数呢？

以下两种方式提供了解决方案，因为非常的直观，所以不多做赘述

```java
import java.util.Arrays;
class Solution {
    public int countBeautifulPairs(int[] nums) {
        // nums[i] % 10 != 0;
        int ans = 0;
        int[] one_Coprime = {1,2,3,4,5,6,7,8,9};
        int[] two_Coprime = {1,3,5,7,9};
        int[] three_Coprime = {1,2,4,5,7,8};
        int[] four_Coprime = {1,3,5,7,9};
        int[] five_Coprime = {1,2,3,4,6,7,8,9};
        int[] six_Coprime = {1,5,7};
        int[] seven_Coprime = {1,2,3,4,5,6,8,9};
        int[] eight_Coprime = {1,3,5,7,9};
        int[] nine_Coprime = {1,2,4,5,7,8};
        int[][] coprime = {new int[0], one_Coprime, two_Coprime, three_Coprime, four_Coprime, five_Coprime, six_Coprime, seven_Coprime, eight_Coprime, nine_Coprime};
        int[] cnt = new int[10];
        Arrays.fill(cnt, 0);
        for(int num : nums){
            int lastDigit = num % 10;
            //last digit is garantueed to be non-zero already
            for(int i = 0; i < coprime[lastDigit].length; i++){
                ans += cnt[coprime[lastDigit][i]];
            }
            cnt[getFirstDigit(num)]++;
        }
        return ans;

    }
    private int getFirstDigit(int num){
        while (num >= 10) {
            num /= 10;
        }
        return num;

    }
}
```



```java
class Solution {
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        int[] cnt = new int[10];
        for (int x : nums) {
            for (int y = 1; y < 10; y++) {
                if (cnt[y] > 0 && gcd(y, x % 10) == 1) {
                    ans += cnt[y];
                }
            }
            while (x >= 10) {
                x /= 10;
            }
            cnt[x]++; // 统计最高位的出现次数
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

```



### 2874.有序三元组中的最大值II

**题目简述：** 对于一个三元组满足（i < j < k）， 定义三元组的值为

`（nums[i] - nums[j]）* nums[k]`

找出最大值，如果最大值小于0， 直接返回-1

**解析：**

直观的，如果用三个套嵌的for loop，我们可以解决这个问题，但是时间复杂度太高。所以要找更快的办法在一次遍历中解决。

从这个值的定义下手，我们要求的是最大值，那么就可以要求

`(nums[i] - nums[j])` 和`nums[k]` 都尽可能的大，在遍历j的过程中，nums[j] 的值是不受我们控制的，那么我们的问题就是如何找到j之前最大的数字nums[i] 和如何找到j之后最大的数字nums[k]

具体的，我们要找到在下标j之前的nums[i]最大值，也要找到下标j之后nums[k]的最大值。这样在遍历nums[j]的过程中，就可以不断更新最大值来找到答案。

在遍历j的过程中，我们可以顺带更新最大值作为nums[i]，在遍历之前，我们可以用一个数组记录在从右到左的顺序下的最大值作为nums[k]，这样就可以在一次遍历的情况下找到最大值。

```java
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] sufMax = new int[n + 1];
        for (int i = n - 1; i > 1; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], nums[i]);
        }

        long ans = 0;
        int preMax = nums[0];
        for (int j = 1; j < n - 1; j++) {
            ans = Math.max(ans, (long) (preMax - nums[j]) * sufMax[j + 1]);
            preMax = Math.max(preMax, nums[j]);
        }
        return ans;
    }
}
```

### 1031. 两个非重叠子数组的最大和

**题目简述：**两个长度为a和b的非重叠子数组，设sum(a) = x, sum(b) = y, 求x + y的最大值

从最大值这个角度去想，假设当前子数组的值为y，那么我需要知道前面所有非重叠子数组的最大和是多少，也就是说，x = max(a,b,c,d.....)， 这样在遍历y的过程中就能找到最大值。

这里要特别注意的有两点，第一是两个子数组需要非重叠，第二是两个子数组的长度不一样。关于第二点，会导致最大值是以下表达式：`ans = max(a then b, b then a)`所以两个子数组的出现顺序是可以不一样的。因此，在计算答案的时候，我们需要以不同的顺序两次遍历来确保找到最大值。

那么接下来就是解决非重叠的问题。以ba的顺序为例，设a的两端坐标是a_i, a_j， 我要知道a_i之前长度为b的数组和最大值。那可以在初始遍历的时候，就让b的两端坐标为b_i = 0, b_j = b - 1, a_i = b, a_j = b + a -1,这样在遍历过程中就可以不断地同时移动a和b来获得最大值

```java
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++)
            s[i + 1] = s[i] + nums[i]; // 计算 nums 的前缀和(属于是一点小小的优化)
        return Math.max(f(s, firstLen, secondLen), f(s, secondLen, firstLen));
    }

    private int f(int[] s, int firstLen, int secondLen) {
        int maxSumA = 0, res = 0;
        for (int i = firstLen + secondLen; i < s.length; ++i) {
            maxSumA = Math.max(maxSumA, s[i - secondLen] - s[i - secondLen - firstLen]);
            res = Math.max(res, maxSumA + s[i] - s[i - secondLen]);
        }
        return res;
    }
}
```

### 2555.两个线段获得的最多奖品

**题目简述：**线段上每个点都存在奖品，现有两个长度为k的线段，找出线段可以覆盖的礼物最大数

按照最大的这个思路去想，那么两个线段不重叠的情况下，能覆盖的礼物数量是最多的，那这个问题就直接转化成了两个非重叠子数组可以涵盖的最大奖品数。

那么假设我们枚举第二个线段，我需要知道在这个线段左边的第一条线段能获取的最大礼物数量是多少，这样在枚举的过程中就能顺利找到最大值

那自然就需要一个载体来记录第一条线段的最大值。

这里不能用一个简单的变量来储存最大值，而是要用一个数组。因为在遍历的过程中，第二条线段的左端不是每次都会变化的，从数轴对应到数组上，两个线段的长可能是不一样的。所以我们要用一个数组来记录状态，而不是用一个变量来单纯的记录数值。

```java
class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        if (k * 2 + 1 >= prizePositions[n - 1] - prizePositions[0]) {
            return n;
        }
        int ans = 0;
        int left = 0;
        int[] mx = new int[n + 1];
        for (int right = 0; right < n; right++) {
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }
            ans = Math.max(ans, mx[left] + right - left + 1);
            mx[right + 1] = Math.max(mx[right], right - left + 1);
        }
        return ans;
    }
}

```

### 1995.统计特殊四元组

**题目简述：**找到满足下标不同的数字，满足

`nums[a] + nums[b] + nums[c] == nums[d] `

因为限制：

`4 <= nums.length <= 50`

我们是可以用过用四个nested for loop来解决问题的。但是如果问题的长度变得很大，那4个for loop就有了很大的限制，必定超时

降低套嵌深度的办法就是记录更多的信息，

首先可以把原有的公式转换一下，得到一下的数学关系：

`nums[a] + nums[b] == nums[d] - nums[c]`

那么只要是找到nums[a] + nums[b] 的值，并且用hashmap记录下出现的次数，就可以在遍历nums[d] - nums[c] 的时候用O(1)的方式从哈希表中找到次数并且算出答案。现在我需要一个遍历的方式来确保我们不会漏掉任何答案。那么如果我们枚举的是b，假设b的位置是i

`b index = i`

`a index = 0 ~ i -1`

`c index = i + 1`

`d index = n -1 ~ c + 1`

你可以注意到c的位置其实只要是b + 1就足够用了，因为如果我们同时也枚举c的话，会出现很多重复的计算，也同时会重复增加答案，所以c的位置是不需要额外枚举的。

```java
class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        int[] cnt = new int[10010];
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) cnt[nums[d] - nums[b + 1] + 200]++;
            for (int a = 0; a < b; a++) ans += cnt[nums[a] + nums[b] + 200];
        }
        return ans;
    }
}
//答案在这里采用逆序
```

### 3404.统计特殊子序列的数目

**题目简述：**在数组中找到四个数，他们满足如下的数学关系

`nums[p] * nums[r] == nums[q] * nums[s]`

通俗的讲，就是第一个数于第三个数的积 等于第二个数和第四个数的积

p < q < r < s

**解析：**

如果是按照题目的意思，单纯的按照顺序进行匹配，那很容易就想到利用嵌套的for loop，但是不用多说，肯定是超时了。

如果我们采取枚举nums[p]的方法并且用哈希表保存p和r的乘积，也只能做到O(n^3)，因为p和r的乘积很难服务于之后的计算，我们还是要一个一个重新计算q和s的乘积，但是，如果把数学关系转换一下

`nums[p]/nums[q] = nums[s]/nums[r]`

那么如果我们枚举`nums[r]` ，可以同时充当nums[q]，直接省去重新计算一个

---

## Monotonic Stack

### 3113.边界元素是最大值的子数组数目

**题目简述：**在数组中找到子数组 满足子数组的第一个元素和最后一个元素是这个子数组中的最大值

**解析：**

我们先想一想如果是暴力做法该怎么做？

首先，怎么找到符合要求的子数组？

最简单的方式是用两个指针，假设左指针就是我们的左端点，那么此时就可以移动右端点。

在移动的过程中，我们怎么判断右端点是否应该向前？

题目的要求是子数组中左端点和右端点的值是最大的（他们也应该相等）。那么当右端点的值小于左端点，右端点就应该向前移动。而当右端点的值等于左端点我们找到了一个符合要求的子数组，这个应该非常的直观。

但是如果右端点的值>左端点怎么办？

那么右端点就会大于其之前所有的值，于是我们就应该更新左 = 右 然后继续向前



现在我们怎么保证不漏掉所有符合要求的子数组？

如果有数组 = 3 2 1 2 3

那么按照之前说的办法，我们能只能找到一个数组3 2 1 2 3, 但是其中的 212 也是一个符合要求的数组，所以，我们应该从头到尾遍历子数组，即数组上的每一个点都可以作为左端点来尝试。这样就不免把时间复杂度提高到了O(n^2)，妥妥的会超时间复杂度。



*优化：*

从刚才的思考中不难得出, 由于子数组的嵌套，时间复杂度直线飙升。那我们就可以尝试用栈来解决这种带有嵌套的问题，并且：

对于一个数x，如果在x后面存在一个数y > x, 那x是不可能和 后面任何一个数组成满足条件的子数组的，因为以x为左端点的子数组永远会包含一个比它更大的y。x只可能作为右端点存在。所以对于y之后的子数组寻找，x就成了无用条件，这里存在了单调性，可以使用单调栈。

特别要注意的是，子数组中如果存在数等于两个端点，这个数组也成立。所以如果我们假设right为右端点，左边所有值为right的数都可以作为左端点构成合法子数组。

那么单调栈的规则就是。一旦发现当前数 > 栈顶，我们就需要出栈直到当前的数小于等于栈顶。如果栈顶的数 == 当前的数，我们就找到了一个子数组。

```java
class Solution {
    public long numberOfSubarrays(int[] nums) {
        //! I think understand why monotonic stack is useful here but I forget to consider the case where the boundary elements may appear multiple times 

        int n = nums.length;
        long ans = n;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{Integer.MAX_VALUE, -1}); // dummy element to simplify 
        for(int i = 0; i < n; i++){
            int x = nums[i];
            while(!stack.isEmpty() && stack.peek()[0] < x){
                stack.pop();
            }
            if(x == stack.peek()[0]){
                ans += stack.peek()[1]++; // add the number of subarrays ending at i with boundary elements equal to x
                
            }
            else{
                stack.push(new int[]{x, 1});
            }
        }
        return ans;
    }
}
```

### 2866.美丽塔II

**题目简述：**首先这个题目真的很难读懂了。我决定直接说思路 真的不知道是哪个杂种想出来的这题

**解析：**

首先还是想一想暴力做法，如果按照最高的思路去做：

要找到hei的最高值，我们肯定希望height的最高值尽量大并且左右递减的程度越来越小，但是这种想法不是很现实，heights上的每一个值都受限于max，所以只能遍历max来找到这个最大值。

那自然的对于每个max[i]，我们可以假设它就是hei[i]的最高值。接下来就是分别向做左边和右边进行一个递减扩展的操作。

那么就用向右扩展作为例子，假设最高值为x，位置是i。

- 如果i + 1 的值a > x, 那么hei[i + 1] == x min(a, x) = x
- 如果i + 1 的值a < x, hei[i + 1] == a min(a,x) = a

依次类推就可以达到递减的效果。

那么这样的时间复杂度就成了O(n^3) 铁定超时

*优化：*

**重点：**依旧是从最大值的角度出发，不过这次最大值的计算方式不一样。按照之前的思路，我们会产生n个heights（可能大家的值都不一样），但是其中只有一个是最大的，那么对于那个最大值的height，我们是否可以假设它的左边递减数段是所有左边递减数段中最大的，右边递减数段也是所有右边递减数段中最大的？也就说最优解是否可以拆分为多个局部最优解的和？（其实就是贪心）

假设max, max(left), is right == max(right) ?那这里不能直接得出的



*请结合代码来理解以下局部最大达到结果的最大的方法*

在从左往右遍历数组的时候，我们是可以算出，从max[0] ~ max[i]作为左侧递增段的最大元素和是多少的。

那么我就只需要知道在i是 ，右侧递减数组的最大元素和是多少，在遍历数组完成之后就可以直接得出答案，即ans = pre[i] + suf[i + 1]的最大值

那这里就又用到了前缀的思想，通过提前记忆的方式来增加信息量。



那么如何计算pre和suffix呢？

这里以计算suffix为例：

假设max[i] 的值为x， 如果i的左边i-1的值a小于x，那么在i的位置也取不到x，只能取到a，这就意味着最大和只跟最新的值有关，其余的数都变成了无用信息。那就可以用到单调栈来解决。

- 如果 max[i] 大于栈顶的元素值，那么直接把 max[i] 加到 sum 中，同时把 i 入栈（栈中只需要保存下标）。
- 否则，只要 max[i] 小于等于栈顶元素值，就不断循环，把之前加到 sum 的撤销掉。循环结束后，从 max[i] 到 max[j−1]（假设现在栈顶下标是 j）都必须是 max[i]，把 max[i]⋅(j−i) 加到 sum 中。

```java
import java.util.Stack;
// @lc code=start
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        //convert list to array for easier manipulation
        int[] maxH = maxHeights.stream().mapToInt(i -> i).toArray();
        int n = maxH.length;
        long sum = 0;

        //Define suffix as the max sum of heights from i to n -1
        long[] suffix = new long[n + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(n);//！精彩小优化
        //! need monotonic stack to calculate the max sum of heights as suffix
        for(int i = n -1; i >= 0; i--){
            int x = maxH[i];
            while(stack.size() > 1 && maxH[stack.peek()] >= x){
                int j = stack.pop();
                sum -= (long) maxH[j] * (stack.peek() - j);
            }
            sum += (long) x * (stack.peek() - i);
            suffix[i] = sum;
            stack.push(i);
        }

        long ans = sum;
        stack.clear();
        stack.push(-1);
        sum = 0;
        for(int i = 0; i < n; i++){
            int x = maxH[i];
            while(stack.size() > 1 && maxH[stack.peek()] >= x){
                int j = stack.pop();
                sum -= (long) maxH[j] * (j - stack.peek());
            }
            sum += (long) x * (i - stack.peek());
            ans = Math.max(ans, sum + suffix[i + 1]);
            stack.push(i);
        }

        return ans;
    }
}
```

---

## Heap aka Priority Queue

### 2530.执行k次操作之后的最大分数

题目简述： 一个数组nums，一个总分数score和一个操作总次数k，对于每一次操作，可以在nums中选一个数 score += nums[i]然后将这个数变为ceil(nums/3)， 要求返回k次操作之后最大的score分数

题目限制：

`1 <= nums[i] <= 109`

`1 <= nums.length, k <= 105`

首先，这个score的计算方式就是简单的数值相加，如果要求最大，那每一次操作都应该加上数组中现存最大的数。

于是，一个最基本的做法是每次都给数组降序做排序，然后直接选取nums[0]加入score，再把处理后的值重新加入数组

那么这个方法显然就有很大的时间复杂度，接下来就是想怎么优化

设a = nums[i], 处理过的数为b = a / 3， 数组为nums：



**二分排序 节省时间**

首先是对nums进行最初的排序，那么在我们得到b之后，可以用二分在简化时间复杂度， 这样时间复杂度就成了O(k log(n) ) 对比之前的O(kn) 就快了很多

**数学特质 节省时间**

我们其实每次都只关心数组中最大的数，所有一样可以先对数组进行一个排序的操作，那么我们就得到了score的第一个值nums[n-1]。

设nums[n -1] = a, ceil(a/3) = b

现在就出现了两种情况， 

1. b任然是数组中的最大数，那下一次就是score还是加上b
2. b不再是数组中的最大数，此时的最大数一定是nums[n-2], 那score的下一个数就必定是nums[n-2]

数组中所有nums[i] >= b 的数都直接是score下次要累加的数，因此可以视数组情况勉强跳过几次数组排序。

```java
    public long maxKelements(int[] nums, int k) {
        long s = 0;
        int count = 0, n = nums.length;
        while (count < k) {
            Arrays.sort(nums);
            int i = n - 1, min = (nums[n - 1] + 2) / 3;
            while (i >= 0 && count < k && nums[i] >= min) {
                s += nums[i--];
                count++;
            }
            if (count == k) break;
            while (++i < n) nums[i] = (nums[i] + 2) / 3; 因为
        }
        return s;
    }
}
```

**优先队列heap **

这道题最大的特点是我们每次都要最大值，恰巧完全符合heap 最大堆的性质，每次的root都是最大值，所以这道题简直就是堆的完美应用，我们可以直接用堆 减少心智负担来解题

**堆：堆可以循环给出数组的最值，来达到O(1)的空间复杂度**



### 2462. Total Cost to Hire K Workers

题目简述：costs是一个含有每个worker费用的数组，我们一共可以从数组中挑选k次，每次， 我都只能关注最前candidates 个工人和最后candidates个工人并且从中挑选一个工人。求招工人的总共最小费用。

题目限制：

`1 <= costs.length <= 105 `

`1 <= costs[i] <= 105`

`1 <= k, candidates <= costs.length`

首先，要求最小, 那我必须每次都拿的是前后两个group里面费用最少的那一个数。

于是问题就变成了我怎么每次都拿到两个group中最小的数min(min(group_1), min(group_2)？ 

那么最直接的解法可以是这样的，对于每一次选取，我们遍历前后两个group来拿到最小值，既然每个工人只能雇佣一次，选中的工人就直接排出数组。但是这么做的时间复杂度也是不言而喻的，两次遍历就需要O(candidates), 再加上一出元素需要O(n) 每一次的时间复杂度就是O(candidates + n) 那就是O(n)， k次就是O(kn)，在最坏的情况下可以达到O(n^2) 

那么接下来就是要用到优化， 既然前后两个group我每一次要的都是他们的最小值， 那我自然是可以用最小堆来解决，在引入了最小堆之后， 每一次选取我都可以维护前后两个group的最小值来方便比较，同时，我也不需要再考虑改变costs数组的问题，只要操作两个最小堆就可以模拟出删除元素的效果。这样一来，时间复杂度就变成了O(log(candidates)). 

**接下来就需要对题目有一定的观察能力**

数组的长度是n， 两个group的长度是candidates * 2， 再加上k次每次会占据一个位置
在candidates * 2 + k > n 的情况下，costs数组里面的每一个数我们都会放在考虑范围内， 所以答案就是costs数组从小到大排列之后的前k个数。
在candidates * 2 + k < n 的情况下，costs数组里面在k次选取之后是还有富裕的， 那就需要按照题目的意思进行模拟。

```java
import java.util.Arrays;
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        //This question can be solved using two min-heaps
        int n = costs.length;
        PriorityQueue<Integer> front = new PriorityQueue<>();
        PriorityQueue<Integer> back = new PriorityQueue<>();
        long ans = 0;
        //! Important Edge Case
        if(candidates * 2 + k > n){
            Arrays.sort(costs);
            for(int i = 0; i < k; i++){
                ans += costs[i];
            }
            return ans;
        }

        //populate the heaps with candidates
        for(int i = 0; i < candidates; i++){
            front.offer(costs[i]);
            back.offer(costs[n-1-i]);
        }

        int frontIndex = candidates;
        int backIndex = n - candidates - 1;
        while(k-- > 0){
            if(front.peek() <= back.peek()){
                ans += front.poll();
                front.offer(costs[frontIndex++]);
            }
            else{
                ans += back.poll();
                back.offer(costs[backIndex--]);
            }
        }
        return ans;



        
    }
}
```



### 1834 Single-Threaded-CPU

题目简述：一个2D数组tasks中有n的要交给CPU处理的任务， 每个tasks[i] 里面记录了[enqueue time, processing time] . CPU每次只能执行一个任务并且这个任务是所有待办任务中需要的处理时间最短的。

题目限制：

`tasks.length == n`

`1 <= n <= 105`

`1 <= enqueueTimei, processingTimei <= 109`

首先， 这种题目最重要的就是要读懂题目， 这里最重要的就是搞清楚，代办的任务是哪些以及CPU到底选择哪个任务。

比如说在time = i的时候， tasks中enqueue = i的任务有三个， 那么CPU就应该选择processing time最短的那个任务进行，假设最短的processing time是j，那么CPU就将在time = i + j 的时候，能够选择下一个任务， 需要注意的是，在time = i， i + 1，i + 2， i + 3, ... , i + j 的时候enqueue的任务都可以成为代办任务，在CPU有空之后，会在这些任务中选取一个processing time最小的来进行处理。这里不难发现，在每个时间点，我们需要知道有哪些待办任务，和待办任务中processing time最小的任务是哪个，这里就需要维护最小值，可以用堆。 当然，除了堆也可以用一个数组来记录，采用排序和二分排序的方式来记录最小值，但是这样的时间复杂度高，代码实现也很困难， 属于是吃力不讨好， 用堆来实现是最好的。

**堆和排序+二分查找是有一定互通性的 但是堆的时间复杂度更低**

那么具体的逻辑实现是怎样的呢？

首先，pq就需要是一个二元组，既要包含processing time也要包含任务的id，因为弹出的最小值就是下一步CPU会执行的任务。 

```java
PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1]; // if processing time is same, sort by original index
            }
            return a[0] - b[0]; // sort by processing time
        });
```

其次， 对于原数组需要进行排序工作，因为题目对enqueue time是有从小到大的需求的。

```java
        int n = tasks.length;
        int[][] indexedTasks = new int[n][3];
        for(int i = 0; i < n; i++){
            indexedTasks[i][0] = tasks[i][0]; // enqueue time
            indexedTasks[i][1] = tasks[i][1]; // processing time
            indexedTasks[i][2] = i; // original index
        }

        //Sort tasks by enqueue time
        Arrays.sort(indexedTasks, (a, b) -> a[0] - b[0]);
```

最后，对于每一次遍历，假设当前的时间是time，需要把enqueue time < time的所有任务都放到堆中，把当前CPU处理的任务的id放到答案并且更新time代表CPU可以执行下一次任务的时间。

```java
    while(i < n){
            while(j < n && indexedTasks[j][0] <= time){
                pq.offer(new int[]{indexedTasks[j][1], indexedTasks[j][2]});
                j++;
            }
            if(pq.isEmpty()){
                time = indexedTasks[j][0];
            }else{
                int[] curr = pq.poll();
                ans[i++] = curr[1];
                time += curr[0];
            }
        }
```

整体代码如下：

```java
/*
 * @lc app=leetcode id=1834 lang=java
 *
 * [1834] Single-Threaded CPU
 */
import java.util.PriorityQueue;
import java.util.Arrays;
// @lc code=start
class Solution {
    public int[] getOrder(int[][] tasks) {
        //use priority queue to schedule tasks and simulate the CPU processing
        int n = tasks.length;
        int[][] indexedTasks = new int[n][3];
        for(int i = 0; i < n; i++){
            indexedTasks[i][0] = tasks[i][0]; // enqueue time
            indexedTasks[i][1] = tasks[i][1]; // processing time
            indexedTasks[i][2] = i; // original index
        }

        //Sort tasks by enqueue time
        Arrays.sort(indexedTasks, (a, b) -> a[0] - b[0]);
        //Store processing time and original index in a priority queue
        //store accroding to the processing time, if processing time is same, then store according to the original index  Min-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1]; // if processing time is same, sort by original index
            }
            return a[0] - b[0]; // sort by processing time
        });

        int[] ans = new int[n];
        int time = indexedTasks[0][0]; // start time
        
        int i = 0, j = 0;

        //! very important logic loop here
        while(i < n){
            while(j < n && indexedTasks[j][0] <= time){
                pq.offer(new int[]{indexedTasks[j][1], indexedTasks[j][2]});
                j++;
            }
            if(pq.isEmpty()){
                time = indexedTasks[j][0];
            }else{
                int[] curr = pq.poll();
                ans[i++] = curr[1];
                time += curr[0];
            }
        }

        return ans;
    }
}
```
### 1792.最大平均通过率

题目简述： 有一个2D数组classes, classes[i] = {pass, total} total代表着班上所有学生的人数， pass代表班上能通过考试的学生人数。 现在有一个整数extraStudents代表这可以通过考试的学生数量。把每一个extraStudents都分配到班上去， 求怎么分配能让所有班级的平均通过率最大。

题目限制：

- `1 <= classes.length <= 105`
- `classes[i].length == 2`
- `1 <= passi <= totali <= 105`
- `1 <= extraStudents <= 105`

首先不管最大的通过率，这个通过率是怎么计算的呢？
设x y z  分别为三个班级的平均通过率，那么所有班级的平均通过率就是
$$
\frac{x + y + z}{3} = a
$$

$$
\frac{x}{3} + \frac{y}{3} + \frac{z}{3} = a
$$

那么现在要让a最大化， 显然就是要知道x y z哪个加一带来的增幅最大。 换成数学公式就是

设 x = a/b，再加上一个学生之后， x' = (a + 1) / (b +1), x’ - x最大的那个班级就应该是extraStudents应该去的那个班级。

这个问题就变成了要维护每次分配学生之后，平均通过率最大的那个班级。由于每次我们都是要的最大值，可以用一个最大堆来进行动态维护。  

```java
/*
 * @lc app=leetcode id=1792 lang=java
 *
 * [1792] Maximum Average Pass Ratio
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    /**
     * @param classes
     * @param extraStudents
     * @return
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // The key is about the maximum increase in average pass ratio by adding one student to the class
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double diffA = increaseAmount(a);
            double diffB = increaseAmount(b);
            return Double.compare(diffB, diffA);
        });
        for(int[] cls : classes){
            pq.offer(cls);
        }
        while(extraStudents-- > 0){
            int[] cls = pq.poll();
            cls[0]++; 
            cls[1]++; 
            pq.offer(cls); 
        }
        double ans = 0;
        while(!pq.isEmpty()){
            int[] cls = pq.poll();
            ans += (double) cls[0] / cls[1]; 
        }
        return ans / classes.length; 
    }
    private double increaseAmount(int[] cls){
        int x = cls[0];
        int y = cls[1];
        return (double) (x + 1) / (y + 1) - (double) x / y;
    }
}
```

### 2931. 购买物品的最大开销

题目观察：

首先这个开销的算法非常的直接， 就是 price * d. 其中要注意的是d是单调递增的。 公式可以这样表达
$$
\text{sum} \;=\; a_{1}\cdot 1 \;+\; a_{2}\cdot 2 \;+\; a_{3}\cdot 3 \;+\; \cdots \;+\; a_{d}\cdot d
$$
那么自然就有一个问题是我怎么选择才能使sum最大？

如果说我每次都拿rightmost最大的数， 那么很有可能会先消耗掉一行再接着拿，这样会导致大的数目过早的跟数值较小的d相乘导致并不能最大化。所以应该先把最小的那个数拿了，让较大的值和较大的d相乘才能最大化sum



**即，当两个序列同向排序时，点乘和最大**

非严格证明：

## 交换法（Swap Argument）证明

我们要最大化加权和
$$
S \;=\;\sum_{i=1}^d a_i \, i,
$$
其中权重序列 \(1,2,\dots,d\) 是严格递增的。

### 1. 假设存在逆序对  

假设在某个最优排列中，存在一对下标 \(p<q\)，却有  
$$
a_p > a_q
$$

则称 \((p,q)\) 为“逆序对”。

### 2. 交换前后的局部和  

- **交换前**（原排列中）：
  $$
  S_{\text{old}}
  = a_p \cdot p \;+\; a_q \cdot q.
  $$

- **交换后**（将 \(a_p\) 与 \(a_q\) 互换位置）：
  $$
  S_{\text{new}}
  = a_q \cdot p \;+\; a_p \cdot q.
  $$

### 3. 增量计算  

$$
\Delta \;=\; S_{\text{new}} - S_{\text{old}}
\;=\;(a_q\,p + a_p\,q)\;-\;(a_p\,p + a_q\,q)
\;=\;(a_p - a_q)\,(q - p)
\;>\;0.
$$


也就是说，这次交换**必定**使总和严格增大。

### 4. 消除所有逆序对  

对任意逆序对重复上述交换操作，每次都能提升 \(S\)。  
有限次交换后，必能消灭所有逆序对，剩下的排列满足
$$
a_1 \le a_2 \le \cdots \le a_d.
$$
所以，每一次取能取到的最小值，就能保证最后的sum是最大的。

那么用暴力的做法，我们可以每次都遍历每一行rightmost中的最小值然后把它从values[i] 中拿走， 但是这样的时间复杂度就太高了。

*优化：*

可以观察到我们要关注的就是rightmost最小值， 因为每一行本身就是从大到小排列的，所以我们每次取得就是m * n个数中的最小值。所以我们可以直接用一个priority queue把所有值进行排序然后每次都pop 最小的值

```java
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    public long maxSpending(int[][] values) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int[] value: values){
        //     for(int v: value){
        //         pq.offer(v);
        //     }
        // }
        // long days = values.length * values[0].length;
        // long ans = 0;
        // for(long i = 0; i < days; i++){
        //     ans += pq.poll() * (i + 1);
        // }
        // return ans;

        //! This ensures the logic of always taking the rightmost element but it is unnecessary because the arrays are sorted already in descending order.
        int m = values.length;
        int n = values[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> values[a[0]][a[1]] - values[b[0]][b[1]]);
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, n - 1});
        }

        long ans = 0;
        for (int d = 1; d <= m * n; d++) {
            int[] p = pq.poll();
            int i = p[0];
            int j = p[1];
            ans += (long) values[i][j] * d;
            if (j > 0) {
                pq.offer(new int[]{i, j - 1});
            }
        }
        return ans;
        
        //Alternative Method by using just a num array 
        int[] allValues = new int[values.length * values[0].length];
        int index = 0;
        for (int[] row : values) {
            for (int v : row) {
                allValues[index++] = v;
            }
        }
        Arrays.sort(allValues);
        long ans = 0;
        for (int d = 1; d <= allValues.length; d++) {
            ans += (long) allValues[d - 1] * d;
        }
        return ans;
    }
}
```


