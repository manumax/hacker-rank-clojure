(ns hacker-rank-clojure.algorithms.sorting.insertion-sort)

;; https://www.hackerrank.com/challenges/insertionsort1

(defn- sort-last-item-step [to-parse pivot parsed]
  (lazy-seq
    (let [next-item (peek to-parse)]
      (if (or (nil? next-item) (<= next-item pivot))
        [(into [] (flatten [to-parse pivot parsed]))]
        (cons (into [] (flatten [to-parse (peek to-parse) parsed]))
              (sort-last-item-step (pop to-parse) pivot (conj parsed next-item)))))))

(defn sort-last-item-steps
  [to-order-list]
  (if-let [pivot (peek to-order-list)]
    (sort-last-item-step (pop to-order-list) pivot '())))

;; https://www.hackerrank.com/challenges/insertionsort2

(defn- fast-sort-last-item-step [to-order]
  (let [pivot (peek to-order)
        xs    (pop to-order)
        smaller? #(< % pivot)]
    (into [] (concat (filter smaller? xs)
                     [pivot]
                     (remove smaller? xs)))))

(defn- insertion-sort-step [to-order to-be-ordered]
  (lazy-seq
    (let [last-insertion-step (fast-sort-last-item-step to-order)]
      (if (not (seq to-be-ordered))
        [last-insertion-step]
        (cons (into last-insertion-step to-be-ordered)
              (insertion-sort-step (conj last-insertion-step (first to-be-ordered))
                                   (rest to-be-ordered)))))))

(defn insertion-sort [to-order-list]
  (if (<= (count to-order-list) 1)
    to-order-list
    (insertion-sort-step (into [] (take 2 to-order-list))
                         (into [] (drop 2 to-order-list)))))

(defn -main
  []
  (let [random-list (take 100 (repeatedly #(rand-int 100)))]
    (time (doseq [step (insertion-sort random-list)]
            (println step)))))