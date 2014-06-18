(ns hackerrank.filling-jars)

;https://www.hackerrank.com/challenges/filling-jars


(defn parse
  []
  (map read-string (clojure.string/split (read-line) #" ")))

(defn -main 
  []
  (let [[n, m] (parse)]
    (loop [sums 0 i m]
      (if (zero? i) 
        (println (int (/ sums n))) 
        (let [[a b k] (parse)]
          (recur (+ sums (* k (inc (- b a)))) (dec i)))))))

