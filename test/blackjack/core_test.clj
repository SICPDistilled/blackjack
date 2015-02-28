(ns blackjack.core-test
  (:require [clojure.test :refer :all]
            [blackjack.core :refer :all]))

(deftest test-stop-at
  (let [stop-at-10 (stop-at 10)]
    (is (false? (stop-at-10 [5 5] 1)))
    (is (true? (stop-at-10 [2 3] 1)))
    (is (false? (stop-at-10 [6 6] 1)))))

(deftest test-play-hand
  (letfn [(from-start-hand [hand]
            (play-hand (stop-at 12) hand 5))]
    (is (= (from-start-hand [12])
           [12]))
    (is (= (from-start-hand [14])
           [14]))
    (let [from-start-hand-10 (from-start-hand [10])]
      (is (= (first from-start-hand-10)
             10))
      (is (count from-start-hand-10)
          2))))
