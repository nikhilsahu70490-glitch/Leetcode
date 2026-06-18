class Solution {
    public List<Integer> getRow(int rowIndex) {
        // Initialize the list with 1 followed by 0s
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        row.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0); // expand the row size by 1 dynamically
            
            // Traverse backwards to update elements in-place
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        
        return row;
    }
}