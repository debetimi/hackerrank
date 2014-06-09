(ns hackerrank.fp-reverse-a-list)

;;; https://www.hackerrank.com/challenges/fp-reverse-a-list
;;; Reverse a list without using reverse function. The input and output portions will be handled automatically. You need to write a function with the recommended method signature.
;;; 
;;; Input and Output Format
;;; Each element of the list is displayed on a new line.
;;; The output list is the reverse of the input list.
;;; 
;;; Sample Input
;;; 
;;; 19
;;; 22
;;; 3
;;; 28
;;; 26
;;; 17
;;; 18
;;; 4
;;; 28
;;; 0
;;; Sample Output
;;; 
;;; 0
;;; 28
;;; 4
;;; 18
;;; 17
;;; 26
;;; 28
;;; 3
;;; 22
;;; 19
;;; Method Signature
;;; 
;;; Number Of Parameters: 1
;;; Parameters: [list]
;;; Returns: List or Vector
;;; Constraints
;;; List will have N elements, 1<=N<=100.
;;; Each element X will be such that 0<=X<=100.

(defn reverse-list-1
  "Recursively reverse list using loop
   take the first element and cons it
   to accumulator."
  [coll]
  (loop [curr coll reversed []]
    (if (empty? curr)
      reversed
      (recur (rest curr) (cons (first curr) reversed))))) 


(defn reverse-list-2
  "Recursively reverse list using loop. 
   Takes the last element and conj it
   to accumulator. Uses different datastructures
   as than reverse-list-1"
  [coll]
  (loop [curr coll reversed []]
    (if (empty? curr)
      reversed
      (recur (butlast curr) (conj reversed (last curr))))))


(defn reverse-list-3
  "Functionaly reverse list"
  [coll]
  (reduce (fn [acc,elem] (into [elem] acc)) [] coll))
