(ns hackerrank.eval-ex)

(defn factorial
  [n]
  (reduce * (range 1 (inc n))))

(defn nth-order-term 
  [x n]
  (/ (Math/pow x n) (factorial n)))

(defn series-expansion-e-to-the-x
  [x]
  (reduce + (map (partial nth-order-term x) (range 10))))

;; using line-seq
(defn -main
  []
  (let [lines (line-seq (java.io.BufferedReader. *in*))]
    (mapv (comp println #(format "%.4f" %) series-expansion-e-to-the-x read-string) (rest lines))))


