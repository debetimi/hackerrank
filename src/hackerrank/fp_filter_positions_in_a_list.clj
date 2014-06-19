(ns hackerrank.fp-filter-positions-in-a-list)

;https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list

(defn filter-even-indices
  [coll]
  (take-nth 2 (rest coll)))
