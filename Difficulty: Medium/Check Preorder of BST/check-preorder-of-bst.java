class Solution {
    public boolean canRepresentBST(List<Integer> arr) {

        Stack<Integer> stack = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;

        for (int num : arr) {

            if (num < lowerBound)
                return false;

            while (!stack.isEmpty() && num > stack.peek()) {
                lowerBound = stack.pop();
            }

            stack.push(num);
        }

        return true;
    }
}