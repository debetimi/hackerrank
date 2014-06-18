(ns hackerrank.number-of-binary-search-tree)

;https://www.hackerrank.com/challenges/number-of-binary-search-tree

(defn number-of-bst
  [nodes]
  (cond
    (= nodes 1) 1
    (< nodes 1) 0
    :else (+ (number-of-bst (- nodes 2))
             (* 2 (number-of-bst (dec nodes))))))

(defn parse 
  []
  (read-string (read-line)))

(defn -main
  []
  (dotimes [i (parse)]
    (println (number-of-bst (parse)))))

(-main)
