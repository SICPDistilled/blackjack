(ns blackjack.hand)

(def full-deck
  (for [suit [:hearts :spades :diamonds :clubs]
        rank (concat (range 2 11) [:J :Q :K :A])]
    {:suit suit
     :rank rank}))

(def deck (atom {}))

(defn n-shuffled-decks [n]
  (shuffle (apply concat (take n (repeat full-deck)))))

(defn reset-deck! []
  (reset! deck (n-shuffled-decks 4)))

(defn deal []
  (first (swap! deck rest)))

(defn new-hand []
  [(deal)])

(defn up-card [hand]
  (first hand))

(defn add-card [hand card]
  (conj hand card))

(defn total [hand]
  (defn ace? [card]
    (= :A (:rank card)))
  (defn score [{rank :rank}]
    (if (number? rank)
                  rank
                  10))
  (let [aces (filter ace? hand)
        subtotal
          (->> hand
            (remove ace?)
             (map score)
             (reduce + 0))]
    (reduce (fn [score _]
              (if (> (+ score 11) 21)
                (+ score 1)
                (+ score 11)))
            subtotal
            aces)))
