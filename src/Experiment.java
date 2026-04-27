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
        searcher.binarySearch(arr, target);
        long end = System.nanoTime();
        return end - start;
    }

    public void runAllExperiments() {

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {

            System.out.println("\n=== SIZE: " + size + " ===");

            // рандомик
            int[] randomArr = sorter.generateRandomArray(size);

            long bubbleTime = measureSortTime(randomArr.clone(), "basic");
            long quickTime = measureSortTime(randomArr.clone(), "advanced");

            // отдельная копия для поиска
            int[] sortedForSearch = randomArr.clone();
            sorter.advancedSort(sortedForSearch);

            long searchTime = measureSearchTime(
                    sortedForSearch,
                    sortedForSearch[size / 2]
            );

            System.out.println("Random Array:");
            System.out.println("Bubble Sort Time: " + bubbleTime + " ns");
            System.out.println("Quick Sort Time: " + quickTime + " ns");
            System.out.println("Binary Search Time: " + searchTime + " ns");

            // сортик
            int[] sortedArr = sorter.generateSortedArray(size);

            long bubbleSorted = measureSortTime(sortedArr.clone(), "basic");
            long quickSorted = measureSortTime(sortedArr.clone(), "advanced");

            long searchSorted = measureSearchTime(
                    sortedArr,
                    sortedArr[size / 2]
            );

            System.out.println("\nSorted Array:");
            System.out.println("Bubble Sort Time: " + bubbleSorted + " ns");
            System.out.println("Quick Sort Time: " + quickSorted + " ns");
            System.out.println("Binary Search Time: " + searchSorted + " ns");

            System.out.println("-----------------------------");
        }
    }
}