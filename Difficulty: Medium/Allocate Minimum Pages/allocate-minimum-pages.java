class Solution {

    public boolean canAllocate(int[] arr, long pages, int m) {

        int studentsUsed = 1;
        long pagesAllocated = 0;

        for (int book : arr) {

            if (pagesAllocated + book > pages) {
                studentsUsed++;
                pagesAllocated = book;
            } else {
                pagesAllocated += book;
            }
        }

        return studentsUsed <= m;
    }

    public int findPages(int[] arr, int m) {

        int n = arr.length;

        if (m > n) {
            return -1;
        }

        long low = 0;
        long high = 0;

        for (int book : arr) {
            low = Math.max(low, (long) book);
            high += book;
        }

        long ans = -1;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canAllocate(arr, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }
}