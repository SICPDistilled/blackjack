(ns blackjack.hand-test
  (:require [clojure.test :refer :all]
            [blackjack.core :refer :all]
            [blackjack.hand :refer :all]))

(deftest test-deck
  (is (= 52 (count full-deck))))

(deftest test-n-shuffled-decks
  (let [two-decks (n-shuffled-decks 2)]
    (testing "correct size"
      (is (= 104 (count two-decks))))
    (testing "is 2 shuffled decks"
      (is (= (set two-decks)
             (set (concat full-deck full-deck)))))))
