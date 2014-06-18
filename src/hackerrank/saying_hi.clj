(ns hackerrank.saying-hi)

;https://www.hackerrank.com/challenges/saying-hi

(defn -main
  []
  (let [n (read-string (read-line))]
    (dotimes [i n]
      (let [line (read-line)]
        (if (re-matches #"(?i)hi\s[^d].*" line) 
          (println line))))))


