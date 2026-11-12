class RandomizedSet {
    List<Integer> numbers;
    HashMap<Integer, Integer> numMap;
    Random random;
    public RandomizedSet() {
        numbers = new ArrayList<>();
        numMap = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(numMap.containsKey(val)){
            return false;
        }
        numbers.add(val);
        numMap.put(val, numbers.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!numMap.containsKey(val)){
            return false;
        }

        int lastIndex = numbers.size()-1;
        int currentIndex = numMap.get(val);

        int number = numbers.get(lastIndex);

        numbers.set(currentIndex, number);

        numMap.put(number, currentIndex);

        numMap.remove(val);
        numbers.remove(lastIndex);

        return true;
    }
    
    public int getRandom() {
        int randomIdx = random.nextInt(numbers.size());
        return numbers.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */