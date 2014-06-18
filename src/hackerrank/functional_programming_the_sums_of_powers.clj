(ns hackerrank.functional-programming-the-sums-of-powers)
;https://www.hackerrank.com/challenges/functional-programming-the-sums-of-powers

(defn find-ways 
  [remaining pow cur]
  (let [remaining (- remaining (Math/pow cur pow))] 
    (cond
      (neg? remaining) 0
      (zero? remaining) 1
      :default 
      (let [fw (partial find-ways remaining pow)]
        (reduce + (map fw (range 1 cur)))))))

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


