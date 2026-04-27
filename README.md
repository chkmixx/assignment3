Execution Output
A summary of results is included in this README, while the full formatted table can be found in the attached Word document.
[screen.docx](https://github.com/user-attachments/files/27137615/screen.docx)
 Results Table (Summary)

| Size | Bubble (ns) | Quick (ns) | Binary Search (ns) |
|------|------------|------------|--------------------|
| 100  | 123600     | 25700      | 800                |
| 1000 | 2908600    | 83700      | 900                |




Analyses:Which sorting algorithm performed faster? Why?
Quick Sort was faster than Bubble Sort for medium and big arrays. This is because Quick Sort is more efficient (O(n log n)), while Bubble Sort is slow (O(n^2)). But for very small arrays (size 10), Bubble Sort was a bit faster.


How does performance change with input size?
When the size increases:Bubble Sort becomes very slow but Quick Sort is still fast.So Quick Sort works better for large data.

How does sorted vs unsorted data affect performance?
Bubble Sort works faster on sorted arrays
Quick Sort can be slower on sorted arrays because of bad pivot

Do the results match Big-O complexity?
Yes,Bubble Sort is very slow for big arrays.Quick Sort is much faster

Which searching algorithm is more efficient? Why?
Binary Search is more efficient because it works faster (O(log n)) and checks less elements.

Why does Binary Search require a sorted array?
Because it needs order. It compares middle element and decides left or right. Without sorted array, it wont work.

 Reflection:
 
In this project, I learned how different algorithms perform depending on input size and type. I understood that simple algorithms like Bubble Sort are easy to implement but become very slow for large data, while more advanced algorithms like Quick Sort are much more efficient.I also noticed that theoretical complexity (Big-O) is mostly correct, but real execution time can vary depending on input (for example, sorted arrays affected Quick Sort). The main challenge was implementing and testing the algorithms correctly and measuring time using System.nanoTime().
