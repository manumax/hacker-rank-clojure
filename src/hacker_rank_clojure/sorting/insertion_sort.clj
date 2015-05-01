(ns hacker-rank-clojure.sorting.insertion-sort)

;; https://www.hackerrank.com/challenges/insertionsort1

(defn lazy-insertion-sort-steps
  ([starting-list]
   (when (seq starting-list)
     (lazy-insertion-sort-steps (peek starting-list) (pop starting-list) '())))
  ([v to-parse parsed]
   (lazy-seq
     (let [next-item (peek to-parse)]
       (if (or (nil? next-item) (<= next-item v))
         [(flatten [to-parse v parsed])]
         (cons (flatten [to-parse (peek to-parse) parsed])
               (lazy-insertion-sort-steps v (pop to-parse) (conj parsed next-item))))))))


(defn insertion-sort-steps
  [to-order-list]
  (if-let [pivot (peek to-order-list)]
    (loop [to-parse (pop to-order-list)
           parsed   '()
           acc      []]
      (let [next-item (peek to-parse)]
        (if (or (nil? next-item) (<= next-item pivot))
          (conj acc (into [] (flatten [to-parse pivot parsed])))
          (recur (pop to-parse)
                 (conj parsed next-item)
                 (conj acc (into [] (flatten [to-parse (peek to-parse) parsed])))))))))

;; https://www.hackerrank.com/challenges/insertionsort2

(defn insertion-sort [to-order-list]
  (if (<= (count to-order-list) 1)
    to-order-list
    (loop [to-order      (into [] (take 2 to-order-list))
           to-be-ordered (into [] (drop 2 to-order-list))
           acc           []]
      (let [last-insertion-step (last (insertion-sort-steps to-order))]
        (if (not (seq to-be-ordered))
          (conj acc last-insertion-step)
          (recur (conj last-insertion-step (first to-be-ordered))
                 (rest to-be-ordered)
                 (conj acc (into last-insertion-step to-be-ordered))))))))