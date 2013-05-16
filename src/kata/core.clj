(ns kata.core)

(defn strike? [rolls]  (= 10 (first rolls)))
(defn spare?  [rolls]  (= 10 (+ (first rolls)) (second rolls)))
(defn bonus?  [rolls]  (or (strike? rolls) (spare? rolls)))

(defn rest-rolls [rolls]
  (if (strike? rolls)
    (rest rolls)
    (nthrest rolls 2))

(defn frame-score [rolls]
  (reduce + (take  (if (bonus? rolls)) 3 2)) rolls)))

(defn score 
  ( loop [rolls rolls
          n 10
          acc 0]
    (if (zero? remaining-frames)
      acc
      (recur (rest-rolls rolls) (dec n) (+ acc (frame-score rolls))))))
  
