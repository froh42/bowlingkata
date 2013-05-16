(ns kata.core-test
  (:require [clojure.test :refer :all]
            [kata.core :refer :all] 
            :reload-all :verbose))

(deftest kata-test
  (testing "Wir werfen immer 0 Pins"
    (is  (= 0 (score (repeat 0)))))
  (testing "Wir werfen immer 1 Pin"
    (is  (= 20 (score (repeat 1)))))
  (testing "Wir werfen immer 9 Pins"
    (is  (= 90 (score (cycle '(9 0))))))
  (testing "Wir werfen einen Spare"
    (is  (= 10 (score 
                (concat '(5 5) 	
                        (repeat 0))))))
  (testing "Wir werfen einen Spare gefolgt von 1"
    (is  (= 12 (score 
                (concat '(5 5 1) 	
                        (repeat 0))))))	
  (testing "Strrrrrrrrrike!"
    (is  (= 16 (score (concat '(10 1 2) (repeat 0))))))
  (testing "Strrrrrrrrrike! then lose"
    (is  (= 14 (score (concat '(10 0 2) (repeat 0))))))
  (testing "Strike am Schluss"
    (is  (= 31 (score (concat (repeat 18 1) '(10 1 2))))))
  (testing "Beispiel"
    (is  (= 167 (score '(10 8 2 7 0 7 2 0 9 0 8 10 10 10 9 1 8)))))
  (testing "Perfect game"
    (is  (= 300 (score (repeat 12 10)))))
  (testing "Perfect game"
    (is  (= 300 (score (repeat 10)))))
  )			

(deftest simple-tests
  (testing "Bonus von 5 5 1"
    (is (= true (bonus? '(5 5 1)))))
  (testing "Framescore von 5 5 1"
    (is (= 11 (frame-score '(5 5 1))))) 
  )
