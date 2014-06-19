(ns hackerrank.eval-ex)

(defn factorial
  [n]
  (reduce * (range 1 (inc n))))

(defn nth-order-term 
  [x n]
  (/ (Math/pow x n) (factorial n)))

(defn series-expansion-e-to-the-x
  [x]
  (println (format "%.4f" (reduce + (map (partial nth-order-term x) (range 10))))))


;; can simplify (read-string (read-line)) to (read)
(defn -main 
  [] 
  (let [n (read-string (read-line))]
    (dotimes [_ n]
      (let [x (read-string (read-line))] 
        (series-expansion-e-to-the-x x)))))


