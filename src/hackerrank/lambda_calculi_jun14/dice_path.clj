(ns hackerrank.lambda-calculi-jun14.dice-path)

(def starting-dice
  {:top 1
   :front 2
   :left 3
   :right 4  
   :back 5
   :bottom 6})


(defn rotate-right
  [dice]
  (assoc dice 
         :top (:left dice)
         :right (:top dice)
         :bottom (:right dice)
         :left (:bottom dice)))

(defn rotate-down
  [dice]
  (assoc dice 
         :front (:top dice)
         :bottom (:front dice)
         :back (:bottom dice)
         :top (:back dice)))

(defn max-points
  [bounds dice x y score]
  (condp = bounds
    [x y] (+ (:top dice) score)
    (let [score (+ (:top dice) score)] 
      (max (condp = x
             (first bounds)  -1
             (max-points bounds (rotate-right dice) (inc x) y score))
           (condp = y
             (second bounds) -1
             (max-points bounds (rotate-down dice) x (inc y) score))))))

(defn parse 
  [line]
  (reverse (read-string (str "[" line "]"))))

(defn -main []
  (let [_ (read-line)
        lines (line-seq (clojure.java.io/reader *in*))
        f (comp #(max-points % starting-dice 1 1 0) parse)]
    (println (clojure.string/join "\n" (map f lines)))))
