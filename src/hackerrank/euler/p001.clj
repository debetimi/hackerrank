(ns hackerrank.euler.p001)

(defn sums2
  [n]
  (let [n (dec n)
        m1 (long (Math/floor (/ n 3)))
        m2 (long (Math/floor (/ n 5)))
        m3 (long (Math/floor (/ n 15)))]
    (long (+' (/ (*' m1 (+' 3 (*' m1 3))) 2)
        (/ (* m2 (+' 5 (*' m2 5))) 2)
        (- (/ (*' m3 (+' 15 (*' m3 15))) 2))))))

(defn -main
  []
  (doseq [value (map (comp sums2 read-string) (rest (line-seq (clojure.java.io/reader *in*))))]
    (println value)))
