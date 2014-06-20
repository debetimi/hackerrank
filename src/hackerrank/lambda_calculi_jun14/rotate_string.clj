(ns hackerrank.lambda-calculi-jun14.rotate-string)

;https://www.hackerrank.com/contests/lambda-calculi-jun14/challenges/rotate-string

(defn rotate-indices
  "Produces a lazy-sequence of left-shifts of provided index"
  [index]
  (let [shifted (concat (rest index) (list (first index)))] 
    (cons shifted (lazy-seq (rotate-indices shifted)))))

(defn make-rotation
  [word index]
  (reduce #(str %1 (nth word %2)) "" index))

(defn word-rotations
  [word]
  (let [index (range (count word))]
    (map (partial make-rotation word) (take (count word) (rotate-indices index)))))

(defn -main
  []
  (let [_ (read-line)
        lines (line-seq (clojure.java.io/reader *in*))]
    (println (clojure.string/join "\n" (map (comp #(clojure.string/join " " %) word-rotations) lines)))))
