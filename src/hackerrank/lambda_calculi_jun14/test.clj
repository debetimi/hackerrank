(ns hackerrank.euler.p1)


;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;; Find the sum of all the multiples of 3 or 5 below 1000.


(defn sums_of_multiples_of_3_and_5
  [n]
  (apply +' (filter #(or (= 0 (mod % 5)) (= 0 (mod % 3))) (range 1 n))))


