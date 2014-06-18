(ns hackerrank.functional-programming-the-sums-of-powers)

(defn find-ways 
  [remaining pow cur]
  (let [raised (Math/pow cur pow)] 
    (cond
      (> raised remaining) 0
      (= raised remaining) 1
      :default 
      (let [rem2 (- remaining raised)
            fw (partial find-ways rem2 pow)]
        (reduce + (map fw (range cur)))))))

(defn sum-of-powers
  [sum power]
  (let [max-int (int (Math/pow sum (/ 1 power)))
        fw (partial find-ways sum power)]
    (reduce + (map fw (range 1 (inc max-int))))))


(defn -main
  []
  (let [sum (read-string (read-line))
        power (read-string (read-line))]
    (println (sum-of-powers sum power))))


