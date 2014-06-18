(ns hackerrank.filling-jars)

;https://www.hackerrank.com/challenges/filling-jars


(defn parse
  []
  (map read-string (clojure.string/split (read-line) #" ")))

(defn -main 
  []
  (let [[n, m] (parse) 
        sums (vec (repeat n 0))]
    (loop [sums sums i m]
      (if (zero? i) (println (int (/ (reduce + sums) (count sums)))) 
        (let [[a b k] (parse)]
          (recur (reduce #(update-in %1 [%2] + k) sums (range (dec a) b)) (dec i)))))))
