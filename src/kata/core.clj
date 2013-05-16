(ns kata.core)

(defn strike? [rolls]  (= 10 (first rolls)))
(defn spare?  [rolls]  (= 10 (+ (first rolls)) (second rolls)))
(defn bonus?  [rolls]  (or (strike? rolls) (spare? rolls)))

; A frame (other than the last one) can consist of 1 or 2 rolls. One
; roll if the first one is a strike, 2 rolls with a spare or with
; no bonus. So for rest-rolls we remove the correct number of rolls
; from the front of the rolls sequence.
(defn rest-rolls [rolls]
  (if (strike? rolls)
    (rest rolls)              
    (nthrest rolls 2))  

; Depending on whether we need some bonus we calculate a frame score
; by adding 2 rolls (normal) or 3 rolls (strike and spare).
;
; Interstingly both strike and spare are caluclated by summing
; up three rolls: If we have a strike the current frame has only
; one roll and we use two bonus rolls (total: 3), if we have a
; spare the current frame has two rolls and we use one bonus roll.
; (total: 3)
(defn frame-score [rolls]
  (reduce + (take  (if (bonus? rolls)) 3 2)) rolls)))

(defn score 
  ( loop [rolls rolls
          n 10
          acc 0]
    (if (zero? remaining-frames)
      acc
      (recur (rest-rolls rolls) (dec n) (+ acc (frame-score rolls))))))
  
