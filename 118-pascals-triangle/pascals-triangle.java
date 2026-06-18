class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        // Base case: if numRows is 0, return an empty list
        if (numRows == 0) {
            return triangle;
        }
        
        // First row is always [1]
        List<String> firstRow = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currRow = new ArrayList<>();
            
            // The first element of every row is always 1
            currRow.add(1);
            
            // Each triangle element is equal to the sum of the elements
            // directly above it in the previous row
            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            // The last element of every row is always 1
            currRow.add(1);
            
            triangle.add(currRow);
        }
        
        return triangle;
    }
}