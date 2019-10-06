//1
int [][] twoDArray = {     
        {1,  2,  3,  4,  40},
        {5,  6,  7,  8,  50},
        {9,  10, 11, 12, 60},
        {13, 14, 15, 16, 70},
        {17, 18, 19, 20, 80},
        {21, 22, 23, 24, 90},
        {25, 26, 27, 28, 100},
        {29, 30, 31, 32, 110},
        {33, 34, 35, 36, 120}};

List list = new ArrayList();
for (int[] array : twoDArray) {
    //This will add int[] object into the list, and not the int values.
    list.add(Arrays.asList(array));
}
//2
int iLength = twoDArray.length;
List<List<Integer>> listOfLists = new ArrayList<>(iLength);
for (int i = 0; i < iLength; ++i) {
    int jLength = twoDArray[0].length;
    listOfLists.add(new ArrayList(jLength));
    for (int j = 0; j < jLength; ++j) {
      listOfLists.get(i).add(twoDArray[i][j]);
    }
}

