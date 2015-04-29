(ns hacker-rank-clojure.sorting.insertion-sort
  (:require [hacker-rank-clojure.utils :as utils]))

(defn part-one-step [v to-parse parsed]
  (lazy-seq
    (let [next-item (peek to-parse)]
      (if (or (nil? next-item) (<= next-item v))
        [(concat to-parse [v] parsed)]
        (cons (concat to-parse [(peek to-parse)] parsed)
              (part-one-step v (pop to-parse) (conj parsed next-item)))))))

(defn part-one [starting-list]
  (part-one-step (peek starting-list) (pop starting-list) '()))

(defn run-part-one
  [starting-list]
  (doseq [step (part-one starting-list)]
    utils/pretty-print step))

(defn -main
  []
  (run-part-one [2 4 6 8 3]))