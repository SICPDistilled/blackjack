(ns blackjack.simple-hand)

(defn deal []
  (inc (rand-int 10)))

(defn new-hand [] [(deal)])

(defn up-card [hand]
  (first hand))

(defn add-card [hand card]
  (conj hand card))

(defn total [hand]
  (reduce + hand))
