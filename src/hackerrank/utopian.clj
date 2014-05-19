(ns hackerrank.utopian)

;https://www.hackerrank.com/challenges/utopian-tree
;The Utopian tree goes through 2 cycles of growth every year. The first growth cycle of the tree is during the monsoon season when it doubles in height. The second growth cycle is during the summer when it increases in height by 1 meter. If a new Utopian tree sapling of height 1 meter is planted just before the onset of the monsoon season, can you find the height of the tree after N cycles?

;Input Format
;The first line of the input contains an integer T, the number of test cases. 
;T lines follow with each line containing the integer N, the number of cycles.

;Constraints
;1 <= T <= 10
;0 <= N <= 60

;Output Format
;Print the height of the Utopian tree after N cycles.


(def cycles '(:monsoon :summer))

(defn calculate-height 
  [num-cycles]
  (let [height (atom 1)]
    (doseq [x (take num-cycles (cycle cycles))]
      (case x
        :monsoon (swap! height * 2)
        :summer (swap! height inc)))
    @height))


(defn height-after-n-cycles
  "Calculates the height of Tree after N cycles"
  []
  (let [test-cases (read-string (read-line))]
    (doseq [x (range test-cases)]
      (let [num-cycles (read-string (read-line))]
        (println (calculate-height num-cycles))))))

(height-after-n-cycles)
