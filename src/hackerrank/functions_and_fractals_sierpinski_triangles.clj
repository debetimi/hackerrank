(ns hackerrank.functions-and-fractals-sierpinski-triangles)

;;; https://www.hackerrank.com/challenges/functions-and-fractals-sierpinski-triangle

(defn sub-triangles
  "returns the x y h coordinate of peaks of 3 subtriangles
   [top, left, right]"
  [[x y h]]
  (let [nh (int (/ h 2))
        ny (int (+ y nh))]
    [[x y nh] [(- x nh) ny nh] [(+ x nh) ny nh]]))

(defn coords->index
  "Takes peak coordinates and height and returns
   absolute index of 1's for that triangle"
  [cols [x y h]]
  (for [b (range h)]
    (let [center (+ (* (+ y b) cols) x)]
      (range (- center b) (inc (+ center b))))))

(defn all-triangles 
  "returns x, y of triangle peake
   and height/width of all triangles"
  [coords n]
  (if (zero? n) coords 
    (flatten (map #(all-triangles % (dec n)) (sub-triangles coords)))))

(defn in? 
  "true if coll contains elm else false "
  [coll elm]  
  (boolean (some #(= elm %) coll)))

(defn sierpinski
  "Prints a serpinski triangle"
  [order rows columns]
  (let [triangles (all-triangles [(int (/ columns 2)) 0 rows] order)
        ones (flatten (map (partial coords->index columns) (partition 3 triangles)))] 
    (dotimes [i (* rows columns)]
      (when (and (not (zero? i)) 
                 (= 0 (mod i columns))) 
        (println))
      (if (in? ones i)
        (print "1")
        (print "_")))))
