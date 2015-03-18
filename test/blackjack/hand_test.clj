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

(deftest test-hand-total
  (testing "sums hand when just number cards"
    (is (= 17 (total [{:rank 5} {:rank 2} {:rank 10}]))))
  (testing "face cards are 10"
    (is (= 30 (total [{:rank :J} {:rank :Q} {:rank :K}]))))
  (testing "ace is 11 when hand is small"
    (is (= 15 (total [{:rank :A} {:rank 4}]))))
  (testing "ace is 1 when hand is large"
    (is (= 21 (total [{:rank :K} {:rank :A} {:rank 10}])))))
