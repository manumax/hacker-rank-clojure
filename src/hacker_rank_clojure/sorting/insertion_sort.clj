(ns hacker-rank-clojure.sorting.insertion-sort)

;; https://www.hackerrank.com/challenges/insertionsort1

(defn insertion-sort-steps
  ([starting-list]
   (when (seq starting-list)
     (insertion-sort-steps (peek starting-list) (pop starting-list) '())))
  ([v to-parse parsed]
   (lazy-seq
     (let [next-item (peek to-parse)]
       (if (or (nil? next-item) (<= next-item v))
         [(flatten [to-parse v parsed])]
         (cons (flatten [to-parse (peek to-parse) parsed])
               (insertion-sort-steps v (pop to-parse) (conj parsed next-item))))))))

;; https://www.hackerrank.com/challenges/insertionsort2

(defn insertion-sort [list]
  (loop [to-order      (take 2 list)
         to-be-ordered (drop 2 list)
         acc           []]
    (if (seq to-be-ordered)
      (recur (conj (last (doall (insertion-sort-steps to-order))) (first to-be-ordered))
             (rest to-be-ordered)
             (conj acc (concat to-order to-be-ordered))))))


(defn my-iterate [n]
  )