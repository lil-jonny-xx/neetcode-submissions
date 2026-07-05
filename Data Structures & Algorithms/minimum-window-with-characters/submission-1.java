class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        int[] targetCounts = new int[128];
        int requiredUniqueChars = 0; 
        for (int i = 0; i < t.length(); i++) {
            if (targetCounts[t.charAt(i)] == 0) { 
                requiredUniqueChars++;
            }
            targetCounts[t.charAt(i)]++;
        }
        int[] windowCounts = new int[128];
        int formedUniqueChars = 0;

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int bestStartIndex = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowCounts[rightChar]++;
            if (targetCounts[rightChar] > 0 && windowCounts[rightChar] == targetCounts[rightChar]) {
                formedUniqueChars++;
            }
            while (formedUniqueChars == requiredUniqueChars) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    bestStartIndex = left;
                }
                
                char leftChar = s.charAt(left);
                windowCounts[leftChar]--;
                if (targetCounts[leftChar] > 0 && windowCounts[leftChar] < targetCounts[leftChar]) {
                    formedUniqueChars--;
                }

                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(bestStartIndex, bestStartIndex + minLength);
    }
}
