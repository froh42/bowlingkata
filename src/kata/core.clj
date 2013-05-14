(ns kata.core)

(defn third [s] (nth s 2)) 

(defn remaining-rolls [rolls]
	(cond
	   (= 10 (first rolls))		(rest rolls)
	   :else 					(nthrest rolls 2)
	)
)	

(defn frame-score [rolls]
	(def framesum (+ (first rolls) (second rolls)))
	(cond
	   (= 10 (first rolls))		(+ 10 (second rolls) (third rolls))		
	   (= 10 framesum) 			(+ framesum (third rolls))
	   :else framesum
	)
)

(defn score-inner [rolls remaining-frames] 
	(cond
		(zero? remaining-frames) 0
		:else	(+ (frame-score rolls)			   
				   (score-inner (remaining-rolls rolls) (dec remaining-frames)))
	)
)

(defn score [rolls] 
	(score-inner rolls 10))
