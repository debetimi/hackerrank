(ns hackerrank.lambda-calculi-jun14.mango)

;https://www.hackerrank.com/contests/lambda-calculi-jun14/challenges/mango

(defn eaten 
  [invited appetite happiness]
  (+' appetite (* (dec invited) happiness)))

(defn min-mangos-k-friends
  [k appetites happiness]
  (reduce +' (take k (sort (map (partial eaten k) appetites happiness)))))

(defn max-friends
  [num-friends mangos appetites happinesses]
  (loop [low 1 high num-friends]
    (let [k (int (/ (+ high low) 2)) 
          min-mangos-eaten (min-mangos-k-friends k appetites happinesses)]
      (cond
        (= mangos min-mangos-eaten) k
        (and (= k high) (> mangos min-mangos-eaten))  k
        (and (= k low) (< mangos min-mangos-eaten)) (dec k) 
        :else (let [[nl nh] (cond 
                              (> mangos min-mangos-eaten) [(inc k) high]
                              :else [low k])]
                (recur nl nh))))))

(defn parse-vec [] (read-string (str "[" (read-line) "]")))

(defn -main
  []
  (let [[num-friends mangos] (parse-vec)
        appetites (parse-vec) 
        happinesses (parse-vec)]
    (println (max-friends num-friends mangos appetites happinesses))))
