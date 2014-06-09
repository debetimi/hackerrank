(ns hackerrank.pascals-triangle)

;;; https://www.hackerrank.com/challenges/pascals-triangle
;;; For a given integer K, print the first K rows of Pascal’s Triangle. Print each row with values separated by spaces. The value at nthrow and rth column of the triangle is equal to n! / (r! * (n-r)!) where indexing start from 0. These values are the binomial coefficients.
;;; 
;;; The Pascal Triangle
;;; 
;;; 1
;;; 1 1
;;; 1 2 1
;;; 1 3 3 1
;;; 1 4 6 4 1
;;; ....
;;; Input Format
;;; A Single Integer, K.
;;; 
;;; Constraints
;;; 
;;; 2 <= K <=10
;;; 
;;; And, you need to accomplish this without directly defining any local variables. For example, var and val have been blocked in Scala; def and defn are blocked in Clojure.
;;; 
;;; Output Format
;;; 
;;; The first K rows of the Pascal Triangle.
;;; 
;;; Sample Input
;;; 
;;; 4 
;;; Sample Output
;;; 
;;; 1 
;;; 1 1 
;;; 1 2 1 
;;; 1 3 3 1  

(defn factorial 
  "Calculates factorial using reduce"
  [n]
  (reduce * (map inc (range n))))

(defn zip
  "Performs zip operation on two lists turning
   [l1, l2, l3], [l4, l5, l6] into [[l1, l4], [l2, l5], [l3, l6]]"
  [l1 l2]
  (map vector l1 l2))

(defn pascal-value
  "Uses parameter destructuring on input to extract
   row and colum from provided vector"
  [[r c]]
  (/ (factorial r) (* (factorial c) (factorial (- r c)))))

(defn pascal-triangle
  "Returns a pascal triangle a list of lists.  "
  [n]
  (for [i (range n)]
    (let [j (inc i)]
      (map pascal-value (zip (take j (repeat i)) (range j))))))

(defn print-triangle
  [triangle]
  (doseq [row triangle]
    (println (clojure.string/join " " row))))

(defn run 
  []
  (let [n (read-string (read-line))]
    (print-triangle (pascal-triangle n))))

(run)
