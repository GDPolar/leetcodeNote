package Leetcode;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 *
 * https://leetcode.cn/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (51.68%)
 * Likes:    875
 * Dislikes: 0
 * Total Accepted:    386.6K
 * Total Submissions: 747.1K
 * Testcase Example:  '"the sky is blue"'
 *
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 * 
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // 方法一：利用双指针删除指定数组中指定元素的方法删除中间的冗余空格。反转整个字符串，再反转各个单词
        // 移除首尾的空白
        s = s.trim();
        char[] arr = s.toCharArray();
        // 删除冗余空格
        int slowIndex, fastIndex;
        for (slowIndex = 0, fastIndex = 0; fastIndex < arr.length; fastIndex++) {
            // 不删除当前元素的条件：当前元素为字母或当前元素为必要的空格
            if (arr[fastIndex] != ' ' || arr[fastIndex + 1] != ' ') { 
                arr[slowIndex++] = arr[fastIndex];
            }
        }
        int arrLength = slowIndex;
        // 反转整个字符串
        swap(arr, 0, slowIndex - 1);
        int i, j;
        for (i = 0, j = 0; i < arrLength; i++) {
            // 反转各个单词
            if (arr[i] == ' ') { 
                swap(arr, j, i - 1);
                j = i + 1;
            }
        }
        // 反转最后一个单词
        swap(arr, j, i - 1);
        return new String(arr).substring(0, arrLength);

        // 方法二：
        /*
        // 移除首尾的空白
        s = s.trim(); 
        StringBuilder sb = new StringBuilder();
        // j 记录待添加的单词的右边界
        int j = s.length(); 
        // i 表示待添加的单词的左边界
        for (int i = j - 1; i >= 0; i--) { 
            if (s.charAt(i) == ' ') {
                sb.append(s.substring(i + 1, j));
                // 消除中间的冗余空格
                while (i >= 0 && s.charAt(i) == ' ') { 
                    i--;
                }
                j = ++i;
                sb.append(' ');
            } 
        }
        // 注意收尾
        sb.append(s.substring(0, j)); 
        return sb.toString();
         */
    }
    
    // 左闭右闭反转char数组
    public void swap(char[] arr, int begin, int end) {
        char temp;
        for (int i = begin, j = end; i <= j; i++, j--) {
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

    public String reverseWords2(String s) {
        s = reverse(trim(s));
        // t 记录本次待翻转的字串的起始位置（含）
        int t = 0;
        // flag 表示是否刚进行过反转
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (flag == 0) {
                    sb.append(reverse(s.substring(t, i))).append(' ');
                    flag = 1;
                } 
                t = i + 1;
            } else {
                flag = 0;
            }
        }
        sb.append(reverse(s.substring(t, s.length())));
        return sb.toString();
    }

    public String reverse(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] cs = s.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char c = cs[i];
            cs[i] = cs[len - i - 1];
            cs[len - i - 1] = c;
        }
        return new String(cs);
    }

    public String trim(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        int j = s.length() - 1;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }
        return s.substring(i, j + 1);
    }
}
// @lc code=end

