public class Experiment {

    Sorter sorter = new Sorter();
    Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {

        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(arr);
        } else {
            sorter.advancedSort(arr);
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {

        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();

        return end - start;
    }

    public void runAllExperiments() {

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {

            System.out.println("=== SIZE: " + size + " ===");

            // RANDOM ARRAY
            int[] randomArr = sorter.generateRandomArray(size);

            long bubbleTime = measureSortTime(randomArr.clone(), "basic");
            long quickTime = measureSortTime(randomArr.clone(), "advanced");

            sorter.advancedSort(randomArr); // сортируем для binary search
            long searchTime = measureSearchTime(randomArr, randomArr[size / 2]);

            System.out.println("Random Array:");
            System.out.println("Bubble Sort Time: " + bubbleTime);
            System.out.println("Quick Sort Time: " + quickTime);
            System.out.println("Binary Search Time: " + searchTime);
            int[] sortedArr = sorter.generateSortedArray(size);

            long bubbleSorted = measureSortTime(sortedArr.clone(), "basic");
            long quickSorted = measureSortTime(sortedArr.clone(), "advanced");

            long searchSorted = measureSearchTime(sortedArr, sortedArr[size / 2]);

            System.out.println("Sorted Array:");
            System.out.println("Bubble Sort Time: " + bubbleSorted);
            System.out.println("Quick Sort Time: " + quickSorted);
            System.out.println("Binary Search Time: " + searchSorted);

            System.out.println("-----------------------------");
        }
    }
}
