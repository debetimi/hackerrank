(ns hackerrank.contests-w5-challenges-even-odd-query)

(defn findf
  [coll [x y]]
  (cond
    (zero? (nth coll x))  0
    :else (nth coll (- x 1))))

(defn even-or-odd
  [result]
  (cond 
    (even? result) "Even"
    :else "Odd"))

(defn parse
  [line]
  (read-string (str "[" line "]")))

(defn -main
  []
  (let [_ (read-line)
        coll (mapv read-string (clojure.string/split (read-line) #"\s"))
        n (read-string (read-line))
        f (partial findf coll)]
    (dotimes [_ n]
      (println ((comp even-or-odd f parse) (read-line))))))
